import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BaseTest {
    @BeforeTest
    public void setup() {
        RestAssured.baseURI = "https://simple-grocery-store-api.glitch.me";
    }

    @Test
    public void getApiStatusTest() {
        RestAssured.get("/status")
                .then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void getAllProductsTest() {
        RestAssured.get("/products")
                .then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void getProductByIdTest() {
        RestAssured.get("/products/4646")
                .then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void createANewCartTest() {
        RestAssured.post("/carts")
                .then()
                .statusCode(201)
                .log()
                .all();
    }

    @Test
    public void getACartById() {
        RestAssured.get("/carts/_kXCil83Ffi79kNd7N5UV")
                .then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void addAnItemToCartTest() {
        RestAssured.post("/carts/p-zdog2dYiI22yAkE7Ioi/items")
                .then()
                .statusCode(400)
                .log()
                .all();
    }

    @Test
    public void modifyAnItemInTheCartTest() {
        given().body("{\n" +
                "   \"quantity\": \"1\"\n" +
                "}")
                .when()
                .patch("/carts/KMhngrk8eGA-GAEgHsQMp/items/243962127")
                .then()
                .statusCode(204);
    }

    @Test
    public void replaceAnItemInTheCartTest() {
        RestAssured.put("/carts/p-zdog2dYiI22yAkE7Ioi/items/978821446")
                .then()
                .statusCode(400)
                .log()
                .all();
    }

    @Test
    public void deleteAnItemInTheCartTest() {
        RestAssured.delete("/carts/p-zdog2dYiI22yAkE7Ioi/items/978821446")
                .then()
                .statusCode(404)
                .log()
                .all();
    }

    @Test
    public void registerANewApiClientTest() {
        RestAssured.post("/api-clients")
                .then()
                .statusCode(400)
                .log()
                .all();
    }

    @Test
    public void getAllOrdersTest() {
        RestAssured.get("/orders")
                .then()
                .statusCode(401)
                .log()
                .all();
    }
}

