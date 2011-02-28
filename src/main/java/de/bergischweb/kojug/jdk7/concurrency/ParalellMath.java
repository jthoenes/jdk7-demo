package de.bergischweb.kojug.jdk7.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by IntelliJ IDEA.
 * User: jthoenes
 * Date: 27.02.11
 * Time: 15:49
 * To change this template use File | Settings | File Templates.
 */
public enum ParalellMath {

  INSTANCE;
  private ForkJoinPool pool;

  private ParalellMath() {
    pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
  }

  public long fibonacci(long number) {
    try {
      FibonacciTask task = new FibonacciTask(number);
      pool.execute(task);
      return task.get();
    } catch (final InterruptedException | ExecutionException e){
      throw new RuntimeException(e);
    }
  }

}
