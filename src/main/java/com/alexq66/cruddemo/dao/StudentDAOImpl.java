package com.alexq66.cruddemo.dao;

import com.alexq66.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
}