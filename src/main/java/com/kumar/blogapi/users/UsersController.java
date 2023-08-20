package com.kumar.blogapi.users;

import com.kumar.blogapi.users.dto.CreateUserDTO;
import com.kumar.blogapi.users.dto.UserResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody CreateUserDTO userDTO, UriComponentsBuilder ucb) {
        var userResponseDto = usersService.createUser(userDTO);
        URI locationOfCreatedUser = ucb.path("users/{id}")
                .buildAndExpand(userResponseDto.getId())
                .toUri();

        return ResponseEntity.created(locationOfCreatedUser).build();
    }
}
