package fr.jhoudu.demo.quarkus.service;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Readiness;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Gauge;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

@Readiness
@ApplicationScoped
public class DatabaseConnectionHealthCheck implements HealthCheck {

    @Autowired
    private CustomerRep rep;

    private int dataSize = 0;

    @Override
    public HealthCheckResponse call() {

        HealthCheckResponseBuilder responseBuilder = HealthCheckResponse.named("Database connection health check - it1 -");

        try {
            this.dataSize = databaseConnectionVerification();
            responseBuilder.up().withData("dataSize", dataSize);
        } catch (IllegalStateException e) {
            // cannot access the database
            responseBuilder.down();
        }

        return responseBuilder.build();
    }

    private int databaseConnectionVerification() {
        final int dataSize = ((Collection<?>)rep.findAll()).size();
        if (dataSize < 1)
            throw new IllegalStateException("Cannot contact database");
        return dataSize;
    }


    @Gauge(name="dataSize", unit = MetricUnits.NONE, description = "Taille de la BDD.")
    public int getDataSize () {
        return this.dataSize;
    }
}
