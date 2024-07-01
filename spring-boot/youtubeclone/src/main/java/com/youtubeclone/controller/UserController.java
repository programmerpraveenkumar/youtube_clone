package com.youtubeclone.controller;

import com.youtubeclone.Dto.UsersDto;
import com.youtubeclone.Service.UsersService;
import com.youtubeclone.config.YoutubeCloneException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UsersService usersService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsersDto usersDto)throws YoutubeCloneException {
        return  ResponseEntity.ok(usersService.login(usersDto));
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UsersDto usersDto)throws YoutubeCloneException {
        return  ResponseEntity.ok(usersService.login(usersDto));
    }
//    @GetMapping("/logout")
//    public ResponseEntity<?>  logout(){
//
//    }
    @PostMapping("/update")
    public ResponseEntity<?> updateDetails(@RequestBody UsersDto usersDto)throws YoutubeCloneException {
        return  ResponseEntity.ok(usersService.updateDetails(usersDto));
    }
}
