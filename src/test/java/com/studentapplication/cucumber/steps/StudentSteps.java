package com.studentapplication.cucumber.steps;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.hamcrest.MatcherAssert;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import com.studentapplication.cucumber.serenity.StudentSerenitySteps;
import com.studentapplication.utils.TestUtils;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.matchers.statematchers.HasValueMatcher;
import net.thucydides.core.annotations.Steps;

public class StudentSteps  {
	
	
	@Steps
	StudentSerenitySteps steps;
	
	 static String email=null;

	@When("^User sends a get request to the list endpoint they must get back a valid status code 200$")
	public void verify_status_code_200_for_list_endpoint() {
		SerenityRest.rest().given()
		.when()
		.get("/list")
		.then()
		.statusCode(200);
	}
	
	@When("^I create a new student by providing the information firstName (.*) lastName (.*) email (.*) programme (.*) courses (.*)$")
	public void createStudent(String firstName, String lastName, String _email, String programme, String course) {
		
		List<String> courses = new ArrayList<>();
		courses.add(course);
		
		email= TestUtils.getRandomValue()+_email;

		steps.createStudent(firstName, lastName, email, programme, courses)
		.assertThat()
		.statusCode(201);
	}	
	
	@Then("^I verify that the student with (.*) is created$")
	public void verifyStudent(String emailId) {
		HashMap<String,Object> actualEmail = steps.getStudentInfoByEmailId(email);
		MatcherAssert.assertThat(actualEmail, hasValue(email));
		
	}
}
