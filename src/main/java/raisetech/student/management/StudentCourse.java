package raisetech.student.management;


import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentCourse {

  private String id;
  private String student_id;
  private String course_Name;
  private LocalDateTime startDate;
  private LocalDateTime endDate;

}
