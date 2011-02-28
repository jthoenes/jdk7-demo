/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bergischweb.kojug.jdk7.coin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * @author Johannes Th&ouml;nes <johannes.thoenes@googlemail.com>
 */
public class TryWithResources {

  public void tryWithResources(Path source, Path target) {
    try
    (BufferedReader
    in = Files.newBufferedReader(source, Charset.defaultCharset());
    BufferedWriter out = Files.newBufferedWriter(target, Charset.defaultCharset(), StandardOpenOption.CREATE_NEW)){

      String line;
      while ((line = in.readLine()) != null) {
        out.append(line).append("\n");
      }

    }catch(IOException
    e){
      throw new RuntimeException(e);
    }
  }
}
