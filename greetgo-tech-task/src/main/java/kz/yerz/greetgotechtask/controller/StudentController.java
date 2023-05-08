package kz.yerz.greetgotechtask.controller;

import kz.yerz.greetgotechtask.entity.Student;
import kz.yerz.greetgotechtask.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/student")
public class StudentController {


    private StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping(value = "/save")
    public Long saveStudent(@RequestBody Student student) {

        service.saveorUpdate(student);
        return student.getId();
    }

    @GetMapping(value = "/getall")
    public Iterable<Student> getStudents() {
        return service.listAll();
    }

    @PutMapping(value = "/edit/{id}")
    public Student update(@RequestBody Student student, @PathVariable(name = "id") Long id) {
        student.setId(id);
        service.saveorUpdate(student);
        return student;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
        service.deleteStudent(id);
    }


    @RequestMapping("/search/{id}")
    private Student getStudents(@PathVariable(name = "id") Long studentid) {
        return service.getStudentByID(studentid);
    }

}
