package fr.plesport.pfr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.plesport.pfr.dao.BlogJpaRepository;
import fr.plesport.pfr.model.Blog;
import fr.plesport.pfr.model.criteria.BlogSearchCriteria;

@Service
public class BlogService {

	@Autowired
	private BlogJpaRepository blogJpaRepository;

	public void createBlog(Blog blog) {
		blogJpaRepository.persist(blog);
	}

	public void deleteBlog(List<Blog> blog) {
		blogJpaRepository.delete(blog);
	}

	public void updateBlog(Blog blog) {
		blogJpaRepository.update(blog);
	}

	public List<Blog> searchBlog(BlogSearchCriteria criteria) {
		return blogJpaRepository.search(criteria);
	}

	public List<Blog> findAllBlog() {
		return blogJpaRepository.findAll();
	}

	
}
