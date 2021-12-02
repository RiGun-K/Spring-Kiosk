package com.example.teamproject.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="o_detail")
public class O_Detail {
   @Id
   private String orderdetailid;
   
   @Column(nullable = false)
   private int amount;
   
   @ManyToOne(targetEntity = Menu.class)
   @JoinColumn(nullable = false,  name="menuid")
   private Menu menuid;
   
   @ManyToOne(targetEntity = Ordered.class)
   @JoinColumn(nullable = false,  name="orderid")
   private Ordered orderid;

   public String getOrderdetailid() {
      return orderdetailid;
   }

   public void setOrderdetailid(String orderdetailid) {
      this.orderdetailid = orderdetailid;
   }

   public int getAmount() {
      return amount;
   }

   public void setAmount(int amount) {
      this.amount = amount;
   }
}