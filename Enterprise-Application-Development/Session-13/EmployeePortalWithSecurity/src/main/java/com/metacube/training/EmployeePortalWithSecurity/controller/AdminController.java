package com.metacube.training.EmployeePortalWithSecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.EmployeePortalWithSecurity.model.Address;
import com.metacube.training.EmployeePortalWithSecurity.model.Employee;
import com.metacube.training.EmployeePortalWithSecurity.model.EmployeeSkills;
import com.metacube.training.EmployeePortalWithSecurity.model.Job;
import com.metacube.training.EmployeePortalWithSecurity.model.JobDetails;
import com.metacube.training.EmployeePortalWithSecurity.model.Mail;
import com.metacube.training.EmployeePortalWithSecurity.model.Project;
import com.metacube.training.EmployeePortalWithSecurity.model.Skill;
import com.metacube.training.EmployeePortalWithSecurity.service.AddressService;
import com.metacube.training.EmployeePortalWithSecurity.service.EmployeeService;
import com.metacube.training.EmployeePortalWithSecurity.service.EmployeeSkillsService;
import com.metacube.training.EmployeePortalWithSecurity.service.JobDetailService;
import com.metacube.training.EmployeePortalWithSecurity.service.JobService;
import com.metacube.training.EmployeePortalWithSecurity.service.MailService;
import com.metacube.training.EmployeePortalWithSecurity.service.ProjectService;
import com.metacube.training.EmployeePortalWithSecurity.service.SkillService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ProjectService projectService;
	@Autowired
	private SkillService skillService;
	@Autowired
	private JobService jobService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private JobDetailService jobDetailService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private EmployeeSkillsService employeeSkillsService;
	@Autowired
    private MailService emailService;
	
	@GetMapping("/login")
	public String login() {
		return "/login";
	}

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ModelAndView dashboard() {
		return new ModelAndView("/admin/dashboard");
	}

	@GetMapping("/projects/add")
	public String createProject(Model model) {
		model.addAttribute("project", new Project());
		return "admin/editProject";
	}

	@RequestMapping(path = "projects", method = RequestMethod.POST)
	public String saveProject(@ModelAttribute("project") Project project) {
		if (project != null && project.getId() == null) {
			projectService.createProject(project);
		} else {
			projectService.updateProject(project);
		}
		return "redirect:/admin/projects";
	}

	@RequestMapping(path = "/projects", method = RequestMethod.GET)
	public String getAllprojects(Model model) {
		model.addAttribute("projects", projectService.getAllProjects());
		return "admin/projects";
	}

	@RequestMapping(path = "/projects/edit", method = RequestMethod.GET)
	public String editproject(Model model, @RequestParam("id") Integer id) {
		model.addAttribute("project", projectService.getProjectById(id));
		return "admin/editProject";
	}

	@RequestMapping(path = "/projects/delete", method = RequestMethod.GET)
	public String deleteproject(@RequestParam("id") Integer id) {
		projectService.deleteProject(id);
		return "redirect:/admin/projects";
	}

	@GetMapping("/skill/add")
	public String createSkill(Model model) {
		model.addAttribute("skill", new Skill());
		return "admin/editSkill";
	}

	@RequestMapping(path = "skill", method = RequestMethod.POST)
	public String saveSkill(@ModelAttribute("skill") Skill skill) {
		if (skill != null && skill.getSkillId() == null) {
			skillService.createSkill(skill);
		} else {
			skillService.updateSkill(skill);
		}
		return "redirect:/admin/skill";
	}

	@RequestMapping(path = "/skill", method = RequestMethod.GET)
	public String getAllSkills(Model model) {
		model.addAttribute("skills", skillService.getAllSkills());
		return "admin/skill";
	}

	@RequestMapping(path = "/skill/edit", method = RequestMethod.GET)
	public String editSkill(Model model, @RequestParam("id") Integer id) {
		model.addAttribute("skill", skillService.getSkillById(id));
		return "admin/editSkill";
	}

	@RequestMapping(path = "/skill/delete", method = RequestMethod.GET)
	public String deleteSkill(@RequestParam("id") Integer id) {
		skillService.deleteSkill(id);
		return "redirect:/admin/skill";
	}

	@GetMapping("/job/add")
	public String createJob(Model model) {
		model.addAttribute("job", new Job());
		return "admin/editJob";
	}

	@RequestMapping(path = "job", method = RequestMethod.POST)
	public String saveJob(@ModelAttribute("job") Job job) {
		if (job != null && job.getJobCode() == null) {
			jobService.createJob(job);
		} else {
			jobService.updateJob(job);
		}
		return "redirect:/admin/job";
	}

	@RequestMapping(path = "/job", method = RequestMethod.GET)
	public String getAllJobs(Model model) {
		model.addAttribute("jobs", jobService.getAllJobs());
		return "admin/job";
	}

	@RequestMapping(path = "/job/edit", method = RequestMethod.GET)
	public String editJob(Model model, @RequestParam("id") Integer id) {
		model.addAttribute("job", jobService.getJobById(id));
		return "admin/editJob";
	}

	@RequestMapping(path = "/job/delete", method = RequestMethod.GET)
	public String deleteJob(@RequestParam("id") Integer id) {
		jobService.deleteJob(id);
		return "redirect:/admin/job";
	}

	@RequestMapping(path = "/employee", method = RequestMethod.GET)
	public String getAllEmployees(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployees());
		return "admin/employee";
	}

	@GetMapping("/employee/add")
	public String createEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("jobTitles", jobService.getAllJobs());
		model.addAttribute("currentProjects", projectService.getAllProjects());
		model.addAttribute("reportingManagers",
				employeeService.getAllEmployees());
		model.addAttribute("skills", skillService.getAllSkills());
		model.addAttribute("teamLeads", employeeService.getAllEmployees());
		return "admin/addEmployee";
	}

	@PostMapping("employee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee,
			@ModelAttribute("jobDetail") JobDetails jobDetail,
			@ModelAttribute("address") Address address,
			@RequestParam("skillName") List<Integer> skills, Model model) {
		Integer empCode = employeeService.createEmployee(employee);
		jobDetail.setEmpCode(empCode);
		jobDetailService.create(jobDetail);
		address.setEmpCode(empCode);
		addressService.create(address);
		System.out.println(skills.toString());
		for (Integer skillCode : skills) {
			EmployeeSkills employeeSkills = new EmployeeSkills();
			employeeSkills.setEmpCode(empCode);
			employeeSkills.setSkillCode(skillCode);
			employeeSkillsService.createEmployeeSkills(employeeSkills);
		}
		
		Mail mail = new Mail();
        mail.setFrom("niraj.gupta@metacube.com");
        mail.setTo(employee.getEmailId());
        mail.setSubject("Welcome to Employee Portal. Your credentials are as follows");
        mail.setContent("\n\nUsername:\t" + employee.getEmailId() + "\nPassword:\t" + employee.getPassword());

        emailService.sendSimpleMessage(mail);
		return "redirect:/admin/employee";
	}

	@GetMapping("/employee/delete")
	public String deleteEmployee(@RequestParam("id") Integer id) {
		employeeService.deleteEmployee(id);
		return "redirect:/admin/employee";
	}
}