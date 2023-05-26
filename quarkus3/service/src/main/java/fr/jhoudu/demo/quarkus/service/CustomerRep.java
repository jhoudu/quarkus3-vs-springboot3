package fr.jhoudu.demo.quarkus.service;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRep extends CrudRepository<Customer, Integer> {
    List<Customer> findByName(String name);
}
