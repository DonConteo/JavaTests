package com.dmitriy.tsoy.russia.JavaTests.repository;

import com.dmitriy.tsoy.russia.JavaTests.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Transactional
    @Query(value="SELECT * FROM question WHERE theme = :theme ORDER BY RANDOM() limit 15", nativeQuery = true)
    List<Question> getRandomQuestions(@Param("theme") String theme);
}
