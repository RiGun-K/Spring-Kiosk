package com.example.teamproject.data;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ordered")
public class Ordered {
   
   @Id
   private String orderedid;
   @Column(nullable=false)
   private int totalsum;
   @Column
   private LocalDateTime orderedTime;
   
   @OneToMany
   @JoinColumn(name = "orderid")
   private List<O_Detail> details;

   public Ordered() {}
   public Ordered(String orderedid, int totalsum, LocalDateTime orderedTime) {
      this.orderedid = orderedid;
      this.totalsum = totalsum;
      this.orderedTime = orderedTime;
   }
   
   public String getOrderedid() {
      return orderedid;
   }
   public void setOrderedid(String orderedid) {
      this.orderedid = orderedid;
   }
   public int getTotalsum() {
      return totalsum;
   }
   public void setTotalsum(int totalsum) {
      this.totalsum = totalsum;
   }
   public LocalDateTime getOrderedTime() {
      return orderedTime;
   }
   public void setOrderedTime(LocalDateTime orderedTime) {
      this.orderedTime = orderedTime;
   }
   

   
}