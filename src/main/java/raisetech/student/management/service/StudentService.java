package raisetech.student.management.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.student.management.data.Student;
import raisetech.student.management.data.StudentCourse;
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

  public List<StudentCourse> searchStudentsCourseList() {
    return repository.searchStudentsCourses();
  }

  public void registerStudent(Student student) {
    student.setName(
        student.getName().replace("　", " ")
    );

    if (student.getRemark() != null && student.getRemark().isBlank()) {
      student.setRemark(null);
    }

    repository.insertStudent(student);
  }

}


