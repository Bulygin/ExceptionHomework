package Main;

class AutoCloseableClass implements AutoCloseable {

  void doSomething() {
    System.out.println("I do something?");
  }

  @Override
  public void close() {
    System.out.println("AutoCloseableClass was closed");
  }
}
