package com.metacube.training.EmployeePortal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.metacube.training.EmployeePortal.model.Employee;
import com.metacube.training.EmployeePortal.model.EmployeeSkills;
import com.metacube.training.EmployeePortal.model.Project;
import com.metacube.training.EmployeePortal.model.Skill;
import com.metacube.training.EmployeePortal.service.EmployeeService;
import com.metacube.training.EmployeePortal.service.EmployeeSkillsService;
import com.metacube.training.EmployeePortal.service.ProjectService;
import com.metacube.training.EmployeePortal.service.SkillService;

@Controller
public class WelcomeController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private SkillService skillService;
	@Autowired
	private EmployeeSkillsService employeeSkillService;

	@GetMapping("/")
	public String welcome(ModelMap model) {
		model.addAttribute("greeting", "Hello World from Spring 4 MVC");
		return "welcome";
	}

	@GetMapping("/search")
	public String search(ModelMap model) {
		model.addAttribute("greeting", "Hello World from Spring 4 MVC");
		return "search";
	}

	@PostMapping("/searchResult")
	public String searchResult(@RequestParam("type") String type,
			@RequestParam("input") String input, Model model) {
		if ("name".equals(type)) {
			model.addAttribute("employees",
					employeeService.getEmployeeByName(input));
		} else if ("skill".equals(type)) {
			Skill skill = skillService.getSkillByName(input);
			if (skill != null) {
				List<EmployeeSkills> employeeSkills = employeeSkillService
						.getEmployeeSkills(skill.getSkillId());
				List<Employee> employees = new ArrayList<Employee>();
				for (EmployeeSkills skills : employeeSkills) {
					employees.add(employeeService.getEmployeeById(skills
							.getEmpCode()));
				}
				model.addAttribute("employees", employees);
			}
		} else if ("project".equals(type)) {
			Project project = projectService.getProjectByName(input);
			if (project != null) {
				model.addAttribute("employees",
						employeeService.getEmployeeByProject(project.getId()));
			}
		} else {
			try {
				Integer totalExp = Integer.parseInt(input);
				model.addAttribute("employees",
						employeeService.getEmployeeByTotalExperience(totalExp));
			} catch (Exception e) {
				return "redirect:search?error";
			}
		}
		return "searchResult";
	}
}