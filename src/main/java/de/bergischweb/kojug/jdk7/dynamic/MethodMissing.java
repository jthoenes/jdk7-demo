/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.bergischweb.kojug.jdk7.dynamic;

import java.dyn.CallSite;
import java.dyn.ConstantCallSite;
import java.dyn.MethodHandle;
import java.dyn.MethodHandles;
import java.dyn.MethodType;
import java.dyn.NoAccessException;

/**
 *
 * @author Johannes Th&ouml;nes <johannes.thoenes@googlemail.com>
 */
public class MethodMissing {
  
    static MethodHandles.Lookup lookup;
    static Class thisClass;
    static MethodType type;
    static MethodHandle method_missing;
    
    static {
        
        try {
         lookup = MethodHandles.lookup();
         thisClass = lookup.lookupClass();
         type = MethodType.methodType(void.class, String.class, Object[].class);
         method_missing = lookup.findStatic(thisClass, "method_missing", type);
        } catch(NoAccessException e){
            throw new RuntimeException(e);
        }
    }
    
    
  static void method_missing(String method, Object... args){
      throw new UnsupportedOperationException(String.format("No such method '%s'", method));
  }
    
  private static CallSite bootstrapDynamic(Class caller, String name, MethodType type) throws NoAccessException{
    type = type.insertParameterTypes(0, String.class);
    return new ConstantCallSite(method_missing.asType(type));
  }
}
