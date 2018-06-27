package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Questionnaire;

public interface IQuestionnaireService {
  List<Questionnaire>findAll()throws Exception;
  void deleteById(long id)throws Exception;
  void save(Questionnaire questionnaire)throws Exception;
  void update(Questionnaire questionnaire)throws Exception;
  
}
