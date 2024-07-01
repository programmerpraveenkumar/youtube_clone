package com.youtubeclone.model;

import com.youtubeclone.controller.VideosController;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name="videos")
@Data
public class VideosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String body;
    Long uploader_id;
    String file_name;
    String status;
    @Column(insertable = false,updatable = false)
    LocalDateTime created_at;
    String category;
}
