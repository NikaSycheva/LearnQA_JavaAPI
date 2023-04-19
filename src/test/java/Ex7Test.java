import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class Ex7Test {
    @Test
    public void GetAllRedirectsTest(){
        int statusCode = 0;
        String url = "https://playground.learnqa.ru/api/long_redirect";
        String locationHeader = "";
        int redirectCount = 0;

        while(statusCode!= 200){
            Response response = RestAssured
                    .given()
                    .redirects()
                    .follow(false)
                    .when()
                    .get(url);
            statusCode = response.getStatusCode();
            locationHeader = response.getHeader("Location");
            url = locationHeader;
            redirectCount ++;
        }
        System.out.println(redirectCount);
    }
}
