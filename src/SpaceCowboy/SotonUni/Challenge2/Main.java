package SpaceCowboy.SotonUni.Challenge2;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException{
        BareBonesInterpreter interpreter = new BareBonesInterpreter(
            "C:\\Users\\olive\\IdeaProjects\\SpaceCowboy\\src\\SpaceCowboy\\SotonUni\\Challenge2\\code.txt");
        interpreter.runCode();
    }
}
