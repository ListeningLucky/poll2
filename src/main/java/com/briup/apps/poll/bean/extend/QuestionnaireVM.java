package com.briup.apps.poll.bean.extend;

import java.util.List;

public class QuestionnaireVM {
private String name;
private String description;
private Long question;
private List<QuestionVM> questionVMs;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Long getQuestion() {
	return question;
}
public void setQuestion(Long question) {
	this.question = question;
}
public List<QuestionVM> getQuestionVMs() {
	return questionVMs;
}
public void setQuestionVMs(List<QuestionVM> questionVMs) {
	this.questionVMs = questionVMs;
}


}
