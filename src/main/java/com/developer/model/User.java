package com.developer.model;


import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @NotNull
    private int id;
    @NotNull(message = "Name is mandatory")
    @NotBlank(message = "Name is mandatory")
    private  String name;
    @Email(message = "Not a valid email")
    private  String email;
    @Min(14)
    @Max(80)
    private  int age;
}
