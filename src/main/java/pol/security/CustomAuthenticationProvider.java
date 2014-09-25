package pol.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import pol.entity.UserEntity;
import pol.user.service.UserService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	UserService userService;
	
	
	public Authentication authenticate(Authentication arg0)
			throws AuthenticationException {
		UserEntity user = userService.getUserByLogin(arg0.getName());
		if(user == null){
			throw new BadCredentialsException("Nie poprawny login lub haslo.");
		}
		if (!arg0.getCredentials().equals(user.getPassword())){
			throw new BadCredentialsException("Nie poprawny login lub haslo.");
		}
		
		Collection<? extends GrantedAuthority> authorities = user.getRoles();
		return new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPassword(), authorities);
	}

	public boolean supports(Class<?> arg0) {
		return arg0.equals(UsernamePasswordAuthenticationToken.class);
	}

}
