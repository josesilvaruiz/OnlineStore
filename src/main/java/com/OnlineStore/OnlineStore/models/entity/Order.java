package com.OnlineStore.OnlineStore.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
	@Entity
	public class Order implements Serializable {
		
		private static final long serialVersionUID = 1L;

		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

		public Order() {
			orderItem = new ArrayList<OrderItem>();
		}
		
		@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		@JoinColumn(name = "order_id")
		private List<OrderItem> orderItem;
		
		@OneToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "user_id", referencedColumnName = "id")
		private User user;
		
		
		public List<OrderItem> getOrderItem() {
			return orderItem;
		}

		public void setOrderItem(List<OrderItem> orderItem) {
			this.orderItem = orderItem;
		}
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
}
