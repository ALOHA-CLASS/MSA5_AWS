package com.aloha.check.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aloha.check.dto.Checks;
import com.aloha.check.service.CheckService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "*")   // 모든 출처에서의 요청을 허용
@RequestMapping("/checks")
public class CheckController {

  @Autowired
  private CheckService checkService;
  
  @GetMapping()
  public ResponseEntity<?> getAll() {
      try {
          List<Checks> checkList = checkService.list();
          return new ResponseEntity<>(checkList, HttpStatus.OK);
      } catch (Exception e) {
          return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<?> getOne(@PathVariable("id") Integer id) {
      try {
          Checks check = checkService.select(id);
          return new ResponseEntity<>(check, HttpStatus.OK);
      } catch (Exception e) {
          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }
  
  @PostMapping()
  public ResponseEntity<?> create(@RequestBody Checks check) {
      try {
          int result = checkService.insert(check);
          if( result > 0 ) 
            return new ResponseEntity<>("Create Result", HttpStatus.CREATED);
          else 
            return new ResponseEntity<>("No Result", HttpStatus.OK);
      } catch (Exception e) {
          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }
  
  @PutMapping()
  public ResponseEntity<?> update(@RequestBody Checks check) {
      try {
        int result = checkService.update(check);
        if( result > 0 ) 
          return new ResponseEntity<>("Update Result", HttpStatus.OK);
        else 
          return new ResponseEntity<>("No Result", HttpStatus.OK);
      } catch (Exception e) {
          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<?> destroy(@PathVariable("id") Integer id) {
      try {
          int result = checkService.delete(id);
          if( result > 0 ) 
            return new ResponseEntity<>("Destroy Result", HttpStatus.OK);
          else 
            return new ResponseEntity<>("No Result", HttpStatus.OK);
      } catch (Exception e) {
          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }
  
}
