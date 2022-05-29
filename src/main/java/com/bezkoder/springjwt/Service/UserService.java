package com.bezkoder.springjwt.Service;

import com.bezkoder.springjwt.Exception.TourException;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.payload.request.GetListUserRequest;
import com.bezkoder.springjwt.payload.request.LoginRequest;
import com.bezkoder.springjwt.payload.response.LoginInfoRespone;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.transaction.Transactional;
import java.util.List;
@Transactional

public interface UserService {
    List<User> getAllUserList(GetListUserRequest getListUserRequest);

    LoginInfoRespone getUserByUsername(LoginRequest loginRequest) throws TourException;

    void addUser(User user) throws TourException;

//    LoginInfoRespone getUserByUsername(LoginRequest loginRequest);

//    void updateUser(int userId, UserFormForUpdateRequest form);

//    void deleteUser(DeleteUserRequest deleteUserRequest);

//    void resetPassword(String uuid,ResetPassRequest resetPassRequest);

//    void forgotPassword(String email);
//
//    void sendForgotPasswordViaEmail(String email);

//    Optional<UserEntity> findUserByUsername(String email);

//    void changePass(int userId, ChangePassRequest changePassRequest);
}
