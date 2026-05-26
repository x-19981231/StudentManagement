package raisetech.student.management.data;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class
Student {

  private Integer id;

  @NotBlank
  @Size(max = 20)
  private String name;

  private String kanaName;

  private String nickName;

  @Email
  private String email;

  private String area;

  private int age;

  private String gender;

  private String remark;

  private Boolean isDeleted;

}
