package com.lysofts.vivax.models;

import java.time.LocalDate;

public class Movie {
	private String id, title, thumbnail, description;
	private LocalDate released;
	private int episodes;
	
	
	public Movie() {
		super();
	}


	public Movie(String id, String title, String thumbnail, String description, LocalDate released, int episodes) {
		super();
		this.id = id;
		this.title = title;
		this.thumbnail = thumbnail;
		this.description = description;
		this.released = released;
		this.episodes = episodes;
	}


	public Movie(String title, String thumbnail, String description, LocalDate released, int episodes) {
		super();
		this.title = title;
		this.thumbnail = thumbnail;
		this.description = description;
		this.released = released;
		this.episodes = episodes;
	}


	public String getId() {
		return id;
	}


	public String getTitle() {
		return title;
	}


	public String getThumbnail() {
		return thumbnail;
	}


	public String getDescription() {
		return description;
	}


	public LocalDate getReleased() {
		return released;
	}


	public int getEpisodes() {
		return episodes;
	}


	public void setId(String id) {
		this.id = id;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void setReleased(LocalDate released) {
		this.released = released;
	}


	public void setEpisodes(int episodes) {
		this.episodes = episodes;
	}
	
}