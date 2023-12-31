package com.devsuperior.movieflix.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.devsuperior.movieflix.entities.Movie;

public class MovieDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotEmpty
	private String title;
	
	@NotEmpty
	private String subTitle;
	
	@NotEmpty
	private Integer year;
	
	@NotEmpty
	private String imgUrl;
	
	@NotEmpty
	private String Synopsis;
	
	public MovieDTO() {
		
	}
	
	public MovieDTO(Long id, String title, String subTitle, Integer year, String imgUrl, String synopsis) {
		super();
		this.id = id;
		this.title = title;
		this.subTitle = subTitle;
		this.year = year;
		this.imgUrl = imgUrl;
		this.Synopsis = synopsis;
	}

	public MovieDTO(Movie entity) {
		id = entity.getId();
		title = entity.getTitle();
		subTitle = entity.getSubTitle();
		year = entity.getYear();
		imgUrl = entity.getImgUrl();
		Synopsis = entity.getSynopsis();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getSynopsis() {
		return Synopsis;
	}

	public void setSynopsis(String synopsis) {
		Synopsis = synopsis;
	}
}
