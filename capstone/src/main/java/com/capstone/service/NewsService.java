package com.capstone.service;

import java.util.List;

import com.capstone.entity.News;
import com.capstone.model.NewsDTO;

public interface NewsService {

	public void addNews(NewsDTO news);
	
	public void updateNews(NewsDTO newsDTO);
	
	public void deleteNews(int id);
	
	public List<NewsDTO> getAllNews();
	
	public List<NewsDTO> getTop6News();
	
	public NewsDTO getNewsbyId(int id);
	
	public List<NewsDTO> search(String findName, int start, int length);
	
	public int countNewsWhensearch(String name);
}
