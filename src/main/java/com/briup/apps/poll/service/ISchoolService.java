package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.School;

public interface ISchoolService {
	List<School> findAll();

	void deleteById(long id);

	void save(School school);

	void update(School school);
}
