/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.bergischweb.kojug.jdk7.coin;

/**
 * @author Johannes Th&ouml;nes <johannes.thoenes@googlemail.com>
 */
public abstract class SwitchInStrings {

  public int[] randomize(String algorithm) {
    switch (algorithm) {
      case "complete":
        return completeRandomization();
    }
    return null;
  }

  protected abstract int[] completeRandomization();

}
