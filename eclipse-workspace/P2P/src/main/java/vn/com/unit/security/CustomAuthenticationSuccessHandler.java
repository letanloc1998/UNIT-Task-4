package vn.com.unit.security;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (roles.contains("ROLE_ADMIN")) {
        	setDefaultTargetUrl("/admin/home");
        	super.onAuthenticationSuccess(request, response, authentication);
        }
        if (roles.contains("ROLE_VENDOR")) {
        	setDefaultTargetUrl("/shop/home");
        	super.onAuthenticationSuccess(request, response, authentication);
        }
        if (roles.contains("ROLE_USER")) {
        	setDefaultTargetUrl("/");
        	super.onAuthenticationSuccess(request, response, authentication);
        }
		
		
		
		
	}
	
	
	
}
