package com.dmitriy.tsoy.russia.JavaTests.repository;

import com.dmitriy.tsoy.russia.JavaTests.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
