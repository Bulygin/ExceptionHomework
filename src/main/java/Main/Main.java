package Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.Optional;

public class Main {

  public static void main(String[] args) throws Exception {

    try (AutoCloseableClass autoCloseableTest = new AutoCloseableClass()) {
      autoCloseableTest.doSomething();
    }

    /**
     * My variable is null. Exception was thrown in constructor, before "new".
     * Reference was not created.
     */
    ClassHasExInConstruct classHasExInConstruct;
    try {
      classHasExInConstruct = new ClassHasExInConstruct(10);
    } catch (MyOwnException e) {
      e.printStackTrace();
    }

    try {
      new LifeCycleAction().execute();
    } catch (LifeCycleActionExecutionException | AccessDeniedException e) {
      System.err.println(e.getLocalizedMessage());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    try (FileInputStream fileInputStream = new FileInputStream(args[0])) {

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void exceptionVsResult() {
    final String result1 = (String) this.returnResult().value;
    final String result2 = returnOptional().orElse("");
    String result3 = "";
    try {
      result3 = returnValueOrThrowException();
    } catch (AccessDeniedException e) {
    }
  }

  private Result returnResult() {
    return Result.OK.setValue("OK");
  }

  private Optional<String> returnOptional() {
    return Optional.of("OK");
  }

  private String returnValueOrThrowException() throws AccessDeniedException {
    return "OK";
  }

  public static class LifeCycleAction {

    public void execute()
        throws LifeCycleActionExecutionException, AccessDeniedException, MyOwnException {
      throw new LifeCycleActionExecutionException();
    }
  }

  public static class LifeCycleActionExecutionException extends Exception {

  }

  public static class MyOwnException extends Exception {

  }
}


