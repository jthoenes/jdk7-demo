package de.bergischweb.kojug.jdk7.coin;

import static  org.junit.Assert.*;

/**
 * @author Johannes Th&ouml;nes <johannes.thoenes@googlemail.com>
 */
public class IntegerLiterals {

  private long gigabyte = 1_073_741_824L;
  private int bitmask = 0b1010_1011;
    
    
    public static void main(String... args){
        int binOld = Integer.parseInt("10011001", 2);        
        
        int dec = 153;
        int hex = 0x99;
        int oct = 0231;
        int bin = 0b10011001;
        
        assertEquals(dec, hex);
        assertEquals(hex, oct);
        assertEquals(oct, bin);
        assertEquals(bin, dec);
        
        assertEquals(bin, binOld);
    }

}
