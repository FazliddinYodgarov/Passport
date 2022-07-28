package com.company.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FactoryDTO {
    private Long id;
    private String factoryName;
    private LocalDateTime createdDate;


}
