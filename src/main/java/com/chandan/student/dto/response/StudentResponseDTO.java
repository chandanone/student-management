package com.chandan.student.dto.response;

public record StudentResponseDTO(
        // No validation annotations needed here, it's just raw output data
        Long id, // Included so the frontend has the primary key
        String name,
        String email,
        String course,
        Integer age

) {
}
