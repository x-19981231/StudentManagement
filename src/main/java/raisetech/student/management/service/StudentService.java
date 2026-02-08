package raisetech.student.management.service;


import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import raisetech.student.management.data.Student;
import raisetech.student.management.data.StudentCourse;
import raisetech.student.management.domain.StudentDetail;
import raisetech.student.management.repository.StudentRepository;

@Service
public class StudentService {

  private final StudentRepository repository;


  @Autowired
  public StudentService(StudentRepository repository) {

    this.repository = repository;
  }

  public List<Student> searchStudentList() {
    return repository.search();
  }

  public StudentDetail searchStudent(String id){
   Student student = repository.searchStudent(id);
   List<StudentCourse> studentCourses = repository.searchStudentsCourses(student.getId());
   StudentDetail studentDetail = new StudentDetail();
   studentDetail.setStudent(student);
   studentDetail.setStudentsCourses(studentCourses);
   return studentDetail;
  }

  public List<StudentCourse> searchStudentsCourseList() {
    return repository.searchStudentsCoursesList();
  }

  @Transactional
  public void registerStudent(StudentDetail studentDetail) {
    repository.registerStudent(studentDetail.getStudent());
    for (StudentCourse studentCourse : studentDetail.getStudentsCourses()) {
      studentCourse.setStudentId(studentDetail.getStudent().getId());
      studentCourse.setStartDate(LocalDateTime.now());
      studentCourse.setEndDate(LocalDateTime.now().plusYears(1));
    repository.registerStudentsCourses(studentCourse);
  }
}
  @Transactional
  public void updateStudent(StudentDetail studentDetail) {
    repository.updateStudent(studentDetail.getStudent());
    for (StudentCourse studentCourse : studentDetail.getStudentsCourses()) {
      studentCourse.setStudentId(studentDetail.getStudent().getId());
      repository.updateStudentsCourses(studentCourse);

    }
}
}


