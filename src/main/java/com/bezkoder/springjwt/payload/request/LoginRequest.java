package com.bezkoder.springjwt.payload.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Data
@Getter
@Setter
public class LoginRequest {
    @NotBlank
    private String loginId;

    @NotBlank
    private String password;

}
