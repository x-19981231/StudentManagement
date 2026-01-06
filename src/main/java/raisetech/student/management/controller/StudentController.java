package raisetech.student.management.controller;


import java.util.List;
import raisetech.student.management.data.Student;
import raisetech.student.management.service.StudentService;
import raisetech.student.management.data.StudentCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

  private final StudentService service;

  @Autowired
  public StudentController(StudentService service) {
    this.service = service;
  }

  @GetMapping("/studentList")
  public List<Student> getStudentList(){
    return service.searchStudentList();
  }

  @GetMapping("/studentsCourseList")
  public List<StudentCourse> getStudentsCourseList() {
    return service.searchStudentsCourseList();
  }

  @GetMapping("/students/30s")
  public List<Student> getStudentsIn30s() {
    return service.searchStudentsIn30s();
  }

  @GetMapping("/courses/java-basic")
  public List<StudentCourse> getJavaBasicCourseStudents() {
    return service.searchJavaBasicCourseStudents();
  }
}
