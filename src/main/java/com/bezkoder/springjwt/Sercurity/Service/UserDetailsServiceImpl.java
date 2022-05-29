package com.bezkoder.springjwt.Sercurity.Service;

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
import java.util.Optional;

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
        Optional<User> user = userRepository.findByLoginIdAndDeletedFalse(loginId);

        if (user == null || user.get().isDeleted()) {
            throw new UsernameNotFoundException(BaseConst.NOT_FOUND);
        }

        return new com.bezkoder.springjwt.Sercurity.Service.UserDetails(user.get().getId(), user.get().getLoginId(), user.get().getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(user.get().getAuthorities())), user.get().getEmail());
    }
}

