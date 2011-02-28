/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bergischweb.kojug.jdk7.coin;

import java.io.FileNotFoundException;
import java.net.SocketTimeoutException;
import java.sql.SQLException;

/**
 * @author Johannes Th&ouml;nes <johannes.thoenes@googlemail.com>
 */
public abstract class DataSource {

  public abstract Object read() throws SQLException, FileNotFoundException, SocketTimeoutException;

  protected abstract Object readFromFile() throws FileNotFoundException;

  protected abstract Object readFromDatabase() throws SQLException;

  protected abstract Object readFromNetwork() throws SocketTimeoutException;
}
