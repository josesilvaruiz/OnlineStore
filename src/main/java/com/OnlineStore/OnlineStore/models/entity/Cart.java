package com.OnlineStore.OnlineStore.models.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Cart {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "products_carts",
        joinColumns = @JoinColumn(
            name = "product_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(
            name = "cart_id", referencedColumnName = "id"))
    private Collection < Product > productlist;
	
	
}
	