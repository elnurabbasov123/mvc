package com.example.mvc.repository;

import com.example.mvc.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepositoryJPA extends JpaRepository<Language,Integer> {
}
