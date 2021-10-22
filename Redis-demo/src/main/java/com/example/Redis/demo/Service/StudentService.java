package com.example.Redis.demo.Service;

import com.example.Redis.demo.Entity.Student;
import com.example.Redis.demo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

   // @Cacheable
    public Map<Integer, Student> getAll(){
        return studentRepository.getAll();

    }
    @Cacheable(key = "#id", value= "Student")
    public Student getById(int id){
        return studentRepository.getById(id);

    }

    public void addStudent(Student student){
        studentRepository.addStudent(student);

    }
    @CachePut(key = "#id", value = "Student")
    public Student update(int id,Student student){
        Student student1 = studentRepository.getById(id);
        student1.setId(student.getId());
        student1.setName(student.getName());
        student1.setFees(student.getFees());
        studentRepository.update(id, student1);
        return student1;

    }
    @CacheEvict(key = "#id",value = "Student")
    public void delete(int id){
        studentRepository.delete(id);

    }
}
