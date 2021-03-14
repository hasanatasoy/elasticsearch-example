package com.thtech.elasticsearch.service;

import com.thtech.elasticsearch.domain.Person.Person;
import com.thtech.elasticsearch.domain.Person.PersonRepository;
import org.apache.lucene.util.QueryBuilder;
import org.elasticsearch.index.query.MatchPhrasePrefixQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

@Service
public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public List<Person> findByHistory(String subHistory) {
        Pageable myPagable = PageRequest.of(1, 50).first();
        MatchQueryBuilder matchQueryry = QueryBuilders.matchQuery("lifeHistory", subHistory);
        NativeSearchQuery query = new NativeSearchQueryBuilder().withQuery(matchQueryry).withPageable(myPagable).build();
        return personRepository.search(query).toList();
    }

    public Person findByName(String name){
        return personRepository.findById(name).orElseThrow();
    }

    public Person save(Person person){
        return personRepository.save(person);
    }

    public void save(List<Person> personList){
        personRepository.saveAll(personList);
    }

    public long getCount(){
        return personRepository.count();
    }
}
