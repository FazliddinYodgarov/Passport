package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActionDTO {

    private String error;

    private Boolean isError;

    public ActionDTO(Boolean isError) {
        this.isError = isError;
    }

}
