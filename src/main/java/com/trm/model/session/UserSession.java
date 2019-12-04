package com.trm.model.session;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserSession extends User implements java.io.Serializable{

	private SessionBean session;
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public UserSession(String username, String password,String phone, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}
	
	public UserSession(String username, String password,String phone, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities, SessionBean session) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.session = session;
	}


	public SessionBean getSession() {
		return session;
	}


	public void setSession(SessionBean session) {
		this.session = session;
	}
	
	

}
