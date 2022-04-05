Create Table user(
    uid INT UNIQUE, 
    name VARCHAR(20) NOT NULL, 
    username VarChar(20) NOT NULL, 
    password VarChar(20) NOT NULL, 
    Primary Key(uid)
); 

Create Table role(
    useruid INT UNIQUE, 
    role VARCHAR(20), 
    admin bool, 
    FOREIGN KEY(useruid),
    Primary Key(useruid)
); 
Create Table instructor(
    instructoruid INT UNIQUE, 
    instructorname Varchar(20) NOT NULL, 
    classid INT NOT NULL,
    Primary Key(instructoruid),
    Foreign Key(instructoruid, classid)
); 
Create Table student(
    studentid int unique, 
    studentname VarChar(20) Not NULL, 
    classID int NOT NULL, 
    enrolled Bool NOT NULL, 
    degree_type VarChar(10),
    Primary Key(studentuid), 
    Foreign Key(studentuid, classid),
    CONSTRAINT chk_degree CHECK degree_type = "undergrad" or degree_type = "masters" or degree_type = "phd"
); 
Create Table course_content(
    fileid int unqiue, 
    classid int not null, 
    file VarChar(20), 
    description VarChar(100), 
    lectureDate Date, 
    lectureid int, 
    content_type VarChar(10)
    Primary Key(fileid), 
    FOREIGN Key(classid) 
); 
Create Table class(
    classid int unique,
    instructoruid int NOT NULL, 
    class_name VarChar(20) NOT NULL, 
    semester VarChar(20) NOT NULL , 
    Primary Key(classid),
    Foreign Key(instructoruid)
); 
Create Table assignment(
    assignmentuid int unqiue, 
    classid int not NULL, 
    title VarChar(20),
    description VarChar(20), 
    file VarChar(20), 
    due_date Date, 
    type VarChar(20),
    Primary Key(assignmentuid),
    Foreign Key(classid)
    
); 
Create Table grade(
    gradeid int UNIQUE, 
    studentuid int NOT NULL, 
    assignmentid int not null, 
    total_points int, 
    points_earend int, 
    Primary Key(studentuid, assignmentuid)
); 

