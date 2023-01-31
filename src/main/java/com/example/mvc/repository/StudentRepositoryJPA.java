package com.example.mvc.repository;

import com.example.mvc.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepositoryJPA extends JpaRepository<Student,Integer> {

    List<Student> findAllByName(String name);

    @Query(value = "select * from students    where surname like %?1% ",nativeQuery = true)
    List<Student> searchStudentsBySurname(String surname);

}
