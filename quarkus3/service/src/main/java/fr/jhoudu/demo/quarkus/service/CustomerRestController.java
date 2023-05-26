package fr.jhoudu.demo.quarkus.service;

import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.tietoevry.quarkus.resteasy.problem.HttpProblem;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "/customers")
public class CustomerRestController {

    private final CustomerService service;
    //private ObservationRegistry registry = null;

    CustomerRestController(CustomerService service) {
        this.service = service;
        /*
        this.registry = ObservationRegistry.create();

        registry
                .observationConfig()
                .observationHandler(new ObservationTextPublisher(System.out::println));*/
    }

    @GetMapping
    @Counted(name = "allCalls", description = "How many calls of all() have been performed.")
    @Timed(name = "allTimer", description = "A measure of how long all() takes.", unit = MetricUnits.MILLISECONDS)
    public Collection<Customer> all() {
        /*
        return Observation
                .createNotStarted("all", this.registry)
                .observe(this.service::all);*/
        return this.service.all();
    }

    @GetMapping("/{name}")
    @Counted(name = "byNameCalls", description = "How many calls of byName() have been performed.")
    @Timed(name = "byNameTimer", description = "A measure of how long byName() takes.", unit = MetricUnits.MILLISECONDS)
    public Collection<Customer> byName(@PathVariable String name) {
        if (name == null || !Character.isUpperCase(name.charAt(0)))
            throw new CustomerProblem("the name must be valid");
            //throw new IllegalArgumentException("the name must be valid");
        /*
        return Observation
                .createNotStarted("byName", this.registry)
                .observe(() -> this.service.byName(name));*/

        return this.service.byName(name);
    }

    static class CustomerProblem extends HttpProblem {
        CustomerProblem(String message) {
            super(builder()
                    .withTitle("Bad request")
                    .withStatus(Response.Status.BAD_REQUEST)
                    .withDetail(message)
                    .withHeader("X-RFC7807-Message", message)
            );
        }
    }

}
