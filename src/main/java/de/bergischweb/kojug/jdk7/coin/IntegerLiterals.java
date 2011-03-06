/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.bergischweb.kojug.jdk7.coin;

import org.junit.Assert;

/**
 * @author Johannes Th&ouml;nes <johannes.thoenes@googlemail.com>
 */
public class IntegerLiterals {

  private long salary = 15_500_000_000L;
  private int bitmask = 0b1010_1011;
    
    
    public static void main(String... args){
        int dec = 153;
        int hex = 0x99;
        int oct = 0231;
        int bin = 0b10011001;
        
        Assert.assertEquals(dec, hex);
        Assert.assertEquals(hex, oct);
        Assert.assertEquals(oct, bin);
        Assert.assertEquals(bin, dec);
    }

}
