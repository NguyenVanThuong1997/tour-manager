package com.bezkoder.springjwt.payload.response;

import com.bezkoder.springjwt.models.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginInfoRespone {
    private int id;
    private String loginId;
    private String email;
    private String role;

}
