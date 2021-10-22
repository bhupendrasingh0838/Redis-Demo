package com.example.Redis.demo.Controller;

import com.example.Redis.demo.Entity.Student;
import com.example.Redis.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@RestController
public class StudentController {
    @Autowired
    StudentService service;

    @GetMapping("/getAll")
    public Map<Integer, Student> getAll(){
        return service.getAll();

    }
    @GetMapping("/getById/{id}")
    public Student getById(@PathVariable int id){
        return service.getById(id);

    }
    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student){
        service.addStudent(student);
        return "Data Created";

    }
    @PutMapping("/update/{id}")
    public String update(@PathVariable int id,@RequestBody Student student){
        service.update(id, student);
        return "Data Updated";

    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        service.delete(id);
        return "Data Deleted";

    }

}
