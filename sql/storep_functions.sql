CREATE PROCEDURE StudentGradeForAssignment(IN student_uid INT, IN grade_id INT, IN assignment_id,  OUT percent INT)
   SELECT points_earned/total_points
   INTO percent
   FROM grade
   WHERE gradeid = grade_id AND studentuid = student_uid AND assignmentid = assignment_id;

CREATE PROCEDURE TodaysLecture(IN today Date, IN thisClass int,  OUT today_file VarChar(20))
   SELECT file
   INTO today_file
   FROM course_content
   WHERE lecturedate = today and classid = thisClass ;



CREATE FUNCTION ClassSize(desired_classid INT)
   RETURNS VARCHAR(20)
   READS SQL DATA
BEGIN

   DECLARE classSize INT;

   SELECT COUNT(*)
   INTO income
   FROM student
   WHERE student.classid = desired_classid;

   IF classSize < 50 THEN 
      RETURN "SMALL"
   ELSE
      RETURN "LARGE
   END IF;

END;


