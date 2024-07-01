package com.youtubeclone.Repo;

import com.youtubeclone.model.UsersModel;
import com.youtubeclone.model.VideosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepo extends JpaRepository<UsersModel,Long> {
    @Query("select user from UsersModel user where user.email=?1 and password = ?2")
    Optional<UsersModel> login(String username, String password);
}
