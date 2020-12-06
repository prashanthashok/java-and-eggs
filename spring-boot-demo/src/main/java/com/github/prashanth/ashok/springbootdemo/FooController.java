package com.github.prashanth.ashok.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/foos")
class FooController {

//    @Autowired
//    private IFooService service;
//
//    @GetMapping
//    public List<Foo> findAll() {
//        return service.findAll();
//    }
//
//    public Foo findById(@PathVariable("id") Long id){
//        return RestPreconditions.checkFound(service.findById(id));
//    }
}
