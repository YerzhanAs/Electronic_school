package kz.yerz.greetgotechtask.service.Impl;

import kz.yerz.greetgotechtask.entity.Student;
import kz.yerz.greetgotechtask.repository.StudentRepository;
import kz.yerz.greetgotechtask.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {


    private StudentRepository studentRepository;


    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student saveorUpdate(Student student) {
        return studentRepository.save(student);
    }

    public Iterable<Student> listAll() {

        return studentRepository.findAll();
    }


    public void deleteStudent(Long  id) {

        studentRepository.deleteById(id);
    }

    public Student getStudentByID(Long studentid) {

        return studentRepository.findById(studentid).get();
    }
}
