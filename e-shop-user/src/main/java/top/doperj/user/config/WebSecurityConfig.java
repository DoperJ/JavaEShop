package top.doperj.user.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /*
    @Value("${spring.profiles}")
    private String env;
    */

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*")
                        .allowedMethods("GET", "HEAD", "POST","PUT", "DELETE", "OPTIONS")
                        .allowCredentials(false).maxAge(3600);
            }
        };
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

		/*if("dev".equals(env)){ //如果需要在开发服中免登录
			http.authorizeRequests().antMatchers("*//**","*//**//*filters").permitAll();
			http.csrf().disable();
			http.httpBasic();
			return;
		}*/

        http.csrf().disable();
        http
                .formLogin().loginPage("/login.html").loginProcessingUrl("/login").permitAll()
                .and()
                .logout().logoutUrl("/logout")
                .and()
                .authorizeRequests()
                .antMatchers("/**/*.woff", "/**/*.woff2", "/**/*.svg", "**/*.ttf", "/**/*.eot", "/fonts/**", "/css/**", "/js/**",
                        "/**/favicon.ico", "/", "/**/*.html", "/login.html", "/**/*.css", "/**/*.js", "/img/**", "/**/eureka", "/api/**", "/register", "/shop/**",
                        "/checkout", "/orderInfo", "/home", "/addressInfo", "/search**") //放开"/api/**"：为了给被监控端免登录注册
                .permitAll()
                .and()
                .authorizeRequests().antMatchers("/**").authenticated();
        http.csrf().disable();
        http.httpBasic();

    }
//	@Autowired //也可以在application.yml文件中配置登录账号密码：security.user.name/password
    @Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
			.withUser("svcAdmin").password("pw").roles("USER");
	}
}

