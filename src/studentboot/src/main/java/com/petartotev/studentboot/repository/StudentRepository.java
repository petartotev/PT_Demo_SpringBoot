package com.petartotev.studentboot.repository;

import com.petartotev.studentboot.model.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class StudentRepository {
    private final Map<Long, Student> students = new HashMap<>();
    private long currentId = 1;

    public Student save(Student student) {
        if (student.getId() == null) {
            student.setId(currentId++);
        }
        students.put(student.getId(), student);
        return student;
    }

    public Optional<Student> findById(Long id) {
        return Optional.ofNullable(students.get(id));
    }

    public Iterable<Student> findAll() {
        return students.values();
    }

    public void deleteById(Long id) {
        students.remove(id);
    }
}