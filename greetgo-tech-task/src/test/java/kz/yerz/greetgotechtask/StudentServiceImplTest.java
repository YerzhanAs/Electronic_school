package kz.yerz.greetgotechtask;


import kz.yerz.greetgotechtask.entity.Student;
import kz.yerz.greetgotechtask.repository.StudentRepository;
import kz.yerz.greetgotechtask.service.Impl.StudentServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class StudentServiceImplTest {
    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveOrUpdate() {
        Student student = new Student(1L, "John Smith", "123 Main St", "555-1234", 20);
        when(studentRepository.save(any(Student.class))).thenReturn(student);

        Student savedStudent = studentService.saveorUpdate(student);

        verify(studentRepository, times(1)).save(student);
        Assert.assertEquals(savedStudent, student);
    }

    @Test
    public void testListAll() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1L, "John Smith", "123 Main St", "555-1234", 20));
        students.add(new Student(2L, "Jane Doe", "456 Elm St", "555-5678", 25));
        when(studentRepository.findAll()).thenReturn(students);

        Iterable<Student> result = studentService.listAll();

        verify(studentRepository, times(1)).findAll();
        Assert.assertEquals(result, students);
    }

    @Test
    public void testDeleteStudent() {
        Long id = 1L;

        studentService.deleteStudent(id);

        verify(studentRepository, times(1)).deleteById(id);
    }

    @Test
    public void testGetStudentById() {

        Long id = 1L;
        Student student = new Student(id, "John Smith", "123 Main St", "555-1234", 20);
        when(studentRepository.findById(id)).thenReturn(Optional.of(student));

        Student result = studentService.getStudentByID(id);

        verify(studentRepository, times(1)).findById(id);
        Assert.assertEquals(result, student);
    }
}
