package com.petartotev.studentboot.repository;

import com.petartotev.studentboot.model.Student;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class StudentRepositoryTest {

    private StudentRepository repository;

    @BeforeEach
    void setUp() {
        repository = new StudentRepository();
    }

    @Test
    void testSaveStudent() {
        Student student = new Student();
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setAge(20);
        student.setDateOfBirth(LocalDate.of(2003, 1, 15));
        student.setGender(Student.Gender.MALE);

        Student savedStudent = repository.save(student);

        assertNotNull(savedStudent.getId());
        assertEquals("John", savedStudent.getFirstName());
    }

    @Test
    void testFindStudentById() {
        Student student = new Student();
        student.setFirstName("Jane");
        repository.save(student);

        Optional<Student> foundStudent = repository.findById(student.getId());

        assertTrue(foundStudent.isPresent());
        assertEquals("Jane", foundStudent.get().getFirstName());
    }

    @Test
    void testFindAllStudents() {
        repository.save(new Student());
        repository.save(new Student());

        Iterable<Student> students = repository.findAll();

        assertNotNull(students);
        assertEquals(2, ((Collection<?>) students).size());
    }

    @Test
    void testDeleteStudentById() {
        Student student = new Student();
        repository.save(student);

        repository.deleteById(student.getId());

        Optional<Student> deletedStudent = repository.findById(student.getId());
        assertFalse(deletedStudent.isPresent());
    }
}