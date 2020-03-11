package Main;

public class ClassHasExInConstruct {

  private int i;

  ClassHasExInConstruct(int i) throws Main.MyOwnException {
    this.i = i;
    throw new Main.MyOwnException();
  }
}
