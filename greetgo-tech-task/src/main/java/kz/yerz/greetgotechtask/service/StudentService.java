package kz.yerz.greetgotechtask.service;

import kz.yerz.greetgotechtask.entity.Student;

public interface StudentService {

    Student saveorUpdate(Student student);

    Iterable<Student> listAll();


    void deleteStudent(Long id);

    Student getStudentByID(Long  studentid);
}
