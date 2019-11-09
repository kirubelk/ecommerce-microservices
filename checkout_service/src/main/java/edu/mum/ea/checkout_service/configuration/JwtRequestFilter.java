package edu.mum.ea.checkout_service.configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
        final String requestTokenHeader = request.getHeader("Authorization");
		
			System.out.println("called once");
			logger.warn("tokne" + requestTokenHeader);
		if(!requestTokenHeader.equals("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJraXJ1YmVsIiwiaWF0IjoxNTczMjU3NjcwLCJleHAiOjE1NzMyNTc3NTd9.P-tsfMhp4G-LYkPHdIXBvSrwYeOKO38fA_Xd4fW_2ab857WLHddjGu4PpRpjhO7oyxQVvfm3YZi30N9EfRrztA")){
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
		}

		filterChain.doFilter(request, response);

	}
}