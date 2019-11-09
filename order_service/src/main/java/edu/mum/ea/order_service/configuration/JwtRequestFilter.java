package edu.mum.ea.order_service.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {


	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	public static String username = null; 

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		final String requestTokenHeader = request.getHeader("Authorization");
				System.out.println(requestTokenHeader);
		
		String jwtToken = null;

		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = jwtTokenUtil.getUserNameFromJwtToken(jwtToken);
				System.out.println(username);

				// filterChain.doFilter(request, response);
				
			} catch (IllegalArgumentException e) {
				System.out.println("Unable to get JWT Token");
			} catch (ExpiredJwtException e) {
				System.out.println("JWT Token has expired");
			}
		} else {
			logger.warn("JWT Token does not begin with Bearer String");
		}

		if(requestTokenHeader.equals(null) || requestTokenHeader.equals(" ") ){
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
		}

		filterChain.doFilter(request, response);
	}
}