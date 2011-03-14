package de.bergischweb.kojug.jdk7.coin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.hsqldb.Server;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Johannes Th&ouml;nes <johannes.thoenes@googlemail.com>
 */
public class TryWithResources {

  private final Logger logger = LoggerFactory.getLogger(TryWithResources.class);
  private static final String CONNECTION_STRING = "jdbc:hsqldb:hsql://127.0.0.1/jdk7";

  public static void main(String... args) throws SQLException, IOException {
    Server hsqlServer = new Server();
    hsqlServer.setDatabaseName(0, "jdk7");
    hsqlServer.setDatabasePath(0, File.createTempFile("jdk7", "dat").getAbsolutePath());
    hsqlServer.start();

    try (Connection c = DriverManager.getConnection(CONNECTION_STRING, "sa", "");
            Statement statement = c.createStatement()) {

      statement.executeUpdate("DROP TABLE medications IF EXISTS;");
      statement.executeUpdate("CREATE TABLE medications (patient varchar(255), medication_day date, medication_desc varchar(255));");

      try (PreparedStatement pStatement = c.prepareStatement("INSERT INTO medications(patient, medication_day,medication_desc) VALUES(?,?,?)")) {

        pStatement.setString(1, "Frank");
        pStatement.setDate(2, new Date(System.currentTimeMillis()));
        pStatement.setString(3, "Aspirin");
        pStatement.executeUpdate();

        pStatement.setString(1, "Marc");
        pStatement.setDate(2, new Date(System.currentTimeMillis()));
        pStatement.setString(3, "Salbutanol");
        pStatement.executeUpdate();
      }

      TryWithResources twr = new TryWithResources();
      twr.readDataUnsave();
      twr.readDataSave();
      twr.readDataTryWithResources(Paths.get("/tmp/output.csv"));

    } finally {
      hsqlServer.stop();
    }
  }

  public void readDataUnsave() {
    Connection conn = null;
    Statement statement = null;
    ResultSet resultSet = null;
    try {
      conn = DriverManager.getConnection(CONNECTION_STRING);
      statement = conn.createStatement();
      resultSet = statement.executeQuery("SELECT patient, medication_day, medication_desc FROM medications");

      while (resultSet.next()) {
        String patient = resultSet.getString("patient");
        LocalDate medication_day = LocalDate.fromDateFields(resultSet.getDate("medication_day"));
        String medication_desc = resultSet.getString("medication_desc");

        System.out.println(String.format("'%s','%s','%s'", patient, medication_day, medication_desc));
      }


    } catch (SQLException ex) {
      logger.error("Error in Database", ex);
    } finally {
      try {
        resultSet.close();
        statement.close();
        conn.close();
      } catch (SQLException ex) {
        logger.error("Error in Database", ex);
      }
    }
  }

  public void readDataSave() {
    Connection conn = null;
    Statement statement = null;
    ResultSet resultSet = null;
    try {
      conn = DriverManager.getConnection(CONNECTION_STRING);
      statement = conn.createStatement();
      resultSet = statement.executeQuery("SELECT patient, medication_day, medication_desc FROM medications");

      while (resultSet.next()) {
        String patient = resultSet.getString("patient");
        LocalDate medication_day = LocalDate.fromDateFields(resultSet.getDate("medication_day"));
        String medication_desc = resultSet.getString("medication_desc");

        System.out.println(String.format("'%s','%s','%s'", patient, medication_day, medication_desc));
      }

    } catch (SQLException ex) {
      logger.error("Error in Database", ex);
    } finally {
      try {
        if (resultSet != null) {
          resultSet.close();
        }

      } catch (SQLException ex) {
        logger.error("Error in Database", ex);
      } finally {
        try {
          if (statement != null) {
            statement.close();
          }

        } catch (SQLException ex) {
          logger.error("Error in Database", ex);
        } finally {
          try {
            if (conn != null) {
              conn.close();
            }
          } catch (SQLException ex) {
            logger.error("Error in Database", ex);
          }
        }
      }
    }
  }

  public void readDataTryWithResources(Path target) {
    try (Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT patient, medication_day, medication_desc FROM medications");
            BufferedWriter output = Files.newBufferedWriter(target, Charset.forName("utf-8"))) {

      while (resultSet.next()) {
        String patient = resultSet.getString("patient");
        LocalDate medication_day = LocalDate.fromDateFields(resultSet.getDate("medication_day"));
        String medication_desc = resultSet.getString("medication_desc");

        output.write(String.format("'%s','%s','%s'\n", patient, medication_day, medication_desc));

      }

    } catch (SQLException ex) {
      logger.error("Error in Database", ex);
    } catch (IOException ex) {
      logger.error("Error in File Writing", ex);
    }
  }
}
