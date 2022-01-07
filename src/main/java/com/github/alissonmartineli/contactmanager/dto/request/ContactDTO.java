package com.github.alissonmartineli.contactmanager.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactDTO {

    private Long id;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String name;

}
