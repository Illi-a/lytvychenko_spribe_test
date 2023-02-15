package spribe;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.Matchers;
import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;


public class PlayerController{
    User user = new User();
    private final String SUPERVISOR_EDITOR = "supervisor";



    public int createValidUser() {
        LinkedHashMap validUser = user.createRandomValidUser();
        return given()
                .queryParams(validUser)
                .get("/player/create/" + SUPERVISOR_EDITOR)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("id");
    }

    public int createRandomUserWithCustomLogin(String login) {
        LinkedHashMap userWithCustomLogin = user.createRandomUserWithCustomLogin(login);
        return given()
                .queryParams(userWithCustomLogin)
                .get("/player/create/" + SUPERVISOR_EDITOR)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("id");
    }

    public int createRandomUserWithOutLogin() {
        LinkedHashMap userWithOutLogin = user.createRandomUserWithoutLogin();
        return given()
                .queryParams(userWithOutLogin)
                .get("/player/create/" + SUPERVISOR_EDITOR)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("id");
    }

    public int createRandomUserWithCustomScreenName(String screenName) {
        LinkedHashMap userWithCustomScreeName = user.createRandomUserWithCustomScreenName(screenName);
        return given()
                .queryParams(userWithCustomScreeName)
                .get("/player/create/" + SUPERVISOR_EDITOR)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("id");
    }

    public int createRandomUserWithOutScreenName() {
        LinkedHashMap userWithOutScreenName = user.createRandomUserWithOutScreenName();
        return given()
                .queryParams(userWithOutScreenName)
                .get("/player/create/" + SUPERVISOR_EDITOR)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("id");
    }

    public int createRandomUserWithOutRole() {
        LinkedHashMap userWithOutRole = user.createRandomUserWithOutRole();
        return given()
                .queryParams(userWithOutRole)
                .get("/player/create/" + SUPERVISOR_EDITOR)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("id");
    }

    public int createRandomUserWithEmptyRole() {
        LinkedHashMap userWithEmptyRole = user.createRandomUserWithEmptyRole();
        return given()
                .queryParams(userWithEmptyRole)
                .get("/player/create/" + SUPERVISOR_EDITOR)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("id");
    }

    public int createRandomUserWithCustomRole(String role) {
        LinkedHashMap userWithCustomRole = user.createRandomUserWithCustomRole(role);
        return given()
                .queryParams(userWithCustomRole)
                .get("/player/create/" + SUPERVISOR_EDITOR)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("id");
    }

    public int createRandomUserWithOutGender() {
        LinkedHashMap userWithOutGender = user.createRandomUserWithOutGender();
        return given()
                .queryParams(userWithOutGender)
                .get("/player/create/" + SUPERVISOR_EDITOR)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("id");
    }

    public int createRandomUserWithEmptyGender() {
        LinkedHashMap userWithEmptyGender = user.createRandomUserWithCustomGender("");
        return given()
                .queryParams(userWithEmptyGender)
                .get("/player/create/" + SUPERVISOR_EDITOR)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("id");
    }

    public int createRandomUserWithCustomGender(String gender) {
        LinkedHashMap userWithCustomGender = user.createRandomUserWithCustomGender(gender);
        return given()
                .queryParams(userWithCustomGender)
                .get("/player/create/" + SUPERVISOR_EDITOR)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("id");
    }

    public int createRandomUserWithCustomPasswordNumberOfChar(Integer numberOfChar) {
        LinkedHashMap userWithCustomPassword = user.createRandomUserWithCustomPasswordNumberOfChar(numberOfChar);
        return given()
                .queryParams(userWithCustomPassword)
                .get("/player/create/" + SUPERVISOR_EDITOR)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("id");
    }

    public int createRandomUserWithCustomPassword(String password) {
        LinkedHashMap userWithCustomPassword = user.createRandomUserWithCustomPassword(password);
        return given()
                .queryParams(userWithCustomPassword)
                .get("/player/create/" + SUPERVISOR_EDITOR)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("id");
    }

    public int createRandomUserWithOutPassword() {
        LinkedHashMap userWithOutPassword = user.createRandomUserWithOutPassword();
        return given()
                .queryParams(userWithOutPassword)
                .get("/player/create/" + SUPERVISOR_EDITOR)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("id");
    }

    public int createRandomUserWithCustomAge(String age) {
        LinkedHashMap userWithCustomAge = user.createRandomUserWithCustomAge(age);
        return given()
                .queryParams(userWithCustomAge)
                .get("/player/create/" + SUPERVISOR_EDITOR)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("id");
    }

    public int createRandomUserWithOutAge() {
        LinkedHashMap userWithOutAge = user.createRandomUserWithOutAge();
        return given()
                .queryParams(userWithOutAge)
                .get("/player/create/" + SUPERVISOR_EDITOR)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("id");
    }

    public int createRandomSupervisor() {
        LinkedHashMap supervisor = user.createRandomSupervisor();
        return given()
                .queryParams(supervisor)
                .get("/player/create/" + SUPERVISOR_EDITOR)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("id");
    }


    public int createRandomUserWithEmptyEditor() {
        LinkedHashMap userWithCustomEditor = user.createRandomValidUser();
        return given()
                .queryParams(userWithCustomEditor)
                .get("/player/create/")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("id");
    }

    public int createRandomUserWithCustomEditor(String editor) {
        LinkedHashMap userWithCustomEditor = user.createRandomValidUser();
        return given()
                .queryParams(userWithCustomEditor)
                .get("/player/create/" + editor)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("id");
    }


    public int createUserByUserWithValidData(String userLogin) {
        LinkedHashMap validUser = user.createRandomValidUser();
        return given()
                .queryParams(validUser)
                .get("/player/create/" + userLogin)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("id");
    }

    public int createValidUserByAdminWithValidData(String adminLogin) {
        LinkedHashMap validUser = user.createRandomValidUser();
        return given()
                .queryParams(validUser)
                .get("/player/create/" + adminLogin)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("id");
    }

    public int createRandomAdmin() {
        LinkedHashMap validRandomAdmin = user.createRandomValidAdmin();
        return given()
                .queryParams(validRandomAdmin)
                .get("/player/create/" + SUPERVISOR_EDITOR)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("id");
    }

    public int createRandomAdminWithCustomLogin(String login) {
        LinkedHashMap adminWithCustomLogin = user.createRandomAdminWithCustomLogin(login);
        return given()
                .queryParams(adminWithCustomLogin)
                .get("/player/create/" + SUPERVISOR_EDITOR)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("id");
    }


    public void deleteUser(int userID) {
        String json = "{\"playerId\": \"" + userID + "\"}";

        given()
                .header("Content-type", "application/json")
                .body(json)
                .when()
                .delete("/player/delete/" + SUPERVISOR_EDITOR)
                .then()
                .assertThat()
                .statusCode(204);
    }

    public void deleteUserUsingCustomEditor(String editor, int userID) {
        String json = "{\"playerId\": \"" + userID + "\"}";

        given()
                .header("Content-type", "application/json")
                .body(json)
                .when()
                .delete("/player/delete/" + editor)
                .then()
                .assertThat()
                .statusCode(204);
    }

    public void editUser(String editor, int id, String role) {
        String random8Alphabetic = RandomStringUtils.randomAlphabetic(8);
        String json = "{\"age\": \"25\", " +
                "\"gender\": \"male\", " +
                "\"login\": \"" + random8Alphabetic + "\", " +
                "\"password\": \"" + random8Alphabetic + "\", " +
                "\"role\": \"" + role + "\", " +
                "\"screenName\": \"" + random8Alphabetic + "\"}";

        given()
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .patch("/player/update/" + editor + "/" + id)
                .then()
                .assertThat()
                .body("login", Matchers.equalTo(random8Alphabetic))
                .statusCode(200);

    }

    public void editUserAge(String editor, int id, int age) {
        String json = "{\"age\": \"" + age + "\"}";
        given()
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .patch("/player/update/" + editor + "/" + id)
                .then()
                .assertThat()
                .body("age", Matchers.equalTo(age))
                .assertThat()
                .statusCode(200);
    }

    public void editUserSpecificField(String editor, int id, String field, String value) {
        String json = "{\""+ field +"\": \"" + value + "\"}";
        given()
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .patch("/player/update/" + editor + "/" + id)
                .then()
                .assertThat()
                .body(field, Matchers.equalTo(value))
                .assertThat()
                .statusCode(200);
    }



    public void assertThatUserExist(int userID) {
        String json = "{\"playerId\": \"" + userID + "\"}";

        given()
                .header("Content-type", "application/json")
                .body(json)
                .when()
                .post("/player/get")
                .then()
                .assertThat()
                .statusCode(200);
    }

    public JsonPath getPlayerById(int userID) {
        String json = "{\"playerId\": \"" + userID + "\"}";

        Response response = given()
                .header("Content-type", "application/json")
                .body(json)
                .when()
                .post("/player/get");
        return new JsonPath(response.asString());
    }

    public void getPlayerByIdStatusCode(int userID) {
        String json = "{\"playerId\": \"" + userID + "\"}";
        given()
                .header("Content-type", "application/json")
                .body(json)
                .when()
                .post("/player/get")
                .then()
                .assertThat()
                .statusCode(200);
    }

    public int createCustomUser() {
        LinkedHashMap customUser = user.createCustomUser();
        return given()
                .queryParams(customUser)
                .get("/player/create/" + SUPERVISOR_EDITOR)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("id");
    }
}