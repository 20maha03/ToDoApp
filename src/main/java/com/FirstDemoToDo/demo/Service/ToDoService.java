package com.FirstDemoToDo.demo.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.FirstDemoToDo.demo.Model.ToDo;
import com.FirstDemoToDo.demo.dao.ToDoDao;

@Service
public class ToDoService {

    @Autowired
    private ToDoDao toDoDao;
    
    public List<ToDo> getAllInfo(String category, Long dueDate, String isDueTime) {
    	if (isDueTime != null && ("overDue".equals(isDueTime) || "underDue".equals(isDueTime))) {
    	   System.out.println("time is present");
            List<ToDo> filteredTodos = new ArrayList<>();
            Calendar calendar = Calendar.getInstance();
            long currentTime = calendar.getTimeInMillis();
             System.out.println("l:"+currentTime);    
            for (ToDo todo : toDoDao.findAll()) {
                if ("overDue".equals(isDueTime) && todo.getDueDate() < currentTime) {
                    filteredTodos.add(todo);
                } else if ("underDue".equals(isDueTime) && todo.getDueDate() > currentTime) {
                    filteredTodos.add(todo);
                }
            }
            return filteredTodos;
        }
       else if (category == null && isDueTime == null && dueDate == null ) {
       	System.out.println("both are null");
           return toDoDao.findAll();
       } 
       else if (category == null && dueDate != null) {
       	System.out.println("c  are null");
           return toDoDao.findByDueDate(dueDate);
       } 
        else if (category != null && dueDate == null) {
        	System.out.println("c not  null");
            return toDoDao.findOnlyByCategory(category);
        }
            
        return toDoDao.findByCategory(category, dueDate);
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
