# ToDo App using Spring Boot

This project is a simple ToDo application built using Spring Boot. It allows users to manage their tasks by performing CRUD operations (Create, Read, Update, Delete). Users can add new tasks, update existing ones, delete tasks, and also filter tasks based on any field defined in the task class.

## Features

- CRUD operations: Users can Create, Read, Update, and Delete tasks.
- Filter tasks: Users can filter tasks based on any field defined in the task class.
- RESTful API: Implemented using Spring Boot to provide easy integration with front-end applications.
- Database integration: Uses a relational database (e.g H2) to store task data.

## API Endpoints

The following endpoints are available:

- `GET /api/v1/todos`: Get all tasks.
- `POST /api/v1/todos`: Add a new task.
- `GET /api/v1/todos?id=value`: Get a specific task by ID.
- `PUT /api/v1/todos/{id}`: Update an existing task.
- `DELETE /api/v1/todo/{id}`: Delete a task by ID.
- `GET /api/v1/todos?field=value`: Filter tasks based on a specific field.

## Author

Mahalakshmi M 

Feel free to contribute by submitting bug reports, feature requests, or pull requests!
