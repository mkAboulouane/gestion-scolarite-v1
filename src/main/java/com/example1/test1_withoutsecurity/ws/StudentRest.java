package com.example1.test1_withoutsecurity.ws;
import com.example1.test1_withoutsecurity.bean.Student;
import com.example1.test1_withoutsecurity.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;              //Absence + Prof + Niveau : khalil
import java.util.Optional;

@RestController
@RequestMapping("/api/gestion/student")
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
    public List<Student> findSameNiveauAndFilliere(@PathVariable String id_niveau,@PathVariable String id_fil) {
        return studentService.findSameNiveauAndFilliere(id_niveau, id_fil);
    }

    @GetMapping("/niveau/{semestre}/")
    public List<Student> findSameNiveau(@PathVariable String semestre) {
        return studentService.findSameNiveau(semestre);
    }

    @GetMapping("/filliere/{nom_fil}/")
    public List<Student> findSameFilliere(@PathVariable String nom_fil) {
        return studentService.findSameFilliere(nom_fil);
    }

    @Autowired
    private StudentService studentService;
//
//    @DeleteMapping("/{apoge}/")
//    public int deleteByApoge(@PathVariable String apoge) {
//       return studentService.deleteByApoge(apoge);
//    }

//
//    @GetMapping("/id/{id}/")
//    public Optional<Student> findById1(@PathVariable Long id) {
//        return studentService.findById1(id);
//    }
//

}
