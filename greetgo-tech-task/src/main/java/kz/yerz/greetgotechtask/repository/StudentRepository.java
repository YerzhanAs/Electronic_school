package kz.yerz.greetgotechtask.repository;

import kz.yerz.greetgotechtask.entity.Student;
import kz.yerz.greetgotechtask.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
