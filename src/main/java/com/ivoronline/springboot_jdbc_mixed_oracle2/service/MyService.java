package com.ivoronline.springboot_jdbc_mixed_oracle2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class MyService {

  //PROPERTIES
  @Autowired private DataSource dataSource;

  //=========================================================================================================
  // MIXED STATEMENTS
  //=========================================================================================================
  public int mixedStatements(String name1, Integer age1) throws SQLException {

    //GET DB CONNECTION
    Connection connection = dataSource.getConnection();

    //DEFINE STATEMENTS
    String    sql1      = " BEGIN                                                           " +
                          "   INSERT INTO PERSON (NAME, AGE) VALUES ('Alice', 20);          " +
                          "   UPDATE      PERSON SET NAME = 'John New' WHERE name = 'John'; " +
                          " END;                                                            ";

    String    sql2      = " INSERT ALL                                                      " +
                          "   INTO person (name, age) VALUES ('Susan', 20)                  " +
                          "   INTO person (name, age) VALUES ('Alice', 21)                  " +
                          " SELECT 1 FROM DUAL                                              ";

    String    sql3      = "INSERT INTO person (name, age)                                   " +
                          "  SELECT 'Susan', 20 FROM DUAL UNION ALL                         " +
                          "  SELECT 'Alice', 21 FROM DUAL                                   ";

    String    sql4      ="INSERT INTO PERSON (NAME, AGE) VALUES ('Alice', 21), ('Susan', 20)"; //From Oracle 23

    //EXECUTE STATEMENTS
    Statement statement = connection.createStatement();
    int       success   = statement.executeUpdate(sql1);

    //RETURN SUCCESS
    return success;

  }

}
