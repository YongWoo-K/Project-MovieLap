//package me.kimyongwoo.springbootdeveloper.config;
//
//import lombok.RequiredArgsConstructor;
//
//import me.kimyongwoo.springbootdeveloper.service.UserDetailService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.ProviderManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class WebSecurityConfig {
//
//    private final UserDetailService userService;
//
//    // 스프링 시큐리티 기능 비활성화
//    @Bean
//    public WebSecurityCustomizer configure() {
//        return (web) -> web.ignoring()
//                .requestMatchers(toH2Console())
//                .requestMatchers(new AntPathRequestMatcher("/static/**"));
//    }
//
//    // 특정 HTTP 요청에 대한 웹 기반 보안 구성
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeRequests(auth -> auth
//                        .requestMatchers(
//                                new AntPathRequestMatcher("/login"),
//                                new AntPathRequestMatcher("/signup"),
//                                new AntPathRequestMatcher("/user")
//                        ).permitAll()
//                        .anyRequest().authenticated())
//                .formLogin(formLogin -> formLogin
//                        .loginPage("/login")
//                        .defaultSuccessUrl("/articles")
//                )
//                .logout(logout -> logout
//                        .logoutSuccessUrl("/login")
//                        .invalidateHttpSession(true)
//                )
//                .csrf(AbstractHttpConfigurer::disable)
//                .build();
//    }
//
//    // 인증 관리자 설정
//    @Bean
//    public AuthenticationManager authenticationManager(HttpSecurity http,
//                                                       BCryptPasswordEncoder bCryptPasswordEncoder,
//                                                       UserDetailService userDetailService) throws Exception {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userService);
//        authProvider.setPasswordEncoder(bCryptPasswordEncoder);
//        return new ProviderManager(authProvider);
//    }
//
//    // 패스워드 인코더
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
