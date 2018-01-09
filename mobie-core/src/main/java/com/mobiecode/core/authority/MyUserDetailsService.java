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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Developer : cheasocheat
 * Created on 1/9/18 18:34
 */
@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public MyUserDetailsService(){
        super();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            User user = userRepository.findByUsername(username);
            if(user == null){
                throw new UsernameNotFoundException("No user found with username: " + username);
            }


            org.springframework.security.core.userdetails.User secUser =
                    new org.springframework.security.core.userdetails.User(
                            user.getUsername(),
                            user.getPassword(),
                            isActiveUser(user),
                            true,
                            true,
                            true,
                            getAuthorities(user.getRoles()));
            return secUser;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * getAuthorities
     * @param roles
     * @return
     */
    private final Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role: roles) {
            authorities.add(new SimpleGrantedAuthority(role.getCode()));
            /*authorities.addAll(role.getPrivileges()
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
        return user.getStatus().equals(RecordStatus.PUB.getCode()) ? true : false;
    }
}
