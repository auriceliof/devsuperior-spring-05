package com.devsuperior.movieflix.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.MovieIdDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class MovieService{

	@Autowired
	private MovieRepository repository;
	
	@Transactional
	public Page<MovieDTO> findAllPaged(Pageable pageable){
		Page<Movie> list = repository.findAll(pageable);
		return list.map(x -> new MovieDTO(x));
	}
		
	@Transactional(readOnly = true)
	public MovieIdDTO findById(Long id) {
		Optional<Movie> obj = repository.findById(id);
		Movie entity = obj.orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
		return new MovieIdDTO(entity, entity.getGenre());
	}
	
	@Transactional(readOnly = true) 
	public Page<MovieDTO> findByGenre(Long genreId, Pageable pageable){
		Page<Movie> page = repository.findByGenre(genreId, pageable);      
		return page.map(x -> new MovieDTO(x));
	}
}
























