package fr.plesport.pfr.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.plesport.pfr.model.Blog;
import fr.plesport.pfr.model.criteria.BlogSearchCriteria;
import fr.plesport.pfr.service.BlogService;
@Transactional
@RestController
@RequestMapping(("/api/blog"))
public class BlogController {
	
	@Autowired
	BlogService blogService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createBlog(@RequestBody @Valid Blog blog) {
		blogService.createBlog(blog);
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void deleteBlog(@PathVariable BlogSearchCriteria id) {
		Blog blog = blogService.searchBlog(id);
		blogService.deleteBlog(blog);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Blog> findAllVBlog() {
		return blogService.findAllBlog();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public void updateBlog(@PathVariable Long id, @RequestBody Blog blog) {
		blog.setId(id);
		blogService.updateBlog(blog);
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public Blog search(
			@RequestParam(name = "id", required = false) Long id,
			@RequestParam(required = false) String title,
			@RequestParam(required = false) String header,
			@RequestParam(required = false) LocalDateTime date
			){
		BlogSearchCriteria criteria = new BlogSearchCriteria(id, title, header, date);
		
		return blogService.searchBlog(criteria);
		
	}

}

