package com.example.teamproject.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.teamproject.repository.KindRepository;
import com.example.teamproject.repository.MenuRepository;
import com.example.teamproject.repository.O_DetailRepository;
import com.example.teamproject.repository.OrderedRepository;
import com.example.teamproject.repository.UserRepository;
import com.mysql.cj.protocol.Security;
import com.example.teamproject.config.SecurityConfig;
import com.example.teamproject.data.Kind;
import com.example.teamproject.data.Menu;
import com.example.teamproject.data.ODprocess;
import com.example.teamproject.data.O_Detail;
import com.example.teamproject.data.Ordered;
import com.example.teamproject.data.Result;
import com.example.teamproject.data.User;




@RestController
@RequestMapping("/api")
public class ApiController {
	
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	MenuRepository menuRepository;
	@Autowired
	private KindRepository kindRepository;
	@Autowired
	OrderedRepository orderedRepository;
	@Autowired
	O_DetailRepository o_detailRepository;
	
	
	@PostMapping("/register")
	public User addUser(@RequestBody User user, SecurityConfig sc) {
		// 추후 DB 코드 추가 = 아이디,이름 값이 저장버튼으로 넘어온 데이터를 받아서 DB에 Insert
		
		String password = sc.passwordEncoder().encode(user.getPassword());
		user.setPassword(password);
		
		if(user.getSavedTime()==null)
			user.setSavedTime(LocalDateTime.now());
		userRepository.save(user);
		return user;
	}
	
	@PostMapping("/pregister")
	public Menu addPregister(@RequestBody Menu menu) {
		// 추후 DB 코드 추가 = 아이디,이름 값이 저장버튼으로 넘어온 데이터를 받아서 DB에 Insert
		
		if(menu.getSavedTime()==null)
			menu.setSavedTime(LocalDateTime.now());
		menuRepository.save(menu);
		return menu;
	}
	
	@DeleteMapping("/delete")
	public Menu deletePregister(@RequestBody Menu menu) {
		
		// 테이블에 menuid 가 있는지 확인 
		Optional<Menu> m = menuRepository.findById(menu.getMenuid());
		// 있으면 삭제
		if (m.isPresent()) {		
			menuRepository.deleteById(m.get().getMenuid());		
		} 
		return menu;
	}

	@PutMapping("/modify")
	public Menu modifyPregister(@RequestBody Menu menu) {
		
		Optional<Menu> searchedMenu = menuRepository.findById(menu.getMenuid());
		// 메뉴가 존재하는 경우.
		
		// 기존값에서 api로 받은 값으로 수정 
		searchedMenu.get().setMenuname(menu.getMenuname());
		searchedMenu.get().setKind(menu.getKind());
		searchedMenu.get().setPrice(menu.getPrice());
		searchedMenu.get().setStock(menu.getStock());
		searchedMenu.get().setEx(menu.getEx());
		searchedMenu.get().setHide(menu.getHide());
		menuRepository.save(menu);
		
		return menu;
	}
	
	@PostMapping("/login")
	public Result loginUser(@RequestBody User user) {
		Optional<User> searchedMember = userRepository.findById(user.getUserid());
		if(searchedMember.isPresent()) {
			// 객체끼리 값을 비교 ( 비밀번호가 같은지 )
			if(searchedMember.get().getPassword().equals(user.getPassword())) {
				return new Result("ok");
			} else { // 비번 틀림.
				return new Result("ng");
			}
			
		} else { // 등록되지 않은 사용자.
				return new Result("ng");
		}
		
	}
	
	//index.html에서 각각의 카테고리버튼을 눌렀을 때 실행
	@PostMapping("/index")
	public List<Menu> index(@RequestBody Menu menu) {
		System.out.println("Sucesses");
		List<Menu> kindmenu2 = menuRepository.findAll();
		if(menu.getKind().getKindid() == 0) {
			return kindmenu2;
		}
		else {
		List<Menu> kindmenu = menuRepository.findByKind(menu.getKind());
		
		return kindmenu;
		}
	}
	
	//index.html에서 '결제화면으로 이동' 눌렀을 때 실행
	@PostMapping("/odetail")
	public Ordered detail(@RequestBody ODprocess pro) {
		Ordered od = new Ordered();
		if(pro.getTime()==null)
			od.setOrderedTime(LocalDateTime.now());
		od.setTotalsum(pro.getSum());
		od.setPayway(pro.getPay());
		orderedRepository.save(od);
		
		O_Detail odd = new O_Detail();
		for(int i=0; i<pro.getBamount().length; i++) {
			Optional<Menu> m = menuRepository.findById(pro.getBasket()[i]);
			Menu menu = new Menu();
			m.get().setStock(m.get().getStock()-pro.getBamount()[i]);
			menu.setMenuid(m.get().getMenuid());
			menu.setMenuname(m.get().getMenuname());
			menu.setStock(m.get().getStock());
			menu.setPrice(m.get().getPrice());
			
			List<Ordered> ol = orderedRepository.findAll(Sort.by(Sort.Direction.ASC, "orderedid"));
			Ordered o = new Ordered();
			if( !ol.isEmpty() ) {
				o = ol.get(ol.size()-1);
			}
			
			odd.setMenuid(menu);
			odd.setOrderedid(od);
			// 주문번호(6자리) + 메뉴id(2자리) 를 매핑테이블의 pk로 설정
			odd.setOrderdetailid(String.format(String.format("%06d", o.getOrderedid())+"%02d", pro.getBasket()[i]));
			odd.setAmount(pro.getBamount()[i]);
			o_detailRepository.save(odd);
		}
		System.out.println(od);
		return od;
	}
	

}
