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

	private static final String VIEW = "viewPersonDetails";
	private static final String ADD = "addperson";
	private static final String EDIT = "editperson";
	private static final String SAVE = "save";

	@Autowired
	private PersonDetailsDAO daoRef;

	@RequestMapping(method = RequestMethod.GET)
	public String viewPersonDetails(ModelMap map, @ModelAttribute("persons") Person person,
			@RequestParam(value = "action", required = false) String action) {
		if (action.equals(VIEW)) {
			map.addAttribute("persons", daoRef.findAll());
			return "personlist";
		} else if (action.equals(ADD)) {
			Person p = new Person();
			map.addAttribute("persons", p);
			return "persondetails";
		} 
//		else if (action.equals(EDIT)) {
//			System.out.println("oooo");
//			int id = 0;
//			Person person1 = daoRef.findbyid(id);
//			map.addAttribute("person", person1);
//			return "persondetails";
//		}

		return null;

	}

	@RequestMapping(method = RequestMethod.GET, params = { "id" })
	public String addperson(ModelMap map, @ModelAttribute("persons") Person person,
			@RequestParam(value = "action", required = false) String action,
			@RequestParam(value = "id") int id) {
		if (action.equals(EDIT)) {
			Person person1=daoRef.findbyid(id);
			System.out.println(person1.getName());
			map.addAttribute("persons", person1);
			return "persondetails";
		}
		
		return null;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String postmethods(ModelMap map, @ModelAttribute("persons") Person person,
			@RequestParam(value = "action", required = false) String action) {
		if (action.equals(SAVE)) {
			System.out.println("oooo");
			Person p = person;
			if (p.getId() ==0)
				daoRef.create(p);
			else
			{System.out.println(p.getName()+"____________-__-------");
				daoRef.update(p);
			}
			
			map.addAttribute("persons", daoRef.findAll());
			return "personlist";
		}
		return null;
	}

	@ModelAttribute("persons")
	Person createPerson() {

		System.out.println("TRYING TO CREATE AN ENTRY FOR A USER");

		return new Person();
	}

}
