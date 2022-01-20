

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

//https://6143a99bc5b553001717d06a.mockapi.io/testapi/v1//Users

public class TestApi {

	  @BeforeClass
	    public static void setup() {
	        RestAssured.baseURI = "https://6143a99bc5b553001717d06a.mockapi.io";
	    }

	    @Test
	    public void getRequest() {
	        Response response = given()
	                .contentType(ContentType.JSON)
	                .when()
	                .get("/testapi/v1/Users")
	                .then()
	                .extract().response();

	        assertEquals(200, response.statusCode());
	        assertEquals("employee_firstname 17", response.jsonPath().getString("employee_firstname[1]"));
	    }
	    
	    private static String requestBody = "{\n"+
	    	    " \"createdAt\": 163182583,\n"+
	    	    " \"employee_firstname\": \"TestData12345\",\n"+
	    	    " \"employee_lastname\": \"TestData12345\",\n"+
	    	    " \"employee_phonenumber\": \"264-783-9453\",\n"+
	    	    " \"ademployee_emaildress\": \"ademployee_emaildress 1\",\n"+
	    	    " \"citemployee_address\": \"citemployee_address 1\",\n"+
	    	    " \"stateemployee_dev_level\": \"stateemployee_dev_level 1\",\n"+
	    	    " \"employee_gender\": \"employee_gender 1\",\n"+
	    	    " \"employee_hire_date\": \"2025-10-31T16:35:45.426Z\",\n"+
	    	    " \"employee_onleave\": true,\n"+
	    	    " \"tech_stack\": [],\n"+
	    	    " \"project\": []}";
	    @Test
	    public void postRequest() {
	        Response response = given()
	                .header("Content-type", "application/json")
	                .and()
	                .body(requestBody)
	                .when()
	                .post("/testapi/v1/Users")
	                .then()
	                .extract().response();

	        assertEquals(201, response.statusCode());
//	        System.out.println(response.asString());
	         assertEquals("1631825833", response.jsonPath().getString("createdAt"));
	        assertEquals("TestData12345", response.jsonPath().getString("employee_firstname"));
	        assertEquals("TestData12345", response.jsonPath().getString("employee_lastname"));
	        assertEquals("264-783-9453", response.jsonPath().getString("employee_phonenumber"));
	        assertEquals("ademployee_emaildress 1", response.jsonPath().getString("ademployee_emaildress"));
	        assertEquals("citemployee_address 1", response.jsonPath().getString("citemployee_address"));
	        assertEquals("stateemployee_dev_level 1", response.jsonPath().getString("stateemployee_dev_level"));
	        assertEquals("employee_gender 1", response.jsonPath().getString("employee_gender"));
	    }
}


