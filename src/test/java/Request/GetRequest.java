package Request;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GetRequest {

	@Test
	public void GetRequest() {
		
		RestAssured.baseURI="https://gist.github.com/kumarpani/1e759f27ae302be92ad51ec09955e765";
		
		String R = given().log().all().header("contentType","application/Json").
		when().get("https://gist.github.com/kumarpani/1e759f27ae302be92ad51ec09955e765.js").then().log().all().assertThat().statusCode(200).body("name",equalTo("Royal Challengers Bangalore"))
		.extract().response().asString();
		
		System.out.println(R);
		
		JsonPath j = new JsonPath(R);
		String T = j.getString("location");
		
}
}
