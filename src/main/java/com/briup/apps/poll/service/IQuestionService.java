package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.extend.QuestionVM;

public interface IQuestionService {
  List<Question>findAll() throws Exception;
  void deleteById(long id) throws Exception;
  void save(Question question) throws Exception;
  void update(Question question) throws Exception;
  List<QuestionVM> findAllQuestionVM() throws Exception;
  void saveOrUpdate (QuestionVM question)throws Exception;
  void saveOrUpdate (Questionnaire questionnaire,long[] ids)throws Exception;}
