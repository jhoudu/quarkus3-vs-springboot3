package fr.jhoudu.demo.quarkus.service;

import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Gauge;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRep rep;

    CustomerService(CustomerRep rep) {
        this.rep = rep;
    }

    public Collection<Customer> byName(String name) {
        return this.rep.findByName(name);
    }

    public Collection<Customer> all() {
        List<Customer> allCusto = new ArrayList<Customer>();
        Iterable<Customer> it = this.rep.findAll();
        it.forEach(allCusto::add);
        return allCusto;
    }
}