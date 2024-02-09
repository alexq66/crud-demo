package com.alexq66.cruddemo;

import com.alexq66.cruddemo.dao.StudentDAO;
import com.alexq66.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@SpringBootApplication
public class CrudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

        return runner -> {
            
            //createStudent(studentDAO);
             //createMultipleStudents(studentDAO);
            //readStudent(studentDAO);
            queryForStudents(studentDAO);

            
        };
    }

    private void queryForStudents(StudentDAO studentDAO) {

        List<Student> theStudents = studentDAO.findAll();

        for(Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }

    }

    private void readStudent(StudentDAO studentDAO) {

        System.out.print("Creating new student object...");
        Student tempstudent = new Student("Alex", "Quinn", "Alex@example.com");

        System.out.println("Saving the student...");
        studentDAO.save(tempstudent);

        System.out.println("Student saved with ID: " + tempstudent.getId());

        System.out.println("Retrieving student with ID: " + tempstudent.getId());
        Student myStudent = studentDAO.findById(tempstudent.getId());

        System.out.println("Found the student: " + myStudent);


    }

    private void createStudent(StudentDAO studentDAO) {

        System.out.print("Creating new student object...");
        Student tempstudent = new Student("Alex", "Quinn", "Alex@example.com");

        System.out.println("Saving the student...");
        studentDAO.save(tempstudent);

        System.out.println("Student saved with ID: " + tempstudent.getId());
    }

    private void createMultipleStudents(StudentDAO studentDAO) {

        System.out.println("Creating multiple student objects...");
        Student student1 = new Student("John", "Doe", "john@example.com");
        Student student2 = new Student("Jane", "Smith", "jane@example.com");
        Student student3 = new Student("Alex", "Quinn", "Alex@example.com");

        System.out.println("Saving the students...");
        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);

        System.out.println("Students saved with IDs: " + student1.getId() + ", " + student2.getId() + ", " + student3.getId());
    }

}
