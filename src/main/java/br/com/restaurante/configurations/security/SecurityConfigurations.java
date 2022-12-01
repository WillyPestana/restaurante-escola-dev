package br.com.restaurante.configurations.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.restaurante.configurations.security.filter.AutenticacaoViaTokenFilter;
import br.com.restaurante.repository.UsuarioRepository;
import br.com.restaurante.service.authentication.AutenticacaoService;
import br.com.restaurante.service.token.TokenService;

@EnableWebSecurity
@Configuration 
public class SecurityConfigurations extends WebSecurityConfigurerAdapter { 
	
	@Autowired
	private AutenticacaoService autenticacaoService;
	
	@Autowired
	private TokenService tokenservice;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	@Bean //com o @Bean, o spring sabe que este metodo devolve o AuthenticationManager para ser usado na injecao de dependencias
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager(); //como tem o super, este metodo vem da classe pai, da classe que estamos herdando (extends)
	}
	
	//Configuracoes de Autenticacao
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(autenticacaoService) //uerDetailsService diz para o spring qual é a classe que tem a logica de autenticacao
			.passwordEncoder(new BCryptPasswordEncoder());
	}		
	
	//Configuracoes de Autorizacao
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().
		and().
			authorizeRequests()
			.antMatchers(HttpMethod.POST, "/auth").permitAll() //autenticacao usuario
			.anyRequest().authenticated() //qualquer outra requisicao(url) precisa estar autenticada
		.and() //AUTENTICACAO MODO WEB TOKEN
			.csrf().disable() //desabilitamos porque nossa aplicação ja esta livre do tipo de ataque csrf, porque estamos usando autenticacao via token
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //avisamos pro spring que quando fizer autenticacao, nao eh pra criar sessao, porque vamos usar token (autenticacao de maneira stateless)
		.and()
			.addFilterBefore(new AutenticacaoViaTokenFilter(tokenservice, usuarioRepository), UsernamePasswordAuthenticationFilter.class); //adiciona o nosso filtro (interceptador) pra ser rodado antes do filtro de autenticacao do spring
	}
	
	//Configuracoes de recursos estaticos (js, css, imagens, etc)
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring()
	        .antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**", "/swagger-resources/**");
	}
	
	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("restauranteescolaunisantos013"));
	}
}