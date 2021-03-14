package com.thtech.elasticsearch.controller;

import com.thtech.elasticsearch.domain.Person.Person;
import com.thtech.elasticsearch.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "person")
public class PersonController {

    private final PersonService personService;

    public  PersonController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping(value = "/history/{subHistory}")
    public List<Person> GetPersonByHistory(@PathVariable String subHistory){
        return personService.findByHistory(subHistory);
    }

    @GetMapping(value = "/{id}")
    public Person GetPersonByName(@PathVariable String id){
        return  personService.findByName(id);
    }

    @PostMapping(value = "")
    public String SavePerson(@RequestBody List<Person> personList){
        personList.forEach(person -> person.setName(UUID.randomUUID().toString()));
        personService.save(personList);
        return "Bitti";
    }

    @GetMapping(value = "/all")
    public long SavePerson(){
        return personService.getCount();
    }
}
