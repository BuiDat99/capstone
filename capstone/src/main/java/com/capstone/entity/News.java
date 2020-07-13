package com.capstone.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="news")
public class News implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	private String imageTitle;
	private String poster;
	private String author;
	private String image;
	private String shortDescription;
	private String detailDescription;
	private String source;
	private String hashtag;
	private String status;
	private String modifiedDate;
	private String creationDate;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private NewCategory category;
}
