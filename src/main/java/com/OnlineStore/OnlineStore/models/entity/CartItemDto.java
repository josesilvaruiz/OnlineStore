package com.OnlineStore.OnlineStore.models.entity;

public class CartItemDto  {

		private Long productId;
		
		private Integer quantity;

		public Long getProductId() {
			return productId;
		}

		public void setProductId(Long id) {
			this.productId = id;
		}

		public Integer getQuantity() {
			return quantity;
		}

		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
}
