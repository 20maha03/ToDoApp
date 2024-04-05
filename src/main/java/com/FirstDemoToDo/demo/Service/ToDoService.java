package com.FirstDemoToDo.demo.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.FirstDemoToDo.demo.Model.ToDo;
import com.FirstDemoToDo.demo.dao.ToDoDao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Service
public class ToDoService {

    @Autowired
    private ToDoDao toDoDao;

    public List<ToDo> getAllInfo(String category, Long dueDate, String isDueTime) {
        if (isDueTime != null && ("overDue".equals(isDueTime) || "underDue".equals(isDueTime))) {
            List<ToDo> filteredTodos = new ArrayList<>();
            Calendar calendar = Calendar.getInstance();
            long currentTime = calendar.getTimeInMillis();
            for (ToDo todo : toDoDao.findAll()) {
                if ("overDue".equals(isDueTime) && todo.getDueDate() < currentTime) {
                    filteredTodos.add(todo);
                } else if ("underDue".equals(isDueTime) && todo.getDueDate() > currentTime) {
                    filteredTodos.add(todo);
                }
            }
            return filteredTodos;
        } else if (category == null && isDueTime == null && dueDate == null) {
            return toDoDao.findAll();
        } else if (category == null && dueDate != null) {
            return toDoDao.findByDueDate(dueDate);
        } else if (category != null && dueDate == null) {
            return toDoDao.findOnlyByCategory(category);
        }
        return toDoDao.findByCategory(category, dueDate);
    }
    
    @Autowired
    private EntityManager entityManager;

    public List<ToDo> findTodosByTitleSubstring(String title) {
    	String queryString = "SELECT * FROM To_Do q WHERE LOWER(q.title) LIKE LOWER(CONCAT('%', :title, '%')) OR LOWER(q.description) LIKE LOWER(CONCAT('%', :title, '%'))";
        Query query = entityManager.createNativeQuery(queryString, ToDo.class);
        query.setParameter("title", title.toLowerCase());
        return query.getResultList();
    }
    public ResponseEntity<String> addNewOne(ToDo todo) {
        toDoDao.save(todo);
        return new ResponseEntity<>("done", HttpStatus.CREATED);
    }

    public ResponseEntity<String> getOne(int id) {
        toDoDao.deleteById(id);
        return new ResponseEntity<>("done", HttpStatus.OK);
    }

    public ResponseEntity<String> updateOne(ToDo todo) {
        toDoDao.save(todo);
        return new ResponseEntity<>("done", HttpStatus.OK);
    }
}
