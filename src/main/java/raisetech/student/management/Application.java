package raisetech.student.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	private String name = "Enami Kouji";
	private String age = "37";

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello World!";
	}

	@GetMapping("/konichiwa")
	public String konichiwa() {
		return "こんにちは!今日はいい天気ですね";
	}

	@GetMapping("/studentInfo")
	public String getstudentInfo(){
		return name + "" + age + "歳";
	}
	@GetMapping("/age")
	public String getAge(){
		return age;
	}
	@PostMapping("/studentInfo")
	public void setstudentInfo(String name,String age){
		this.name = name;
		this.age = age;
	}
	@PostMapping("studentName")
public void updateStudentName(String name){
		this.name = name;
	}
}
