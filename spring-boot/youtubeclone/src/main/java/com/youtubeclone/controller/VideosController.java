package com.youtubeclone.controller;

import com.youtubeclone.Dto.GeneralResponse;
import com.youtubeclone.Dto.VideosDto;
import com.youtubeclone.Service.VideosService;
import com.youtubeclone.config.YoutubeCloneException;
import com.youtubeclone.model.VideosModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@RestController
@RequestMapping("/videos")
public class VideosController {
    @Autowired
    VideosService videosService;
    @GetMapping("/")
    public ResponseEntity<?> getVideos(){
            return ResponseEntity.ok(videosService.getVideos());
    }

    @PostMapping("/saveVideoDetails")
    public ResponseEntity<?> postVideos(@RequestBody VideosDto videoDto)throws YoutubeCloneException {
        videosService.saveVideoDetail(videoDto);
        return ResponseEntity.ok(new GeneralResponse("details stored successfully!!"));
    }
    @PostMapping("/saveVideo")
    public ResponseEntity<?> postVideos(@RequestParam MultipartFile video)throws YoutubeCloneException {
        VideosModel vm = videosService.saveVideo(video);
        return ResponseEntity.ok(vm);
    }

}
