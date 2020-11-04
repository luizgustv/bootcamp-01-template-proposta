package br.com.zup.proposta.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /*http.csrf().disable() //desabilitando a protecao csrf
                .authorizeRequests() //autoriza requisições
                .anyRequest().permitAll() //permite todas as requisições
                .and()
                .httpBasic(); //autenticação basica http*/

        http.authorizeRequests(authorizeRequests ->
                authorizeRequests
                        .antMatchers(HttpMethod.GET, "/api/propostas/**").hasAuthority("SCOPE_propostas")
                        .antMatchers(HttpMethod.GET, "/api/cartoes/**").hasAuthority("SCOPE_cartoes")
                        .antMatchers(HttpMethod.POST, "/api/cartoes/**").hasAuthority("SCOPE_cartoes")
                        .antMatchers(HttpMethod.POST, "/api/propostas/**").hasAuthority("SCOPE_propostas")
                        .anyRequest().authenticated()
        )
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);

    }

}
