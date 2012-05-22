package com.tyland.domain;

import java.util.Date;
import java.util.Set;

public class Order {

		private Integer id;
		private String orderCode;
		private String receivePeopleName;
		private String address;
		private String postCode;
		private String call;
		private Date createTime;
		private Date approvlTime;

		private Integer status;//0:已创建; 1:已提交;  2:审批通过; 3:审批拒绝
		private String order_comment;
		
		private User create_user;
		private User approvl_user;
		
		public Set<OrderItem> itemSet;

		private int allItemCount;
		public int getAllItemCount() {
			int count = 0;
			for (OrderItem item : itemSet) {
				count += item.number;
			}
			return count;
		}
		
		private int allItemPrice;
		public int getAllItemPrice() {
			int price = 0;
			for (OrderItem item : itemSet) {
				price += item.number * item.getProduct().getPrize();
			}
			return price;
		}
		
		public Integer getId() {
			return id;
		}
		public User getApprovl_user() {
			return approvl_user;
		}
		public void setApprovl_user(User approvlUser) {
			approvl_user = approvlUser;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getOrderCode() {
			return orderCode;
		}
		public void setOrderCode(String orderCode) {
			this.orderCode = orderCode;
		}
		public String getReceivePeopleName() {
			return receivePeopleName;
		}
		public void setReceivePeopleName(String receivePeopleName) {
			this.receivePeopleName = receivePeopleName;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getPostCode() {
			return postCode;
		}
		public void setPostCode(String postCode) {
			this.postCode = postCode;
		}
		public String getCall() {
			return call;
		}
		public void setCall(String call) {
			this.call = call;
		}
		public Date getCreateTime() {
			return createTime;
		}
		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}
		public Date getApprovlTime() {
			return approvlTime;
		}
		public void setApprovlTime(Date approvlTime) {
			this.approvlTime = approvlTime;
		}
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}

		public String getOrder_comment() {
			return order_comment;
		}
		public void setOrder_comment(String orderComment) {
			order_comment = orderComment;
		}
		
		public User getCreate_user() {
			return create_user;
		}
		public void setCreate_user(User createUser) {
			create_user = createUser;
		}
		public Set<OrderItem> getItemSet() {
			return itemSet;
		}
		public void setItemSet(Set<OrderItem> itemSet) {
			this.itemSet = itemSet;
		}	
		
	}

