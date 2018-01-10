package com.mobiecode.core.configuration;

import com.mobiecode.core.authority.MobieAuthenticationProvider;
import com.mobiecode.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true)
public class ApplicationConfig {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * Provide Authentication
     * @return
     */
    @Bean
    public DaoAuthenticationProvider authProvider() {
        final MobieAuthenticationProvider mobieAuthenticationProvider = new MobieAuthenticationProvider(userRepository, userDetailsService);
        mobieAuthenticationProvider.setPasswordEncoder(encoder());
        return mobieAuthenticationProvider;
    }

    /**
     * Password Encoder
     * @return
     */
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(11);
    }
}
