package com.thtech.elasticsearch.domain.Person;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface PersonRepository extends ElasticsearchRepository<Person, String>{

    List<Person> findByLifeHistoryLike(String subHistory);
}
