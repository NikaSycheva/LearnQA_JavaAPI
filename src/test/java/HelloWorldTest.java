import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class HelloWorldTest {
    @Test
    public void testHelloName() {
        Response response = RestAssured
                .get("https://playground.learnqa.ru/api/hello")
                .andReturn();
        response.prettyPrint();
    }

    @Test
    public void getText() {
        RestAssured
                .get("https://playground.learnqa.ru/api/get_text")
                .andReturn()
                .print();
    }
}
