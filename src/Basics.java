import io.restassured.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import resources.Utils;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;
import java.io.IOException;
import files.Payload;


public class Basics {

	public static void main(String[] args) throws IOException {
		//Validate if Add place API is working as expected
		Response response;
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		String userNameData = Utils.getGlobalProperty("userName");
		String firstNameData = Utils.getGlobalProperty("firstName");
		String lastNameData = Utils.getGlobalProperty("lastName");
		String emailData = Utils.getGlobalProperty("email");
		String pwdData = Utils.getGlobalProperty("password");
		String phoneData = Utils.getGlobalProperty("phone");
		String newEmailData = Utils.getGlobalProperty("newEmail");
		String[] array1 = {"Kamal", "Kamal", "De Silva", "kamalDS@gmail.com", "kamal123", "+6804584243"};
		String[] array2 = {"Thamal", "Thamal", "Peris", "thamalP@gmail.com", "thamal123", "+5749999235"};
		String[] array3 = {"Sumal", "Sumal", "Dissanayaka", "sumalDiss@gmail.com", "sumal123", "+6799900923"};
		int idData = Integer.parseInt(Utils.getGlobalProperty("id"));
		int categoryIDData = Integer.parseInt(Utils.getGlobalProperty("categoryId"));
		String categoryNameData = Utils.getGlobalProperty("categoryName");
		String nameData = Utils.getGlobalProperty("name");
		int tagIDData = Integer.parseInt(Utils.getGlobalProperty("tagId"));
		String tagNameData = Utils.getGlobalProperty("tagName");
		String statusData = Utils.getGlobalProperty("status");
		
		//given-all input details
		//when-Submit the API
		//then -validate the response
		
		//Create User
		response = given().log().all().header("Content-Type","application/json").body(Payload.createUser(userNameData, firstNameData, lastNameData, emailData, pwdData, phoneData))
		.when().post("/user")
		.then().log().all().assertThat().statusCode(200).extract().response();	
		//header validate
		String header = response.getHeaders().getValue("Content-Type");
		assertEquals(header,"application/json");
		
		String idResponse =given().log().all().when().get("/user/"+userNameData+"").then().log().all().extract().response().asString();
		JsonPath js = new JsonPath(idResponse);		
		String userName = js.getString("username");
		assertEquals(userName, userNameData);
		String firstName = js.getString("firstName");
		assertEquals(firstName, firstNameData);
		String lastName = js.getString("lastName");
		assertEquals(lastName, lastNameData);
		String email = js.getString("email");
		assertEquals(email, emailData);
		String password = js.getString("password");
		assertEquals(password, pwdData);
		String phone = js.getString("phone");
		assertEquals(phone, phoneData);
		
		//Get User from user name
		//path parameter
		response = given().log().all().when().get("/user/"+userNameData+"").then().log().all().assertThat().statusCode(200).extract().response();	
		String headerGet = response.getHeaders().getValue("Content-Type");
		assertEquals(headerGet,"application/json");	
		given().log().all().when().get("/user/Acentura").then().log().all().assertThat().statusCode(404).extract().response();
		//When pass the invalid username but code id 404
		given().log().all().when().get("/user/NimaT").then().log().all().assertThat().statusCode(404).extract().response();
		
		//User LogIn
		//query parameter
		response = given().log().all().queryParam("username", userNameData).queryParam("password", pwdData)
		.when().get("/user/login").then().log().all().assertThat().statusCode(200).extract().response();
		String headerGetUser = response.getHeaders().getValue("Content-Type");
		assertEquals(headerGetUser,"application/json");
		/////////////////////////////////////////////////////////////
		//When pass the invalid username and password but code id 200
		given().log().all().queryParam("username", 2321).queryParam("password", "dnkfj")
		.when().get("/user/login").then().log().all().assertThat().statusCode(200).extract().response();
		
		//Create User Array
		given().log().all().header("Content-Type","application/json").body(Payload.createUserArray(array1, array2, array3)).when().post("/user/createWithArray").then().log().all().assertThat().statusCode(200);
		
		//Create User List
		given().log().all().header("Content-Type","application/json").body(Payload.createUserList(userNameData, firstNameData, lastNameData, emailData, pwdData, phoneData)).when().post("/user/createWithList").then().log().all().assertThat().statusCode(200);
	
		//Update User
		response = given().log().all().header("Content-Type","application/json").body(Payload.updateUser(userNameData, firstNameData, lastNameData, newEmailData, pwdData, phoneData))
		.when().put("/user/"+userNameData+"").then().assertThat().statusCode(200).log().all().extract().response();
		String headerUpdateUser = response.getHeaders().getValue("Content-Type");
		assertEquals(headerUpdateUser,"application/json");
		String updatedResponse =given().log().all().when().get("/user/"+userNameData+"").then().log().all().extract().response().asString();
		JsonPath js1 = new JsonPath(updatedResponse);	
		assertEquals(js1.get("email"),newEmailData);
		/////////////////////////////////////////////////////////////
		//When pass the invalid username and password but code id 200
		given().log().all().header("Content-Type","application/json").body(Payload.updateUser(userNameData, firstNameData, lastNameData, newEmailData, pwdData, phoneData))
		.when().put("/user/Samal@123").then().assertThat().statusCode(404).log().all();
		//When pass the invalid username and password but code id 200
		given().log().all().header("Content-Type","application/json").body(Payload.updateUser(userNameData, firstNameData, lastNameData, newEmailData, pwdData, phoneData))
		.when().put("/user/123").then().assertThat().statusCode(404).log().all();
		
		//Get user logOut
		response= given().log().all().when().get("/user/logout").then().log().all().assertThat().statusCode(200).extract().response();
		String headerLogoutUser = response.getHeaders().getValue("Content-Type");
		assertEquals(headerLogoutUser,"application/json");
		
		//Delete User
		response= given().log().all().when().delete("/user/"+userNameData+"").then().log().all().assertThat().statusCode(200).extract().response();
		String headerDeleteUser = response.getHeaders().getValue("Content-Type");
		assertEquals(headerDeleteUser,"application/json");
		given().log().all().when().delete("/user/Samal").then().log().all().assertThat().statusCode(404);
		//When pass the invalid username but code id 404
		given().log().all().when().delete("/user/1234").then().log().all().assertThat().statusCode(404);
		
		//Error 415 - unsupported media type
		//Add Pet
		response= given().log().all().body(Payload.addPet(categoryNameData, nameData, tagNameData, statusData)).when().post("/pet");
		String headerAddPet = response.getHeaders().getValue("Content-Type");
		assertEquals(headerAddPet,"application/xml");
		response.then().log().all().extract().asString();
		assertEquals(response.statusCode(), 200);
		
		String petResponse =given().log().all().when().get("/pet/"+idData+"").then().log().all().extract().response().asString();
		JsonPath js2 = new JsonPath(petResponse);		
		String petName = js2.getString("name");
		assertEquals(petName, nameData);
		
		response= given().log().all().body(Payload.addPet(categoryNameData, "sdshd", tagNameData, statusData)).when().post("/pet");
		assertEquals(response.statusCode(), 405);
		
		
		//Add pet with image
		
		
		//Update existing pet
		response = given().log().all().body(Payload.addPet(categoryNameData, nameData, tagNameData, statusData)).when().put("/pet/"+nameData+"").then().log().all().assertThat().statusCode(200).extract().response();
		String headerAdd_Pet = response.getHeaders().getValue("Content-Type");
		assertEquals(headerAdd_Pet,"application/json");
		response.then().log().all().extract().asString();
		assertEquals(response.statusCode(), 200);
		String updated_Pet_Response =given().log().all().when().get("/user/"+nameData+"").then().log().all().extract().response().asString();
		JsonPath js3 = new JsonPath(updated_Pet_Response);	
		assertEquals(js3.getString("nameData"),nameData);
		
		
		//Get pet by PetId
		
	}

}
