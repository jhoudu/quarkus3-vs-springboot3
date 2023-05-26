package fr.jhoudu.demo.quarkus;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class CustomerRestControllerTest {
    @Test
    public void testCustomersEndpoint() {
        given()
                .when().get("/customers")
                .then()
                .statusCode(200)
                .body("$.size()", is(3),
                        "[0].name", is("Edrick"),
                        "[0].id", is(1),
                        "[1].name", is("Josh"),
                        "[1].id", is(2),
                        "[2].name", is("Zack"),
                        "[2].id", is(3));
    }
}
