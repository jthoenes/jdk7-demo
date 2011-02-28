package de.bergischweb.kojug.jdk7.concurrency;

/**
 * Created by IntelliJ IDEA.
 * User: jthoenes
 * Date: 27.02.11
 * Time: 15:54
 * To change this template use File | Settings | File Templates.
 */
public class Main {

  public static void main(String... args) {
    ParalellMath math = ParalellMath.INSTANCE;

    System.out.println(math.fibonacci(40));
    
    
  }
}
