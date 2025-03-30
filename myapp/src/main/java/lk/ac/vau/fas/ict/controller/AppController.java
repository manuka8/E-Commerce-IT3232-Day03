package lk.ac.vau.fas.ict.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lk.ac.vau.fas.ict.model.Student;

@RestController
@RequestMapping("/app")
public class AppController {

    private List<Student> students = new ArrayList<Student>();

    public AppController() {
        Student bob = new Student("2020ICT43", "Bob", 56, "IT", 95.0);
        Student alice = new Student("2020ICT49", "Alice", 56, "AMC", 140.0);
        Student george = new Student("2020ICT92", "George", 56, "Bio", 56.0);
        
        students.add(alice);
        students.add(bob);
        students.add(george);
    }

    @GetMapping("/students")
    public List<Student> getStudent() {
        return students;
    }
    
    @GetMapping("/regno/{rg}")
    public Student StudentDetails(@PathVariable("rg") String rg) {
        for (Student student : students) {
            if (student.getRegNo().equals(rg)) {
                return student;
            }
        }
        return null;
    }

    @GetMapping("/msg")
    public String myMessage() {
        return "Hello SpringBoot";
    }

    @GetMapping("/name")
    public String myName() {
        return "My name is SpringBoot";
    }

    @GetMapping("/reg")
    public String myReg() {
        return "My reg number 2020/ICT/43 \n u";
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

    @GetMapping("/students/sorted-by-gpa")
    public List<Student> getStudentsSortedByGPA() {
        List<Student> sortedStudents = new ArrayList<>(students);
        sortedStudents.sort((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa()));
        return sortedStudents;
    }

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        students.add(student);
        return "Student added successfully!";
    }

    @PutMapping("/{regNo}")
    public String updateStudent(@PathVariable("regNo") String regNo, @RequestBody Student updatedStudent) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRegNo().equalsIgnoreCase(regNo)) {
                students.set(i, updatedStudent);
                return "Student updated successfully!";
            }
        }
        return "Student not found!";
    }

    @DeleteMapping("/{regNo}")
    public String deleteStudent(@PathVariable("regNo") String regNo) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRegNo().equalsIgnoreCase(regNo)) {
                students.remove(i);
                return "Student deleted successfully!";
            }
        }
        return "Student not found!";
    }
}