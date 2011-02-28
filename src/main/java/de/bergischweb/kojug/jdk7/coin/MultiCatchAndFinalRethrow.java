/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bergischweb.kojug.jdk7.coin;

import java.io.FileNotFoundException;
import java.net.SocketTimeoutException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Johannes Th&ouml;nes <johannes.thoenes@googlemail.com>
 */
public class MultiCatchAndFinalRethrow {

  private static final Logger logger = Logger.getLogger(MultiCatchAndFinalRethrow.class.getName());

  public void readWithMulticatch(DataSource dataSource)
          throws SQLException, FileNotFoundException, SocketTimeoutException {
    try {
      Object o = dataSource.read();
    } catch (final SQLException|
    FileNotFoundException |
            SocketTimeoutException
    e){
      logger.log(Level.FINEST, "on reading data source", e);
      throw e;
    }
  }
}
