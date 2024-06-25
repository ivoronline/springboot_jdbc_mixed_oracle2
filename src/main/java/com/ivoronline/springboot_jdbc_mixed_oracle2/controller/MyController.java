package com.ivoronline.springboot_jdbc_mixed_oracle2.controller;

import com.ivoronline.springboot_jdbc_mixed_oracle2.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.sql.SQLException;

@RestController
public class MyController {

  //PROPERTIES
  @Autowired private MyService myService;

  //=========================================================================================================
  // MIXED STATEMENTS
  //=========================================================================================================
  @ResponseBody
  @GetMapping("/mixedStatements")
  public int mixedStatements() throws SQLException {
    int    success = myService.mixedStatements("Jill", 40);
    return success;
  }

}
