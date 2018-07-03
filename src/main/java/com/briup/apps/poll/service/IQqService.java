package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Qq;

public interface IQqService {
 List<Qq>findAll();
 void deleteById(long id);
 void save(Qq qq);
 void update(Qq qq);

}
