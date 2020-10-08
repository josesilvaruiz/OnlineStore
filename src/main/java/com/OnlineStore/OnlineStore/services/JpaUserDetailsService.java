package com.OnlineStore.OnlineStore.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.OnlineStore.OnlineStore.dao.IUserDao;
import com.OnlineStore.OnlineStore.models.entity.Role;
import com.OnlineStore.OnlineStore.models.entity.User;

@Service("jpaUserDetailsService")

public class JpaUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserDao userDao;


	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userDao.findbyUsername(email);
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(Role role: user.getRole()) {
			authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.getEnabled(), true, true, true, authorities);
	}
}
