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

    @PutMapping("/{id}")
    public ResponseEntity<MoviesModel> atualizarFilme(@PathVariable Long id, @RequestBody MoviesModel moviesModel){
        MoviesModel response = moviesService.atualizarFilme(id, moviesModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarFilme(@PathVariable Long id){
        moviesService.deletarFilme(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MoviesModel> buscarId(@PathVariable Long id){
        MoviesModel response =moviesService.buscarPorId(id);
        return ResponseEntity.ok().body(response);
    }
}
