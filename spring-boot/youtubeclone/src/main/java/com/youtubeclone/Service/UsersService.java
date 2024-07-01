package com.youtubeclone.Service;

import com.youtubeclone.Dto.UsersDto;
import com.youtubeclone.Dto.VideosDto;
import com.youtubeclone.Repo.UsersRepo;
import com.youtubeclone.Repo.VideoRepo;
import com.youtubeclone.config.AppConstants;
import com.youtubeclone.config.YoutubeCloneException;
import com.youtubeclone.model.UsersModel;
import com.youtubeclone.model.VideosModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    UsersRepo usersRepo;

    public  UsersDto login(UsersDto usersDto)throws YoutubeCloneException{
        UsersModel usersModel = usersRepo.login(usersDto.getEmail(),usersDto.getPassword())
                                            .orElseThrow(()->new YoutubeCloneException("No user found."));
        UsersDto usersDtoRes = new UsersDto();
        usersDtoRes.setId(usersModel.getId());
        usersDtoRes.setName(usersModel.getName());
        usersDtoRes.setEmail(usersModel.getEmail());

        usersDtoRes.setMobile(usersModel.getMobile());
        return  usersDtoRes;

    }

    public Boolean register(UsersDto usersDto)throws YoutubeCloneException{
        //TODO Email validation
        UsersModel usersModel = new UsersModel();
        usersModel.setId(usersDto.getId());
        usersModel.setName(usersDto.getName());
        usersModel.setEmail(usersDto.getEmail());
        usersModel.setMobile(usersDto.getMobile());
        usersModel.setPassword(usersDto.getPassword());
        usersRepo.save(usersModel);
        return  true;
    }



    public Boolean updateDetails(UsersDto usersDto)throws YoutubeCloneException{
        UsersModel usersModel = usersRepo.findById(usersDto.getId()).orElseThrow(()->new YoutubeCloneException("No User found"));
        switch(usersDto.getUpdateType()){
                case "password":
                    usersModel.setPassword(usersDto.getPassword());
                break;
                case "name":
                    usersModel.setName(usersDto.getName());
                break;
                case "email":
                    usersModel.setEmail(usersDto.getEmail());
                break;
                case "mobile":
                    usersModel.setPassword(usersDto.getMobile());
                break;
        }
        usersRepo.save(usersModel);
        return  true;
    }
}
