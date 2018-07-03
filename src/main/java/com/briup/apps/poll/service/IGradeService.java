package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Grade;

public interface IGradeService {

	void save(Grade grade);

	List<Grade> findAll();

	void deleteById(long id);

	void update(Grade grade);

}
