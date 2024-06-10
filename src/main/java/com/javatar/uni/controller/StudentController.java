package com.javatar.uni.controller;

import com.javatar.uni.model.Student;
import com.javatar.uni.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("stu")
public class StudentController {

//    private List<Student> students = new ArrayList<>();
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> studentList(){
//        return students;
        return studentRepository.findAll(); // select * from student;
    }

    @PostMapping
    public Student save(@RequestBody Student studentRequest){
//        students.add(studentRequest);
//        return studentRequest;
        return studentRepository.save(studentRequest); // insert into student (id, firstname, lastname, age) values (1, 'ali', 'sadeghi', 12);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id){
//        students.remove(id);
        studentRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public Student update(@PathVariable("id") Long id,@RequestBody  Student student){
//        int count = 0;
//        Student student1 = new Student();
//        for (Student stu: students){
//            if(stu.getId() == id){
//                student1 = stu;
//                count = students.indexOf(stu);
//            }
//        }
//        if(student.getFirstname() != null){
//            student1.setFirstname(student.getFirstname());
//        } else if(student.getLastname() != null){
//            student1.setLastname(student.getLastname());
//        }
//        students.set(count, student1);
//        return student1;
        Student stu = studentRepository.findById(id).get();
        if(student.getFirstname() != null){
            stu.setFirstname(student.getFirstname());
        } else if(student.getLastname() != null) {
            stu.setLastname(student.getLastname());
        }
        return studentRepository.save(stu);

    }

    //Todo Implement GetMapping find Student By Id
    @GetMapping("{id}")
    public Student findStudentById(@PathVariable("id") Long id){
        return studentRepository.findById(id).get();
    }


}
