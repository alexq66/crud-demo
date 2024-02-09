package com.alexq66.cruddemo.dao;

import com.alexq66.cruddemo.entity.Student;

import java.util.List;

/**
 * Created by Kenneth Quinn on 2/9/2024
 */
public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);


}
