package com.github.prashanth.ashok.springbootdemo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GenericEntityController {
    private List<GenericEntity> entityList = new ArrayList<>();

    private String name = "fizzburn";
    private List<String> names = new ArrayList<>();

    @GetMapping("/entity/all")
    public List<GenericEntity> findAll(){
        return entityList;
    }

    @PostMapping(value = "/entity", consumes = "application/json", produces = "application/json")
    public GenericEntity addEntity(@RequestBody GenericEntity entity){
        entityList.add(entity);
        return entity;
    }

    @GetMapping("entity/findby/{id}")
    public GenericEntity findById(@PathVariable Long id){
        return entityList.stream()
                .filter(entity -> entity.getId().equals(id))
                .findFirst().get();
    }

     @GetMapping(value = "/getname")
    public String getName(){
        return name;
    }

    @GetMapping(value = "/getnames")
    public List<String> getNames(){
        return names;
    }

    @PostMapping(value = "/addname")
    @ResponseStatus(HttpStatus.CREATED)
    public List<String> addName(@RequestBody String name) {
        names.add(name);
        return names;
    }

}
