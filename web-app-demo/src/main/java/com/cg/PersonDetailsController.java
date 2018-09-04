package com.cg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/controller")
public class PersonDetailsController {

	private static final String ACTION_KEY = "action";
	private static final String VIEW_PERSON = "viewPerson";
	private static final String ADD_PERSON = "addPerson";
	private static final String SAVE_PERSON = "savePerson";
	private static final String EDIT_PERSON = "editPerson";

	@Autowired
	private PersonDetailsDAO daoRef;

	@RequestMapping(method = RequestMethod.GET)
	public String viewPersonDetails(ModelMap map, @RequestParam("action") String action,
			@RequestParam(value = "id", required = false) Integer id) {
		System.out.println("controller");

		if (action.equals(VIEW_PERSON)) {
			map.addAttribute("persons", daoRef.findAll());
			return "personsList";
		} 
		else if (action.equals(ADD_PERSON)) {
			Person person = new Person();
			map.addAttribute("person", person);
			return "personDetails";
		}
		else if (action.equals(EDIT_PERSON)) {
			Person person = daoRef.findById(id);
			map.addAttribute("person", person);
			return "personDetails";
		}

		return null;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String saveCars(ModelMap map, @RequestParam("action") String action,
			@RequestParam("id") int id,
			@ModelAttribute("person") Person person) {
		if(action.equals(SAVE_PERSON)) {
			daoRef.updatePerson(person);
			return "personsList";
		}
		else
			return null;
}
	@ModelAttribute("person")
	public Person getPerson()
	{
		return new Person();
	}
	
}