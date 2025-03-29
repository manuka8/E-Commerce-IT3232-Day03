package lk.ac.vau.fas.ict.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ac.vau.fas.ict.model.Student;

@RestController
@RequestMapping("/app")
public class AppController {

	Student Bob = new Student("2020ICT43", "Bob", 56, "IT", 95.0);
	Student Alice = new Student("2020ICT49", "Aice", 56, "AMC", 140);
	Student George = new Student("2020ICT92", "Gerge", 56, "Bio", 56.0);

	List<Student> students = new ArrayList<Student>();

	@GetMapping("/students")
	public List<Student> getStudent() {
		students.add(Alice);
		students.add(Bob);
		students.add(George);

		return students;
	}

	@GetMapping("/regno/{rg}")
	public Student StudentDetals(@PathVariable("rg") String rg) {
		for (Student student : students) {
			if (student.getRegNo().equals(rg)) {
				return student;
			}
		}
		return null;

	}

	@GetMapping("/msg")
	public String myMessage() {
		return "Hello SprintBoot";
	}

	@GetMapping("/name")
	public String myName() {
		return "My name is SprintBoot";
	}

	@GetMapping("/reg")
	public String myReg() {
		return "My reg number 2020/ICT/43 /n u";
	}

	@GetMapping("/students/age-range")
	public List<Student> getStudentsByAgeRange() {
		List<Student> filteredStudents = new ArrayList<>();

		for (Student student : students) {
			if (student.getAge() >= 20 && student.getAge() <= 24) {
				filteredStudents.add(student);
			}
		}

		return filteredStudents;
	}

	@GetMapping("/age/{ag}")
	public String MyAge(@PathVariable("ag") int age) {
		return "My age is" + age;

	}

}
