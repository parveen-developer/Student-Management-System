package studentManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import studentManagement.entity.student;
import studentManagement.Service.studentservice;

@Controller
public class studentcontroller {

	private studentservice studentService;
	
	public studentcontroller (studentservice studentService) {
		super();
		this.studentService = studentService;
	}
	
	//handler
		@GetMapping("/students")
		public String liststudents(Model model)
		{
			model.addAttribute("students",studentService.getAllstudents());
			return "students";
		}
		
		
	
		//handler for create student
			@GetMapping("/students/new")
			public String createStudentForm(Model model)
			{
				student student= new student();
				model.addAttribute("student",student);
				return "create_student";
			}
			@PostMapping("/students")
			public String saveStudent(@ModelAttribute("student")student student)
			{
				studentService.saveStudent(student);
				return "redirect:/students";
			}
			
			@GetMapping("/students/edit/{Id}")
			public String editStudentForm(@PathVariable Long Id,Model model)
			{
				model.addAttribute("student",studentService.getStudentById(Id));
				return "edit_student";
			}
			
			@PostMapping("/students/{Id}")
			public String updateStudent(@PathVariable Long Id,
					@ModelAttribute("student")student student,
					Model model) {
				
				//get student from database by id
				student existingstudent=studentService.getStudentById(Id);
				existingstudent.setId(Id);
				existingstudent.setFirstname(student.getFirstname());
				existingstudent.setLastname(student.getLastname());
				existingstudent.setEmail(student.getEmail());
			
			//save updated student object
				studentService.updateStudent(existingstudent);
			
				return "redirect:/students";
			}
			
			@GetMapping("/students/{Id}")
			public String deleteStudent(@PathVariable Long Id)
			{
				studentService.deleteStudentById(Id);
				return "redirect:/students";
			}
}
