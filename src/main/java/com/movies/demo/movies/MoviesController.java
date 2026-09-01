package com.movies.demo.movies;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/movies")
public class MoviesController {

    @Autowired
    private MoviesService moviesService;

    @GetMapping
    public ResponseEntity<List<MoviesModel>> findAll(){

        List<MoviesModel> response = moviesService.findAll();
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<MoviesModel> criarFilme(@RequestBody MoviesModel moviesModel){
        MoviesModel response = moviesService.criarFilme(moviesModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
