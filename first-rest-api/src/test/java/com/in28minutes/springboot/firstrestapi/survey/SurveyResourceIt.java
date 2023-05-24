package com.in28minutes.springboot.firstrestapi.survey;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SurveyResourceIt {
	
	private static String questionUrl = "/surveys/Survey1/questions/Question1";
	
	@Autowired
	TestRestTemplate template;
	
	String str = """
			{
			    "id": "Question1",
			    "description": "Most Popular Cloud Platform Today",
			    "options": [
			        "AWS",
			        "Azure",
			        "Google Cloud",
			        "Oracle Cloud"
			    ],
			    "correctAnswer": "AWS"
			}
			
			""";
	
	
	@Test
	void retrieveSurveyQuestionsById_basicScenario() throws JSONException{
		ResponseEntity<String> entity = template.getForEntity(questionUrl, String.class);
		String expectedRespone = """
				{"id":"Question1","description":"Most Popular Cloud Platform Today","options":["AWS","Azure","Google Cloud","Oracle Cloud"],"correctAnswer":"AWS"}
				""";
		//entity.getHeaders().get("Content-Tyipe".get(0));
		equals(entity.getStatusCode().is2xxSuccessful());
		JSONAssert.assertEquals(expectedRespone,entity.getBody(),false);
	}
}
