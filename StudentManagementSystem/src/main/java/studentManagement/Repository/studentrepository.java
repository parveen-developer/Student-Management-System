package studentManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import studentManagement.entity.student;

public interface studentrepository extends JpaRepository<student,Long> 
{

}
