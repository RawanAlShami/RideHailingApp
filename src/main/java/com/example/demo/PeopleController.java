package com.example.demo;

import java.util.List;

import com.example.demo.application.IUserService;
import com.example.demo.application.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeopleController {
    private IUserService peopleService;
    /*
    public PeopleController() {
        peopleService = new UserService();
    }

    @GetMapping("/people")
    public List<Person> getAll() {
        return peopleService.getAll();
    }
    */

    /*@GetMapping("/people/{name}")
    public Person get(@PathVariable String name) {
        return peopleService.get(name);
    }

    @PostMapping("/people")
    public boolean add(@RequestBody Person p) {
        return peopleService.add(p);
    }

    @PutMapping("/people")
    public boolean update(@RequestBody Person p) {
        return peopleService.update(p);
    }

    @DeleteMapping("/people/{name}/delete")
    public boolean update(@PathVariable String name) {
        return peopleService.delete(name);
    }
    */
}