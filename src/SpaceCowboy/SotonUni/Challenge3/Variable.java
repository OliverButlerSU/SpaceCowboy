package SpaceCowboy.SotonUni.Challenge3;

public class Variable {

    private final String variableName;
    private int variableValue;

    public Variable(String variableName){
        this.variableName = variableName;
        variableValue = 0;
    }

    int getVariableValue(){
        return variableValue;
    }

    public void setVariableValue(int variableValue) {
        this.variableValue = variableValue;
    }

    String getVariableName(){
        return variableName;
    }

    public void increaseVariableWorth(){
        variableValue++;
    }

    public void decreaseVariableWorth() {
        variableValue--;
    }

    public void resetWorth(){
        variableValue=0;
    }
}
