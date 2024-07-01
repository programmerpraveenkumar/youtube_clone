package com.youtubeclone.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.youtubeclone.Dto.VideosDto;
import com.youtubeclone.Repo.VideoRepo;
import com.youtubeclone.config.AppConstants;
import com.youtubeclone.config.YoutubeCloneException;
import com.youtubeclone.model.VideosModel;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class VideosService {
    @Autowired
    VideoRepo videoRepo;

    public List<VideosDto> getVideos(){
        List<VideosDto> dtoList = new ArrayList<>();
        List<VideosModel> listDB = videoRepo.findAll();
        listDB.forEach((obj)->{
            VideosDto videosDto = new VideosDto();
            videosDto.setId(obj.getId());
            videosDto.setCategory(obj.getCategory());
            videosDto.setStatus(obj.getStatus());
            videosDto.setBody(obj.getBody());
            videosDto.setTitle(obj.getTitle());
            videosDto.setUploader_id(obj.getUploader_id());
            videosDto.setFile_name(obj.getFile_name());
            videosDto.setCreated_at(obj.getCreated_at());
            videosDto.setTitle(obj.getTitle());
            dtoList.add(videosDto);
        });
        return dtoList;
    }

    public VideosModel saveVideoDetail(VideosDto videosDto)throws YoutubeCloneException{
        try{
            VideosModel videosModel = videoRepo.findById(videosDto.getId()).orElseThrow(()->new YoutubeCloneException("No video found"));
            videosModel.setBody(videosDto.getBody());
            videosModel.setCategory(videosDto.getCategory());
            videosModel.setTitle(videosDto.getTitle());
            videosModel.setUploader_id(videosDto.getUploader_id());
            videoRepo.save(videosModel);
            return videosModel;
        }catch (Exception e){
            throw new YoutubeCloneException(e.getMessage());
        }
    }
    public VideosModel saveVideo(MultipartFile video)throws YoutubeCloneException{
        try{
            Path path = Paths.get(AppConstants.UPLOAD_DIR);
            String fileName = Base64.getEncoder().encodeToString(LocalDateTime.now().toString().getBytes())+"_"+video.getOriginalFilename();

            Files.copy(video.getInputStream(), path.resolve(fileName));

            VideosModel videosModel = new VideosModel();
            videosModel.setStatus("1");
            videosModel.setFile_name(fileName);
            videoRepo.save(videosModel);
            return videosModel;
        }catch (Exception e){
            throw new YoutubeCloneException(e.getMessage());
        }
    }
}
