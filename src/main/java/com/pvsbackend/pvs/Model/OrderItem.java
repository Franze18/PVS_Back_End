package com.pvsbackend.pvs.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orderitemtbl")

public class OrderItem {

    private @Id 
    @GeneratedValue Long id;
        private  Long orderId;
        private Long productId;
        private int pnum;
        private String desc;
        private String pmeth;
        private String msg;
        private int quantity ;
        private double price;
    
        OrderItem(){}
        public OrderItem(String desc, String msg, Long orderId, String pmeth, int pnum, double price, Long productId, int quantity) {
            this.desc = desc;
            this.msg = msg;
            this.orderId = orderId;
            this.pmeth = pmeth;
            this.pnum = pnum;
            this.price = price;
            this.productId = productId;
            this.quantity = quantity;
        }
        //getters

        public Long getId() {
            return id;
        }

        public Long getOrderId() {
            return orderId;
        }

        public Long getProductId() {
            return productId;
        }

        public int getPnum() {
            return pnum;
        }

        public String getDesc() {
            return desc;
        }

        public String getPmeth() {
            return pmeth;
        }

        public String getMsg() {
            return msg;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getPrice() {
            return price;
        }

        //setters
        public void setOrderId(Long orderId) {
            this.orderId = orderId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }

        public void setPnum(int pnum) {
            this.pnum = pnum;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public void setPmeth(String pmeth) {
            this.pmeth = pmeth;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public void setPrice(double price) {
            this.price = price;
        }
        
        
}
