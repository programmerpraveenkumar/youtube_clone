package com.youtubeclone.Dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UsersDto {

    Long id;
    String name;
    String email;
    String  mobile;
    String password;
    LocalDateTime created_at;
    String updateType;
}
