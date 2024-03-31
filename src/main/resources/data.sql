CREATE TABLE toDo (
    id INT PRIMARY KEY,
    title VARCHAR(255),
    description VARCHAR(255),
    due_date BIGINT, 
    category VARCHAR(255),
    is_completed BOOLEAN
);
insert into toDo (id, title, description, due_date,category,is_completed) values
(21, 'semResult', '',1714458600001,'College',false),
(22, 'party', 'birthDay',1713076240000,'Personal',false),
(33, 'interview','in zoho', 1711953000000,'job',false);
insert into TO_DO  (id,title, description, due_date,category,is_completed) values
(1, 'semResult','announced by AN', 1682855718000,'University',false),
(2, 'party','bachelorsparty', 1685447718000,'family',false),
(3, 'interview', 'in google',1790718118000,'job',false);