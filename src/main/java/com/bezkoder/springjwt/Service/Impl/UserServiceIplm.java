package com.bezkoder.springjwt.Service.Impl;

import com.bezkoder.springjwt.Exception.TourException;
import com.bezkoder.springjwt.Service.UserService;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.payload.request.GetListUserRequest;
import com.bezkoder.springjwt.payload.request.LoginRequest;
import com.bezkoder.springjwt.payload.response.LoginInfoRespone;
import com.bezkoder.springjwt.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceIplm implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceIplm(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = encoder;
    }



    @Override
    public List<User> getAllUserList(GetListUserRequest getListUserRequest) {
        return null;
    }

    @Override
    public LoginInfoRespone getUserByUsername(LoginRequest loginRequest) throws TourException {
        //        String emailPattern = "^([a-zA-Z0-9.!#$%&'*+\\/=?^_`{|}~-]){1,64}@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
//        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,10}$";
        Optional<User> user = userRepository.findByLoginIdAndDeletedFalse(loginRequest.getLoginId());
        if (!user.isPresent()) {
            throw new TourException("user not found");
        }

        if (!BCrypt.checkpw(loginRequest.getPassword(), user.get().getPassword())) {
            throw new TourException("user not found");
        }

        return new LoginInfoRespone(
                Math.toIntExact(user.get().getId()),
                user.get().getLoginId(),
                user.get().getEmail(),
                user.get().getRole());

    }

    @Override
    public void addUser(User user) throws TourException {
        User employee = new User();

        employee.setLoginId(user.getLoginId());
        employee.setPassword(passwordEncoder.encode(user.getPassword()));
        employee.setEmail(user.getEmail());
        employee.setAddress(user.getAddress());
        employee.setAuthorities(user.getAuthorities());
        employee.setRole(user.getRole());
        employee.setPhone(user.getPhone());

        userRepository.save(employee);
    }

}
