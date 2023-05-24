package com.in28minutes.springboot.firstrestapi.survey;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;


@Service
public class SurveyService {
	
	private static List<Survey> surveys = new ArrayList<>();
	//public Survey survey = new Survey();
	
	static {
		
		Question question1 = new Question("Question1",
		        "Most Popular Cloud Platform Today", Arrays.asList(
		                "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
		Question question2 = new Question("Question2",
		        "Fastest Growing Cloud Platform", Arrays.asList(
		                "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Google Cloud");
		Question question3 = new Question("Question3",
		        "Most Popular DevOps Tool", Arrays.asList(
		                "Kubernetes", "Docker", "Terraform", "Azure DevOps"), "Kubernetes");

		List<Question> questions = new ArrayList<>(Arrays.asList(question1,
		        question2, question3));

		Survey survey = new Survey("Survey1", "My Favorite Survey",
		        "Description of the Survey", questions);

		surveys.add(survey);
	}

	public List<Survey> retrieveAllSurveys() {
		return surveys;
	}

	public Survey retriveSurveyById(String id) {
		Optional<Survey> findFirst = surveys.stream().filter(survey -> survey.getId().equals(id)).findFirst();
		if(findFirst.isEmpty())
			return null;
		return findFirst.get();
	}

	public List<Question> retriveSurveyQuestions(String surveyId) {
		Survey survey = retriveSurveyById(surveyId);
		
		if(survey == null)
			return null;
		return survey.getQuestions();
	}

	public Question retriveSurveyQuestionsById(String surveyId, String questionId) {
		Survey survey = retriveSurveyById(surveyId);
		Optional<Question> first = survey.getQuestions().stream().filter(question -> question.getId().equals(questionId)).findFirst();
		return first.get();
	}

	public void addNewSurveyQuestion(String surveyId, Question question) {
		List<Question> questions = retriveSurveyQuestions(surveyId);
		question.setId(generateRandomId());
		questions.add(question);
	}

	private String generateRandomId() {
		SecureRandom secureRandom = new SecureRandom();
		String string = new BigInteger(32, secureRandom).toString();
		return string;
	}

	public boolean deleteSurveyQuestion(String surveyId, String questionId) {
		List<Question> questions = retriveSurveyQuestions(surveyId);
		if(questions == null) {
			return false;
		}else {
			boolean filter = questions.removeIf(question -> question.getId().equalsIgnoreCase(questionId));
		}
		return true;
	}

	public void updateSurveyQuestion(String surveyId, String questionId, Question question) {
		List<Question> questions = retriveSurveyQuestions(surveyId);
		questions.removeIf(ques -> ques.getId().equalsIgnoreCase(questionId));
		questions.add(question);
	}
	
}
