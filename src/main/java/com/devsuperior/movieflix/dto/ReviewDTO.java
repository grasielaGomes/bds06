package com.devsuperior.movieflix.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.devsuperior.movieflix.entities.Review;

public class ReviewDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotBlank(message = "Campo requerido")
	private String text;
	
	private Long movieId;
	private Long userId;
	
	private UserDTO user;
	
	
	public ReviewDTO() {
		
	}


	public ReviewDTO(Long id, String text, Long movieId, Long userId, UserDTO user) {
		this.id = id;
		this.text = text;
		this.movieId = movieId;
		this.userId = userId;
		this.user = user;
	}
	
	public ReviewDTO(Review review) {
		id = review.getId();
		text = review.getText();
		movieId = review.getMovie().getId();
		userId = review.getUser().getId();
		user = new UserDTO(review.getUser());
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public Long getMovieId() {
		return movieId;
	}


	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public UserDTO getUser() {
		return user;
	}


	public void setUser(UserDTO user) {
		this.user = user;
	}
	

}
