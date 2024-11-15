package pkg1.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	@Autowired
	StudentRepo sr;
	
	@GetMapping("/hello")
	public String printHello() {
		return "Hello Pratheek";
	}
	
	@PostMapping("/student/add")
	public StudentEntity addStudent(@RequestBody StudentEntity se) {
		return sr.save(se);
	}
	
	@GetMapping("/student/getAll")
	public List<StudentEntity> getAllStudents(){
		return sr.findAll();
	}
	@GetMapping("/student/get/{id}")
	public Optional<StudentEntity> getStudentsById(@PathVariable int id){
		return sr.findById(id);
	}
	@GetMapping("/student/get")
	public Optional<StudentEntity> getStudentsById2(@RequestParam int id){
		return sr.findById(id);
	}

}
