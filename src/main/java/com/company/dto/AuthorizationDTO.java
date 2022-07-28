package com.company.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
public class AuthorizationDTO {
    private String username;
    private String password;
}
