package com.dmitriy.tsoy.russia.JavaTests.repository;

import com.dmitriy.tsoy.russia.JavaTests.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

    @Transactional
    @Query(value="SELECT * FROM answer WHERE question_id = :id", nativeQuery = true)
    List<Answer> getAnswersForQuestion(@Param("id")long id);

    @Transactional
    @Modifying
    @Query(value="DELETE FROM answer WHERE question_id = :id", nativeQuery = true)
    void deleteAnswersForQuestion(@Param("id")long id);
}
