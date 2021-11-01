package SpaceCowboy.SotonUni.Challenge3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class BareBonesInterpreter {
    //variables -> [Key: Variable Name], [Value: Variable Value]
    private HashMap<String, Variable> variables = new HashMap<>();
    //methods -> [Key: Method Name], [Value: Line number]
    private HashMap<String, Integer> methods = new HashMap<>();

    //Stores all code
    private List<String[]> codeText = new ArrayList<>();
    //Stores the line number a while loop is on
    private Stack<Integer> whileLine = new Stack<>();
    private Stack<Integer> methodLine = new Stack<>();
    private int lineNumber = 0;


    /**
     * Reads text file
     * @param textFilePath
     * @throws IOException
     */
    public BareBonesInterpreter(String textFilePath) throws IOException {
        BufferedReader textReader = new BufferedReader(new FileReader(textFilePath));

        try {
            //Read text in text file, and append to the List 'codeText'
            String line = textReader.readLine();

            while (line != null) {
                //Add each line to a List, splitting each line into an array for each word
                codeText.add(line.trim().split(" "));
                line = textReader.readLine();
            }
        } catch (Exception e){
            errorMessage("Error reading code: "+e.getMessage());
        }
        finally {
            //Stop reading file and run code
            textReader.close();
        }

    }

    /**
     * Runs code line by line
     */
    public void runCode(){
        for(lineNumber = 0; lineNumber < codeText.size(); lineNumber++){
            decodeLine(codeText.get(lineNumber));
        }
    }


    /**
     * Reads each line for each statement
     * @param currentLine
     */
    private void decodeLine(String[] currentLine){
        try{
            switch(currentLine[0]){
                case "clear":
                    addVariable(currentLine[1]);
                    break;
                case "incr":
                    increaseVariableWorth(currentLine[1]);
                    break;
                case "decr":
                    decreaseVariableWorth(currentLine[1]);
                    break;
                case "while":
                    whileLine.push(lineNumber);
                    break;
                case "end":
                    if(variables.get(codeText.get(whileLine.peek())[1]).getVariableValue() != 0){
                        lineNumber = whileLine.peek();
                    } else {
                        whileLine.pop();
                    }
                    break;
                case "print":
                    System.out.println(variables.get(currentLine[1]).getVariableValue());
                    break;
                case "func":
                    //TODO: Methods
                    break;
                case "endFunc":
                    //TODO: Endfunc
                    break;
                case "#":
                    //Do nothing
                    break;
                default:
                    errorMessage("Invalid command / format");
                    break;
            }
        } catch(Exception e){
            errorMessage("Invalid command / format");
        }

    }




    /**
     * Initialises a new variable with value 0. If the variable already exists, output an error message
     * @param variableName
     */
    private void addVariable(String variableName){
        if(!variables.containsKey(variableName)){
            variables.put(variableName,new Variable(variableName));
        } else{
            variables.get(variableName).resetWorth();
        }
    }


    /***
     * Returns the variable's value, if the variable doesn't exist, output error message
     * @param variableName
     * @return variableValue
     */
    private int getVariableValue(String variableName){
        if (!validateVariableWorth(variableName)){
            errorMessage("Variable does not exist");
        }
        return variables.get(variableName).getVariableValue();
    }


    /**
     * Decreases the variables value by 1, if the variable doesn't exist, output error message
     * @param variableName
     */
    private void decreaseVariableWorth(String variableName){
        if (validateVariableWorth(variableName)){
            variables.get(variableName).decreaseVariableWorth();
        } else{
            errorMessage("Variable does not exist");
        }
    }

    /**
     * Increases the variables value by 1, if the variable doesn't exist, output error message
     * @param variableName
     */
    private void increaseVariableWorth(String variableName){
        if (validateVariableWorth(variableName)){
            variables.get(variableName).increaseVariableWorth();
        } else{
            errorMessage("Variable does not exist");
        }
    }

    /**
     * Finds out whether the variable name has been initialised yet
     * @param variableName
     * @return If variable exists
     */
    private boolean validateVariableWorth(String variableName){
        if (variables.containsKey(variableName)){
            return true;
        }
        return false;
    }



    /**
     * Prints an error code to console and closes the application
     * @param errorType
     */
    private void errorMessage(String errorType){
        System.out.println("Error on line: "+(lineNumber+1)+"\nError Type: "+ errorType);
        System.exit(1);
    }
}
