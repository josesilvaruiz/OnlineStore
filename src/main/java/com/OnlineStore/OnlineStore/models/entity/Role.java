package com.OnlineStore.OnlineStore.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "authorities", uniqueConstraints= {@UniqueConstraint(columnNames={"user_id", "authority"})})
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String authority;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
