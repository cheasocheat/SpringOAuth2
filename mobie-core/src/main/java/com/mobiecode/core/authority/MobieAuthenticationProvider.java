package com.mobiecode.core.authority;

import com.mobiecode.core.repository.UserRepository;
import com.mobiecode.domain.entity.User;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Developer : cheasocheat
 * Created on 1/10/18 09:49
 */
public class MobieAuthenticationProvider extends DaoAuthenticationProvider {
    private UserRepository userRepository;

    public MobieAuthenticationProvider(UserRepository userRepository, UserDetailsService userDetailsService) {
        super();
        this.setUserDetailsService(userDetailsService);
        this.userRepository = userRepository;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        final User user = userRepository.findByUsername(authentication.getName());
        if ((user == null)) {
            throw new BadCredentialsException("Invalid username or password");
        }

        final Authentication result = super.authenticate(authentication);
        return new UsernamePasswordAuthenticationToken(user, result.getCredentials(), result.getAuthorities());
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
