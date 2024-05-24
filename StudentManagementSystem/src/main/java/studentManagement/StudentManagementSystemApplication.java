package studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import studentManagement.Repository.studentrepository;
import studentManagement.entity.student;

@SpringBootApplication
public class StudentManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}
	
	@Autowired
	private studentrepository studentRepository;
	
	public void run(String... args)throws Exception{
		
		student st1=new student("Parveen","Banjara","pbanjara@gmail.com");
		studentRepository.save(st1);

	}
}
