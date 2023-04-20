import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;
import java.lang.Thread;

public class Ex8Test {
    @Test
    public void LongtimeJobTest() throws InterruptedException {
        String url = "https://playground.learnqa.ru/ajax/api/longtime_job";

        JsonPath response = RestAssured
                .get(url)
                .jsonPath();
        String token = response.get("token");
        int waitTime = response.get("seconds");

        JsonPath response2 = RestAssured
                .given()
                .queryParam("token", token)
                .when()
                .get(url)
                .jsonPath();
        response2.prettyPrint();

        if(response2.get("status").equals("Job is NOT ready")){
            System.out.println("При исполнении запроса до выполнения задачи статус верный");
        }
        else{
            System.out.println("При исполнении запроса до выполнения задачи статус неверный");
        }

        Thread.sleep(waitTime* 1000L);

        JsonPath response3 = RestAssured
                .given()
                .queryParam("token", token)
                .get(url)
                .jsonPath();
        response3.prettyPrint();

        if(response3.get("result") != null){
            System.out.println("При исполнении запроса после выполнения задачи поле result присутствует");
        };

        if(response3.get("status").equals("Job is ready")){
            System.out.println("При исполнении запроса после выполнения задачи статус верный");
        }
        else{
            System.out.println("При исполнении запроса после выполнения задачи статус неверный");
        }
    }
}
