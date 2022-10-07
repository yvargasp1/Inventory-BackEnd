package co.edu.ucentral.serviciozuul.oauth;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableResourceServer
//@CrossOrigin("http://localhost:4200")
//@RequestMapping("/token")
//@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST , RequestMethod.DELETE})
//@CrossOrigin(origins = "http://localhost:4200")
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore());
	}

	

	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		tokenConverter.setSigningKey("algun_codigo_secreto_aeiou");
		return tokenConverter;
	}
	
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource(){
//		CorsConfiguration corsConfig = new CorsConfiguration();
//		corsConfig.setAllowedOrigins(Arrays.asList("*"));
//		corsConfig.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
//		corsConfig.setAllowCredentials(true);
//		corsConfig.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
//		
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", corsConfig);
//		return source;
		 CorsConfiguration configuration = new CorsConfiguration();
	        configuration.setAllowedOrigins(Arrays.asList("*"));
	        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
	        
	        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS", "DELETE", "PUT", "PATCH"));
	        configuration.setAllowedHeaders(Arrays.asList("X-Requested-With", "Origin", "Content-Type", "Accept", "Authorization"));
	        configuration.setAllowCredentials(true);
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", configuration);
	        
	        
	        return source;
	}

	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter(){
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}
//	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/api/security/**").permitAll()
		.antMatchers(HttpMethod.GET,"/api/estudiantes/uploads/img/{id}").permitAll()
		.antMatchers(HttpMethod.GET,"/api/docentes/uploads/img/{id}").permitAll()
		.antMatchers(HttpMethod.GET,"/api/modulos","/api/estudiantes","/api/usuarios","/api/docentes", "/api/departamento","/api/inventarios/", 
				"/api/cursos","/api/facultad","/api/examen"
				).permitAll()
		.antMatchers(HttpMethod.GET,"/api/estudiantes/pagina","/api/docentes/pagina","/api/departamento/pagina","/api/facultad/pagina" ,"/api/examen/pagina" ,"/api/departamento/obtener-curso" ,"/api/inventarios/pagina" ,"/api/usuarios/**"
		
		).permitAll()
//		.antMatchers(HttpMethod.GET,"/api/estudiantes/{id}","/api/docentes/{id}","/api/departamento/{id}","/api/facultad/{id}").hasAnyRole("USER","ADMIN")
		.antMatchers("/api/estudiantes/**","/api/docentes/**","/api/modulos/**","/api/departamento/**",
				"/api/cursos/**","/api/inventarios/**" ,"/api/facultad/**", "/api/usuarios/**","/api/examen/**").permitAll().anyRequest().authenticated();
		
//		hasRole("ADMIN")
//		.anyRequest().authenticated()
//		.and().cors().configurationSource(corsConfigurationSource());
	}
	
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/api/security/**").permitAll()
//				.antMatchers("/api/estudiantes/**", "/api/docentes/**", "/api/modulos/**", "/api/departamento/**",
//						"/api/cursos/**", "/api/facultad/**", "/api/usuarios/**","/api/examen/**")
//				.permitAll().anyRequest().authenticated().anyRequest().authenticated()
//				;
//	}
//	
//	@Bean
//	public JwtTokenStore tokenStore() {
//		return new JwtTokenStore(accessTokenConverter());
//	}
//	@Bean
//	public JwtAccessTokenConverter accessTokenConverter() {
//		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
//		tokenConverter.setSigningKey("algun_codigo_secreto_aeiou");
//		return tokenConverter;
//	}
}
