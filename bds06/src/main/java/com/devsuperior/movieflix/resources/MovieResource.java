package com.devsuperior.movieflix.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.MovieIdDTO;
import com.devsuperior.movieflix.services.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieResource {

  @Autowired
  private MovieService service;
  
//  @PreAuthorize("hasAnyRole('MEMBER', 'VISITOR')")
//  @GetMapping
//	public ResponseEntity<Page<MovieDTO>> findAll(Pageable pageable) {
//		Page<MovieDTO> list = service.findAllPaged(pageable);
//		return ResponseEntity.ok().body(list);
//	}  
  
  @PreAuthorize("hasAnyRole('MEMBER', 'VISITOR')")
  @GetMapping(value = "/{id}")
	public ResponseEntity<MovieIdDTO> findById(@PathVariable Long id) {
		MovieIdDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
  
  @PreAuthorize("hasAnyRole('MEMBER', 'VISITOR')")
  @GetMapping
	public ResponseEntity<Page<MovieDTO>> findByGenre(
			@RequestParam(value = "genreId", defaultValue = "0") Long genreId, 
			Pageable pageable){
		Page<MovieDTO> page = service.findByGenre(genreId, pageable);
		return ResponseEntity.ok().body(page);
	}
  
}





















