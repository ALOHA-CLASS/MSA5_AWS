package com.aloha.check.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Checks {
  private int id;
  private String name;
  private Date attendanceDate;
  private String status;
  private Date createdAt;
  private Date updatedAt;
}
