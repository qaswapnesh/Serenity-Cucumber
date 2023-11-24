package com.studentapplication.cucumber;

import org.junit.runner.RunWith;

import com.studentapplication.testbase.TestBase;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/feature/student.feature"})
public class StudentRunnerTest extends TestBase{
	
	TestBase t = new TestBase();

	
}
