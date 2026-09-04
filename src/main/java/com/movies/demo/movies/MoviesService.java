package com.movies.demo.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesService {

    @Autowired
    private MoviesRepository moviesRepository;

    public List<MoviesModel> findAll() {
        return moviesRepository.findAll();
    }

    public MoviesModel buscarPorId(Long id){
        return moviesRepository.findById(id).get();
    }

    public MoviesModel criarFilme(MoviesModel moviesModel){
        return moviesRepository.save(moviesModel);
    }

    public void deletarFilme(Long id){
        moviesRepository.deleteById(id);
    }

    public MoviesModel atualizarFilme(Long id, MoviesModel moviesNew){
        MoviesModel moviesModel = moviesRepository.findById(id).get();
        moviesModel.setGenero(moviesNew.getGenero());
        moviesModel.setNome(moviesNew.getNome());
        moviesModel.setDiretor(moviesNew.getDiretor());
        moviesModel.setEstudio(moviesNew.getEstudio());

        return moviesRepository.save(moviesModel);
    }
}
