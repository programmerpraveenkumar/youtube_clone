package com.youtubeclone.Repo;

import com.youtubeclone.model.VideosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepo extends JpaRepository<VideosModel,Long> {
}
