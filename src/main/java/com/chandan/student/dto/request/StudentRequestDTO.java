package com.chandan.student.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record StudentRequestDTO(

        @NotBlank(message = "Name is required") String name,

        @NotBlank(message = "Email is required") @Email String email,

        @NotBlank(message = "Course is required") String course,

        @NotNull @Min(18) Integer age

) {
}