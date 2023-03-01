package com.example.User.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserDto {
    @NotNull(message = "username should not be null")
    private String name;
    @Email(message = "email should not be numm")
    private String email;
    @Pattern(regexp = "^\\d{10}$",message = "number should be less than or equal 10")
    private String mobile;
    private String gender;
    @Min(18)
    @Max(60)
    private int age;

    @NotBlank
    private String nationality;
}
