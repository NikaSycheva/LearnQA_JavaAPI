import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class Ex4Test {
    @Test
    public void getText() {
        RestAssured
                .get("https://playground.learnqa.ru/api/get_text")
                .andReturn()
                .print();
    }


}
