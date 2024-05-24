package studentManagement.studentserviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import studentManagement.Repository.studentrepository;
import studentManagement.Service.studentservice;
import studentManagement.entity.student;




@Service
public class studentserviceImpl implements studentservice {

	public studentrepository studentRepository;
	
	public studentserviceImpl(studentrepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

  
	public List<student> getAllstudents()
	{
		return studentRepository.findAll();
	}
	
	
	public student saveStudent(student student)
	{
		return studentRepository.save(student);
	}
	
	public student getStudentById(Long Id) {
		
		return studentRepository.findById(Id).get();
	}


	@Override
	public student updateStudent(student student) {
		
		return studentRepository.save(student);

	}


	@Override
	public void deleteStudentById(Long Id) {
		studentRepository.deleteById(Id);
		
	}
}
