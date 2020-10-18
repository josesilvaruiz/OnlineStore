package com.OnlineStore.OnlineStore.models.entity;

public class CartItem {

	private Long productId;

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

	private Integer quantity;
}
