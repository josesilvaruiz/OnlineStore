package com.OnlineStore.OnlineStore.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="orders")
public class Order implements Serializable {
		
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)	
	    private Long id;
		
		@Column(name="create_at")
		@Temporal(TemporalType.DATE)
		private Date createAt;
		
		@PrePersist
		public void prePersist() {
			createAt = new Date();
		}
	
		@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		@JoinColumn(name = "order_id")
		private List<OrderItem> orderItem;
		
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "user_id", referencedColumnName = "id")
		private User user;
		
		private float total;
		
		public Order() {
			orderItem = new ArrayList<OrderItem>();
		}
		
		
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
		
		public Date getCreateAt() {
			return createAt;
		}


		public void setCreateAt(Date createAt) {
			this.createAt = createAt;
		}


		public float getTotal() {
			return total;
		}


		public void setTotal(float total) {
			this.total = total;
		}
}
