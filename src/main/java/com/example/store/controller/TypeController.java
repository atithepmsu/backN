package com.example.store.controller;

import com.example.store.model.Type;
import com.example.store.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/type/getall")
    public ResponseEntity<List<Type>> findAll() {
        List<Type> types = typeService.findAll();
        return new ResponseEntity<>(types, HttpStatus.OK);
    }

    @PostMapping("/type/save")
    public Type create(@RequestBody Type type) {
        return typeService.create(type);
    }

    @PutMapping("/type/update/{id}")
    public Type update(@PathVariable("id") int id, @RequestBody Type type) {
        return typeService.update(id, type);
    }

    @DeleteMapping("/type/delete/{id}")
    public void delete(@PathVariable("id") int id) {
        typeService.delete(id);
    }
}
