package com.OnlineStore.OnlineStore.models.entity;

import javax.validation.constraints.Min;

public class CartItemDto  {

		private Long productId;
		@Min(value = 1, message = "Must be 0 mín value")
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
