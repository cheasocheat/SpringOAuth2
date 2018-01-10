package com.mobiecode.core.authority;

import com.mobiecode.core.repository.UserRepository;
import com.mobiecode.domain.entity.Role;
import com.mobiecode.domain.entity.User;
import com.mobiecode.domain.util.RecordStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
/**
 * Developer : cheasocheat
 * Created on 1/10/18 10:00
 */
@Service("userDetailsService")
@Transactional
public class MobieUserDetailsService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    public MobieUserDetailsService() {
        super();
    }

    /**
     * Authenticate
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        try {
            User user = userRepository.findByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException("No user found with username: " + username);
            }
            org.springframework.security.core.userdetails.User userDetails =
                    new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), isActiveUser(user), true, true, true, getAuthorities(user.getRoles()));
            return userDetails;
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Get Authorities
     * @param roles
     * @return
     */
    private final Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (Role role: roles) {
            authorities.add(new SimpleGrantedAuthority(role.getCode()));
           /* authorities.addAll(role.getPrivileges()
                    .stream()
                    .map(p -> new SimpleGrantedAuthority(p.getName()))
                    .collect(Collectors.toList()));*/
        }
        return authorities;
    }


    /**
     * isActiveUser
     * @param user
     * @return
     */
    private boolean isActiveUser(User user){
        return (user.getStatus().equals(RecordStatus.PUB)) ? true : false;
    }

}
