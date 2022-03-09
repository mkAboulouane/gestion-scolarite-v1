package com.example1.test1_withoutsecurity.ws;
import com.example1.test1_withoutsecurity.bean.Student;
import com.example1.test1_withoutsecurity.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;              //Absence + Prof + Niveau : khalil
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/student")
public class StudentRest {

    @PostMapping("/")
    public String save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @GetMapping("/")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/apoge/{apoge}/")
    public Student findByApoge(@PathVariable String apoge) {
        return studentService.findByApoge(apoge);
    }

    @GetMapping("/niveau/{id_niveau}/id_fil/{id_fil}")
    public List<Student> findSameNiveauAndFilliere(@PathVariable Long id_niveau,@PathVariable Long id_fil) {
        return studentService.findSameNiveauAndFilliere(id_niveau, id_fil);
    }

    @GetMapping("/niveau/{id_niveau}/")
    public List<Student> findSameNiveau(@PathVariable Long id_niveau) {
        return studentService.findSameNiveau(id_niveau);
    }

    @GetMapping("/filliere/{id_fil}/")
    public List<Student> findSameFilliere(@PathVariable Long id_fil) {
        return studentService.findSameFilliere(id_fil);
    }

    @DeleteMapping("/apoge/{apoge}/")
    public void deleteByApoge(@PathVariable String apoge) {
        studentService.deleteByApoge(apoge);
    }

    @GetMapping("/id/{id}/")
    public Optional<Student> findById1(@PathVariable Long id) {
        return studentService.findById1(id);
    }

    @Autowired
    private StudentService studentService;
}
