package raisetech.student.management.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import raisetech.student.management.data.Student;
import raisetech.student.management.data.StudentCourse;

@Mapper
public interface StudentRepository {


  @Select("SELECT * FROM students")
  List<Student> search();

  @Select("SELECT * FROM students_courses")
  List<StudentCourse> searchStudentsCourses();

  @Insert("""
  INSERT INTO students (
    id,
    name,
    kana_name,
    nickname,
    email,
    area,
    age,
    gender,
    remark,
    is_deleted
  ) VALUES (
    #{id},
    #{name},
    #{kanaName},
    #{nickName},
    #{email},
    #{area},
    #{age},
    #{gender},
    #{remark},
    false
  )
""")
  void insertStudent(Student student);
}









