package handlinglists.hadlinglists.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import handlinglists.hadlinglists.domain.Student;

@Controller
public class StudentController {
    static List<Student> students = new ArrayList<>();
    static {
        students.add(new Student("Kate", "Cole"));
        students.add(new Student("Dan", "Brown"));
        students.add(new Student("Mike", "Mars"));
    }

    @GetMapping("/hello")
    public String showStudents(Model model) {
        model.addAttribute("students", students);
        return "studentlist";
    }

}
