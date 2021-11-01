package SpaceCowboy.SotonUni.Challenge3;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException{
        BareBonesInterpreter interpreter =
        new BareBonesInterpreter(
            "C:\\Users\\Windows\\IdeaProjects\\Space Cowboys\\src\\SpaceCowboy\\SotonUni\\code.txt");

        interpreter.runCode();

    }
}
