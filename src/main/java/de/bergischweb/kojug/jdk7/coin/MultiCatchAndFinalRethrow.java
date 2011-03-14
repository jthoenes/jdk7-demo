package de.bergischweb.kojug.jdk7.coin;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Johannes Th&ouml;nes <johannes.thoenes@googlemail.com>
 */
public abstract class MultiCatchAndFinalRethrow {

  private final String arg = null;
  private static final Logger logger = LoggerFactory.getLogger(MultiCatchAndFinalRethrow.class);

  public void callJava6() {
    try {
      callWithReflection(arg);
    } catch (NoSuchMethodException e) {
      throw new RuntimeException(e);
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    } catch (InvocationTargetException e) {
      throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void callJava6NewExecption() {
    try {
      callWithReflection(arg);
    } catch (ReflectiveOperationException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void callWithBadCatch() {
    try {
      callWithReflection(arg);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public void callWithMulticatch() {
    try {
      callWithReflection(arg);
    } catch (final ReflectiveOperationException | IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void callWithRethrow() throws ReflectiveOperationException, IOException {
    try {
      callWithReflection(arg);
    } catch (final Exception e) {
      logger.trace("Exception in reflection", e);
      throw e;
    }
  }

  protected abstract void callWithReflection(String argument) throws IOException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException;
}
