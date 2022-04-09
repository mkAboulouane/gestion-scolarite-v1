package com.example1.test1_withoutsecurity.ws;

import com.example1.test1_withoutsecurity.bean.Note;
import com.example1.test1_withoutsecurity.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gestion/note")
public class NoteRest {

    @Autowired
    private NoteService noteService;

    @PostMapping("/")
    public int save(@RequestBody Note note) {
        return noteService.save(note);
    }

    @GetMapping("/resultat/{resultat}")
    public List<Note> findByResultat(@PathVariable double resultat) {
        return noteService.findByResultat(resultat);
    }

    @GetMapping("/nv/mat/{mat}")
    public List<Note> findByNv(@PathVariable String mat) {
        return noteService.findByNv(mat);
    }

    @GetMapping("/ratt/{mat}")
    public List<Note> findByRatt(String mat) {
        return noteService.findByRatt(mat);
    }

    @GetMapping("/findbvm/{mat}")
    public List<Note> findByVM(@PathVariable String mat) {
        return noteService.findByVM(mat);
    }

    @GetMapping("/")
    public List<Note> findAll() {
        return noteService.findAll();

    }
}
