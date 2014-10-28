package org.lalosuarez.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.opensymphony.xwork2.ActionContext;

public class AuthenticationServiceProvider implements UserDetailsService {
	
	private UserService service;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			org.lalosuarez.app.dto.User user = service.find(username);
					
			List<GrantedAuthority> authorities = buildUserAuthority(getAuthorities(user.getRole().getRole()));
			
            if (user != null) {
                Map<String, Object> session = ActionContext.getContext().getSession();
                session.put("username", new String(user.getUsername()));
                session.put("role", new String(user.getRole().getRole()));
            }
			
            return buildUserForAuthentication(user, authorities);
			
		} catch (Exception e) {

			throw new RuntimeException(e);
		}
	}


    private Set<String> getAuthorities(String role) {
    	Set<String> roles = new HashSet<String>(Arrays.asList(role));
        return roles;
    }

    private static List<GrantedAuthority> buildUserAuthority(Set<String> roles) {
    	Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
    	
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        
        List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(authorities);
        
        return result;
    }
    
	/* Converts com.mkyong.users.model.User user to
	 * org.springframework.security.core.userdetails.User
	 */
	private User buildUserForAuthentication(org.lalosuarez.app.dto.User user, List<GrantedAuthority> authorities) {
		return new User(user.getUsername(),user.getUsername(), user.isEnabled(), true, true, true, authorities);
	}
		
	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}
	
}
