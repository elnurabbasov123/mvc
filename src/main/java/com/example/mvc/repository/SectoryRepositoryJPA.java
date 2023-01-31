package com.example.mvc.repository;

import com.example.mvc.model.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectoryRepositoryJPA extends JpaRepository<Sector,Integer> {

}
