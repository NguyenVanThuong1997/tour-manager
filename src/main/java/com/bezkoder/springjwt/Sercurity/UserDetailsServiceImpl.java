package com.bezkoder.springjwt.Sercurity;

import com.bezkoder.springjwt.models.BaseConst;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * UserDetailsServiceImpl
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        // Check loginId
        if (StringUtils.isAllBlank(loginId)) {
            throw new BadCredentialsException(BaseConst.ERROR);
        }

        // Search the account by loginId
        User user = userRepository.findByLoginIdAndDeletedFalse(loginId);

        if (user == null || user.isDeleted()) {
            throw new UsernameNotFoundException(BaseConst.NOT_FOUND);
        }


        return new com.bezkoder.springjwt.Sercurity.UserDetails(user.getId(), user.getLoginId(), user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(user.getAuthorities())), user.getEmail());
    }
}

