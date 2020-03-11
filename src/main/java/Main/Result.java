package Main;

//Problems - no type parameters
//only
public enum Result {
    OK, NONE;

    public Object value;

    Result() {
    }

    public Result setValue(String value) {
        this.value = value;
        return this;
    }
}
