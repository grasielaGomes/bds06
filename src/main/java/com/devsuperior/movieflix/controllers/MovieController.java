package com.devsuperior.movieflix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.MovieCardDTO;
import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.MovieDetailDTO;
import com.devsuperior.movieflix.services.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
	
	@Autowired
	private MovieService service;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MovieDetailDTO> findById(@PathVariable Long id) {
		MovieDetailDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping
	public ResponseEntity<Page<MovieCardDTO>> findByCard(
			@RequestParam(value = "genreId", defaultValue = "0") Long genreId,
			@RequestParam(value = "orderBy", defaultValue = "title") String orderBy,
			Pageable pageable){
		Page<MovieCardDTO> list = service.findByGenre(genreId, pageable);
		return ResponseEntity.ok(list);
	}

}
