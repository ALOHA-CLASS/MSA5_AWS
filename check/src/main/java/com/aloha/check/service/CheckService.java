package com.aloha.check.service;

import java.util.List;

import com.aloha.check.dto.Checks;

public interface CheckService {

  public List<Checks> list() throws Exception;

  public Checks select(int id) throws Exception;

  public int insert(Checks check) throws Exception;

  public int update(Checks check) throws Exception;

  public int delete(int id) throws Exception;
  
}
