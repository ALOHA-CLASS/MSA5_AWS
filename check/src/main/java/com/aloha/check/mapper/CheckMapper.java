package com.aloha.check.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.aloha.check.dto.Checks;

@Mapper
public interface CheckMapper {

  public List<Checks> list() throws Exception;

  public Checks select(int id) throws Exception;

  public int insert(Checks check) throws Exception;

  public int update(Checks check) throws Exception;

  public int delete(int id) throws Exception;
  
}
