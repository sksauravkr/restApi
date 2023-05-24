package com.in28minutes.springboot.firstrestapi.survey;

import static org.assertj.core.api.Assertions.fail;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {
	
	@Test
	void test() throws JSONException {
		String expectedRespone = """
				{"id":"Question1","description":"Most Popular Cloud Platform Today","options":["AWS","Azure","Google Cloud","Oracle Cloud"],"correctAnswer":"AWS"}
				""";
		
		String actualRespone = """
				{"id":"Question1","description":"Most Popular Cloud Platform Today","options":["AWS","Azure","Google Cloud","Oracle Cloud"],"correctAnswer":"AWS"}
				""";
		JSONAssert.assertEquals(expectedRespone, actualRespone, true);
	}
}
