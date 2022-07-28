package com.company.dto;

import com.company.type.ProfileRole;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDate;


@Getter
@Setter
public class ProfileDTO {
    private Long id;
    private String surname;
    private String name;
    private String phone;
    private String username;
    private String password;
    private ProfileRole role;
    private LocalDate createdDate;
    private Long factoryId;
    private FactoryDTO factory;
    private AuthorizationDTO authorization;
}
