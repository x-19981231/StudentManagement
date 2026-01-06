package raisetech.student.management.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.student.management.data.Student;
import raisetech.student.management.data.StudentCourse;
import raisetech.student.management.repository.StudentRepository;
import java.util.stream.Collectors;

@Service
public class StudentService {

  private final StudentRepository repository;


  @Autowired
  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

  public List<Student> searchStudentList() {
    return repository.searchStudents();
  }

  public List<StudentCourse> searchStudentsCourseList() {
    return repository.searchStudentsCourses();
  }
  // 30代の学生のみ
  public List<Student> searchStudentsIn30s() {
    return repository.searchStudents().stream()
        .filter(student -> student.getAge() >= 30 && student.getAge() <= 39)
        .collect(Collectors.toList());
  }

  // Java基礎コースの学生のみ
  public List<StudentCourse> searchJavaBasicCourseStudents() {
    return repository.searchStudentsCourses().stream()
        .filter(course -> "Java基礎コース".equals(course.getCourseName()))
        .collect(Collectors.toList());
  }
}


