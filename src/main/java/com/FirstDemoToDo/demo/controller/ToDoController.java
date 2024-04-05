package com.FirstDemoToDo.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FirstDemoToDo.demo.Model.ToDo;
import com.FirstDemoToDo.demo.Service.ToDoService;

@RestController
@RequestMapping("api/v1")
public class ToDoController {

    @Autowired
    ToDoService toDoService;

    @GetMapping(path="/todos", produces= {"application/json"})
    public ResponseEntity<List<ToDo>> getAllInfo(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Long dueDate,
            @RequestParam(required = false) String isDueTime,
            @RequestParam(required = false) String title) {
        List<ToDo> toDoList;
        if (title != null) {
            toDoList = toDoService.findTodosByTitleSubstring(title);
        } else {
            toDoList = toDoService.getAllInfo(category, dueDate, isDueTime);
        }
        return new ResponseEntity<>(toDoList, HttpStatus.OK);
    }

    @PostMapping("/todos")
    public ResponseEntity<String> addNewOne(@RequestBody ToDo todo) {
        return toDoService.addNewOne(todo);
    }

    @DeleteMapping("todos/{id}")
    public ResponseEntity<String> getOne(@PathVariable int id) {
        return toDoService.getOne(id);
    }

    @PutMapping("todos/{id}")
    public ResponseEntity<String> updateOne(@RequestBody ToDo todo , @PathVariable int id) {
        return toDoService.updateOne(todo);
    }
}
