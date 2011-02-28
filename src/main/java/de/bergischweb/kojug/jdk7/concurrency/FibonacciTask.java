/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bergischweb.kojug.jdk7.concurrency;

import java.util.concurrent.ForkJoinTask;

/**
 * @author Johannes Th&ouml;nes <johannes.thoenes@googlemail.com>
 */
public class FibonacciTask extends ForkJoinTask<Long> {

  
  private Long number;
  private Long result;

  public FibonacciTask(Long number) {
    this.number = number;
  }

  @Override
  protected boolean exec() {
    final Long THRESHOLD = 13l;
    if (number < THRESHOLD) {
      result = seqFibbonacci(number);
    } else {
      FibonacciTask r1 = new FibonacciTask(number - 1);
      FibonacciTask r2 = new FibonacciTask(number - 2);
      invokeAll(r1, r2);
      result = r1.result + r2.result;
    }
    return true;
  }

  private Long seqFibbonacci(Long n) {
    if (n <= 1) {
      return n;
    } else {
      return seqFibbonacci(n - 1) + seqFibbonacci(n - 2);
    }
  }

  @Override
  public Long getRawResult() {
    if (!isDone()) {
      throw new IllegalStateException();
    }
    return result;
  }

  @Override
  protected void setRawResult(Long result) {
    this.result = result;
  }
}
