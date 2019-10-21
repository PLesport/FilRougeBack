package fr.plesport.pfr.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.plesport.pfr.model.NewsLetter;
import fr.plesport.pfr.service.NewsLetterService;

@CrossOrigin("http://localhost:4200")
@Transactional
@RestController
@RequestMapping(("/api/newsletter"))
public class NewsLetterController {

	@Autowired
	NewsLetterService newsLetterService;

	@PreAuthorize("hasAuthority('C_NEWSLETTER')")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createNewsLetter(@RequestBody @Valid NewsLetter newsLetter) {
		newsLetterService.createNewsLetter(newsLetter);
	}

	@PreAuthorize("hasAuthority('D_NEWSLETTER')")
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void deleteNewsLetter(@PathVariable String email) {
		NewsLetter newsLetter = newsLetterService.findNewsLetterByEmail(email);
		newsLetterService.deleteNewsLetter(newsLetter);
	}
	
	@PreAuthorize("hasAuthority('F_NEWSLETTER') or returnObject.email == principal.username")
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<NewsLetter> findAllNewsLetter() {
		return newsLetterService.findAllNewsLetter();
	}

	@PreAuthorize("hasAuthority('U_NEWSLETTER')")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public void updateNewsLetter(@PathVariable Long id, @RequestBody @Valid NewsLetter newsLetter) {
		newsLetter.setId(id);
		newsLetterService.updateNewsLetter(newsLetter);
	}
	

}
