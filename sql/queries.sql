--CREATE VIEW [Active Students] AS 
--SELECT * FROM student 
--WHERE enrolled = True
--ORDER BY studentuid; 

--CREATE VIEW [Instructors Names] AS 
--SELECT instructorname FROM instructor
--ORDER by instructorname; 

CREATE VIEW [Active Class Names] AS 
SELECT ClassName FROM class
WHERE semester = "Spring 2021"
ORDER BY classid; 


CREATE VIEW [Number Taking Class] AS 
Select classid, count(*) FROM student
GROUP BY classid;

CREATE VIEW [Professors teaching most classes] AS 
SELECT instructoruid FROM class
WHERE COUNT(instructoruid) = 
    (SELECT MAX(COUNT(instructoruid)) FROM class
        GROUP BY  instructoruid
    )
GROUP BY instructoruid;

CREATE VIEW [Assignment Average Grade] AS 
SELECT assignmentid, SUM(points_earned)/SUM(total_point) FROM grade 
GROUP BY assignmentid;

CREATE VIEW [Average Assignments For Class per Professor] AS 
SELECT instructor.instructoruid, COUNT(DISTINCT assignment.assignmentid)/COUNT(DISTINCT instructor.classid) FROM instructor 
LEFT JOIN assignment 
ON instructor.classid = assignment.classid
GROUP BY instructor.instructoruid;

CREATE VIEW [Student and Instructor] as 
SELECT instructorname FROM instructor 
WHERE (
    SELECT studentname FROM student WHERE instructorname = studentname
);

CREATE VIEW [Admin Names] AS 
SELECT name FROM user 
WHERE EXISTS (
    SELECT * FROM role WHERE user.uid = role.useruid AND role.admin = True  
);



