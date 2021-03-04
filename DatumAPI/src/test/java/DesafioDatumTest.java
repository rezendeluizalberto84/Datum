import static  io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.*;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;

public class DesafioDatumTest {

    @Test
    public void validarPost() {

        String corpoRequiscao = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

        String respostaEsperada = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\",\n" +
                "    \"id\": \"208\",\n" +
                "    \"createdAt\": \"2021-03-03T21:56:40.410Z\"\n" +
                "}";

        given()
                .contentType(JSON)
                .body(corpoRequiscao)
        .when()
                .post("https://reqres.in/api/users")
        .then()
                .statusCode(201)
                .body(new IsEqual(respostaEsperada))
        ;
    }

    @Test
    public void validarGetSingleUser() {

        String respostaesperada = "{\n" +
                "    \"data\": {\n" +
                "        \"id\": 2,\n" +
                "        \"email\": \"janet.weaver@reqres.in\",\n" +
                "        \"first_name\": \"Janet\",\n" +
                "        \"last_name\": \"Weaver\",\n" +
                "        \"avatar\": \"https://reqres.in/img/faces/2-image.jpg\"\n" +
                "    },\n" +
                "    \"support\": {\n" +
                "        \"url\": \"https://reqres.in/#support-heading\",\n" +
                "        \"text\": \"To keep ReqRes free, contributions towards server costs are appreciated!\"\n" +
                "    }\n" +
                "}";

        given()
                .contentType(JSON)
        .when()
                .get("https://reqres.in/api/users/2")
        .then()
                .statusCode(200)
                .assertThat()
                .body(new IsEqual(respostaesperada))
        ;
    }

    @Test
    public void validarPatch() {

        String corpoRequisicao = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}":

        String corpoAtualizadoRequisicao = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\",\n" +
                "    \"updatedAt\": \"2021-03-03T22:27:45.466Z\"\n" +
                "}";

        String respostaesperada = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\",\n" +
                "    \"updatedAt\": \"2021-03-03T22:27:45.466Z\"\n" +
                "}";

        given()
                .contentType(JSON)
                .body(corpoRequisicao)
        .when()
                .post("https://reqres.in/api/users/2");
        .given()
                .contentType(JSON)
                .body(corpoAtualizadoRequisicao)
        .when()
                .patch("https://reqres.in/api/users/2")
        .then()
                .statusCode(200)
                .assertThat()
                .body(new IsEqual(respostaesperada))
        ;
    }

    @Test
    public void validarGetListUsers() {
        given()
                .contentType(JSON)
                .body("{}")
        .when()
                .get("https://reqres.in/api/users?page=2")
        .then()
                .statusCode(200)
                .body("$", hasSize(6))
                .body("first_name", hasItems("Michael", "Lindsay", "Tobias", "Byron", "George", "Rachel"))
        ;
    }
}
