package fr.plesport.pfr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.plesport.pfr.dao.NewsLetterJpaRepository;
import fr.plesport.pfr.model.NewsLetter;

@Service
public class NewsLetterService {

	@Autowired
	private NewsLetterJpaRepository newsLetterJpaRepository;

	public void createNewsLetter(NewsLetter newsLetter) {
		newsLetterJpaRepository.persist(newsLetter);
	}

	public void deleteNewsLetter(List<NewsLetter> newsletter) {
		newsLetterJpaRepository.delete(newsletter);
	}

	public void updateNewsLetter(NewsLetter newsLetter) {
		newsLetterJpaRepository.update(newsLetter);
	}

	public List<NewsLetter> findNewsLetterByEmail(String email) {
		return newsLetterJpaRepository.findNewsLetterByEmail(email);
	}

	public List<NewsLetter> findAllNewsLetter() {
		return newsLetterJpaRepository.findAll();
	}
	
}
