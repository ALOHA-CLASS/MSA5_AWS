package com.aloha.check.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aloha.check.dto.Checks;
import com.aloha.check.mapper.CheckMapper;

@Service
public class CheckServiceImpl implements CheckService {

  @Autowired
  private CheckMapper checkMapper;

  @Override
  public List<Checks> list() throws Exception {
    return checkMapper.list();
  }

  @Override
  public Checks select(int id) throws Exception {
    return checkMapper.select(id);
  }

  @Override
  public int insert(Checks check) throws Exception {
    return checkMapper.insert(check);
  }

  @Override
  public int update(Checks check) throws Exception {
    return checkMapper.update(check);
  }

  @Override
  public int delete(int id) throws Exception {
    return checkMapper.delete(id);
  }
  
}
