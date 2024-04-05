package com.FirstDemoToDo.demo.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.FirstDemoToDo.demo.Model.ToDo;

@Repository
public interface ToDoDao extends JpaRepository<ToDo, Integer> {

    @Query(
        value = "SELECT * FROM To_Do q WHERE q.category=:category AND q.due_date=:dueDate", 
        nativeQuery = true)
    public List<ToDo> findByCategory(String category, long dueDate);


    public List<ToDo> findByDueDate(Long dueDate);

    public List<ToDo> findOnlyByCategory(String category);

	public List<ToDo> findByTitle(String title);
}
