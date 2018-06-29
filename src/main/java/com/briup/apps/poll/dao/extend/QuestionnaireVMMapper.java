package com.briup.apps.poll.dao.extend;

import java.util.List;

import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.extend.QuestionnaireVM;

public interface QuestionnaireVMMapper {
  QuestionnaireVM selectById(long id) throws Exception;
 List<QuestionnaireVM>findAll()throws Exception;
 Questionnaire deleteById(long d)throws Exception;
  
}
