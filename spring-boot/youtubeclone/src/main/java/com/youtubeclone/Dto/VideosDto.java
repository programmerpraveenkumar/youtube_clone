package com.youtubeclone.Dto;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class VideosDto {
    Long id;
    String title;
    String body;
    Long uploader_id;
    String file_name;
    String status;
    LocalDateTime created_at;
    String category;
}
