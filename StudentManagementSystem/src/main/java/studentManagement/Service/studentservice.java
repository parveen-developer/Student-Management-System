package studentManagement.Service;

import java.util.List;

import studentManagement.entity.student;

public interface studentservice {
	List<student> getAllstudents();
	
	student saveStudent(student student);
	
	student getStudentById(Long Id);
	
	student updateStudent(student student);
	
	void deleteStudentById(Long Id);
}
