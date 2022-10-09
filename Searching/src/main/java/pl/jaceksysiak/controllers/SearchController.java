package pl.jaceksysiak.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.jaceksysiak.model.dto.SearchResult;
import pl.jaceksysiak.service.SearchService;

@Controller
public class SearchController {
	
	 @Autowired
	 SearchService searchService;

	@RequestMapping(value="/search", method={RequestMethod.POST, RequestMethod.GET})
	public ModelAndView search(ModelAndView modelAndView, @RequestParam("s") String text, @RequestParam(name="p", defaultValue="1") int pageNumber) {
		
		//System.out.println("Search text: " + text);
		
		Page<SearchResult> results = searchService.search(text, pageNumber);
		
	    modelAndView.getModel().put("s", text);
	    modelAndView.getModel().put("page", results);
		modelAndView.setViewName("app.search");
		
		return modelAndView;
	}
}







































