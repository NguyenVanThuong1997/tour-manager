package com.bezkoder.springjwt.Controller;

import com.bezkoder.springjwt.Common.RequestPath;
import com.bezkoder.springjwt.Exception.TourException;
import com.bezkoder.springjwt.Service.UserService;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.payload.request.LoginRequest;
import com.bezkoder.springjwt.payload.response.LoginInfoRespone;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(RequestPath.T001_LOGIN)
    public ResponseEntity<LoginInfoRespone> login(@Valid @RequestBody LoginRequest loginRequest) throws TourException {

        LoginInfoRespone user = userService.getUserByUsername(loginRequest);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping(RequestPath.T001_ADD_USER)
    public ResponseEntity<?> addUser(@RequestBody User user) throws TourException{
        userService.addUser(user);
        return new ResponseEntity<>("Create Successfully!",HttpStatus.OK);
    }
}
