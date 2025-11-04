package raisetech.student.management;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// 名前と年齢を保存するMap
	private Map<String, Integer> students = new HashMap<>();

	// 全データを取得（GET）
	@GetMapping
	public Map<String, Integer> getStudents() {
		return students;
	}

	// 1件追加（POST）
	@PostMapping
	public String addStudent(@RequestParam String name, @RequestParam int age) {
		students.put(name, age);
		return name + " (" + age + "歳) を追加しました。";
	}

	// データ更新（PUT）
	@PutMapping
	public String updateStudent(@RequestParam String name, @RequestParam int age) {
		if (students.containsKey(name)) {
			students.put(name, age);
			return name + " の年齢を " + age + " に更新しました。";
		} else {
			return name + " は存在しません。";
		}


}
}


