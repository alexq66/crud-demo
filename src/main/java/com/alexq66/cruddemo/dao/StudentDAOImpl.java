package com.alexq66.cruddemo.dao;

import com.alexq66.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Kenneth Quinn on 2/9/2024
 */
@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {

        this.entityManager = entityManager;

    }

    @Override
    @Transactional
    public void save(Student theStudent) {

        entityManager.persist(theStudent);

    }

    @Override
    public Student findById(Integer id) {

        return entityManager.find(Student.class, id);

    }

    @Override
    public List<Student> findAll() {

        TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);
        return query.getResultList();

    }

    @Override
    public List<Student> findByLastName(String theLastName) {

        TypedQuery<Student> query  = entityManager.createQuery("FROM Student WHERE lastName = :theData", Student.class);
        query.setParameter("theData", theLastName);
        return query.getResultList();

    }

    @Override
    @Transactional
    public void update(Student theStudent) {

        entityManager.merge(theStudent);

    }

    @Override
    @Transactional
    public void delete(Integer id) {

        Student tempStudent = entityManager.find(Student.class, id);

        entityManager.remove(tempStudent);

    }

    @Override
    @Transactional
    public int deleteAll() {

        int numStudentsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numStudentsDeleted;
    }


}
