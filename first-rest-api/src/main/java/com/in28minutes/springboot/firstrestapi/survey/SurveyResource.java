package com.in28minutes.springboot.firstrestapi.survey;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class SurveyResource {
	
	@Autowired
	private SurveyService surveyService;
	
/*
 * public SurveyResource(SurveyService surveyService) { super();
 * this.surveyService = surveyService; }
 */

	// /surveys => surveys
	@RequestMapping("/surveys")
	public List<Survey> retrieveAllSurveys(){
		return surveyService.retrieveAllSurveys();
	}
	
	@RequestMapping("/surveys/{surveyId}")
	public Survey retrieveSurveyById(@PathVariable String surveyId){
		if(surveyService.retriveSurveyById(surveyId) != null)
			return surveyService.retriveSurveyById(surveyId);
		return (Survey) ResponseEntity.notFound();
	}
	
	//Get all survey questions
	@RequestMapping("/surveys/{surveyId}/questions")
	public List<Question> retrieveSurveyQuestions(@PathVariable String surveyId){
		return surveyService.retriveSurveyQuestions(surveyId);
	}
	
	//Get question by id
	@RequestMapping("/surveys/{surveyId}/questions/{questionId}")
	public Question retrieveSurveyQuestionsById(@PathVariable String surveyId, @PathVariable String questionId){
		 Question question = surveyService.retriveSurveyQuestionsById(surveyId, questionId);
		 if(question == null)
			 	throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		 return question;
	}
	
	//add question
	@RequestMapping(value="/surveys/{surveyId}/questions", method=RequestMethod.POST)
	public ResponseEntity<Object> addQuestions(@PathVariable String surveyId, @RequestBody Question question){
		surveyService.addNewSurveyQuestion(surveyId,question);
		return ResponseEntity.created(null).build();
	}
	
	//Delete Survey question
	@DeleteMapping("/surveys/{surveyId}/questions/{questionId}")
	public ResponseEntity<Object> deleteQuestion(@PathVariable String surveyId, @PathVariable String questionId) {
		surveyService.deleteSurveyQuestion(surveyId,questionId);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/surveys/{surveyId}/questions/{questionId}")
	public void updateSurveyQuestion(@PathVariable String surveyId, @PathVariable String questionId, @RequestBody Question question) {
		surveyService.updateSurveyQuestion(surveyId, questionId, question);
	}
}
