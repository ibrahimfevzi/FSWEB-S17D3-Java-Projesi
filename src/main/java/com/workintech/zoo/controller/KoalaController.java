package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Gender;
import com.workintech.zoo.entity.Koala;
import com.workintech.zoo.exceptions.AnimalValidator;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/koalas")
public class KoalaController {

    private Map<Integer, Koala> koalas;

    @PostConstruct
    public void init(){
        koalas = new HashMap<>();
        koalas.put(1, new Koala(1, "Koala1", 4, Gender.MALE, 20));
    }

    @GetMapping("/")
    public List<Koala> getAll(){
        return koalas.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Koala get(@PathVariable int id){
        AnimalValidator.isIdValid(id);
        return koalas.get(id);
    }

    @PostMapping("/")
    public Koala save(@RequestBody Koala koala){
       AnimalValidator.isIdValid(koala.getId());
        AnimalValidator.isAnimalValid(koala);
        AnimalValidator.isKoalaValid(koala);
        koalas.put(koala.getId(), koala);
        return koalas.get(koala.getId());
    }

    @PutMapping("/{id}")
    public Koala update(@PathVariable int id, @RequestBody Koala koala){
        AnimalValidator.isIdValid(koala.getId());
        AnimalValidator.isAnimalValid(koala);
        AnimalValidator.isKoalaValid(koala);
        koala.setId(id);
        koalas.put(id, koala);
        return koalas.get(id);
    }

    @DeleteMapping("/{id}")
    public Koala delete(@PathVariable int id) {
        AnimalValidator.isIdValid(id);
        Koala koala = koalas.get(id);
        koalas.remove(id);
        return koala;

    }


}
