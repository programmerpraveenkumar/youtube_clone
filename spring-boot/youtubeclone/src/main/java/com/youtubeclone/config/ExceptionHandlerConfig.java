package com.youtubeclone.config;

import com.youtubeclone.Dto.GeneralResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
public class ExceptionHandlerConfig {
    @ExceptionHandler(SQLException.class)
    public ResponseEntity<?> ServiceException(SQLException e){
        return ResponseEntity.badRequest().body(new GeneralResponse(e.getMessage()));
    }
    @ExceptionHandler(YoutubeCloneException.class)
    public ResponseEntity<?> ServiceException(YoutubeCloneException e){
        return ResponseEntity.badRequest().body(new GeneralResponse(e.getMessage()));
    }
}
