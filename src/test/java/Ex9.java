import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Ex9 {
    @Test
    public void GetSecretPassword(){
        Map<String, String> loginPassword = new HashMap<String, String>();
        loginPassword.put("login", "login");
        loginPassword.put("password", "password");
        JsonPath response = RestAssured
                .given()
                .queryParams(loginPassword)
                .post("https://playground.learnqa.ru/ajax/api/get_secret_password_homework")
                .jsonPath();
    }
}
