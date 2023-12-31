package com.kumar.blogapi.users.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResponseDTO {
    Integer id;
    String email;
    String userName;
    String bio;
    String image;
}
