package com.example.Redis.demo.Repository;

import com.example.Redis.demo.Entity.Student;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Map;
@Repository
public class StudentRepository{

    public final String KEY="STUDENT";

    @Resource(name ="redisTemplate")
    private HashOperations<String, Integer, Student> hashOperations;




    public Map<Integer, Student> getAll() {
        //hashRef ,get All rows as Map
        System.out.println("Get All Data");
         return hashOperations.entries(KEY);
    }
    public Student getById(int id) {
        // read one record based on HashRef and Id
        System.out.println("Data Get BY Id");
        return hashOperations.get(KEY,id);
    }


    public void addStudent(Student student) {
        //Create new record in HASHKEY if given id does not exist
        hashOperations.put(KEY,student.getId(),student);

    }


    public Student update(int id, Student student) {
        System.out.println("Data Updated");
         hashOperations.put(KEY,id,student);
         return student;
    }


    public void delete(int id) {
        System.out.println("Data Deleted");
        hashOperations.delete(KEY,id);

    }
}
