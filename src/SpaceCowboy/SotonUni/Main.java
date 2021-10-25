package SpaceCowboy.SotonUni;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException{


        //Challenge 2

        BareBonesInterpreter interpreter =
        new BareBonesInterpreter(
            "C:\\Users\\Windows\\IdeaProjects\\Space Cowboys\\src\\SpaceCowboy\\SotonUni\\code.txt");

        interpreter.runCode();


        /*
        Challenge 1

        SCChallengeEmail version = new SCChallengeEmail();
        String name = "Oliver Butler";
        version.simpleECSEmailLookup(); -> Original Problem
        version.homePage(); -> Advance Variation #2
        version.nameAnagram(name); -> Advance Variation #3
        version.engToFrTranslation(); -> Advance Variation #4 (Doesn't work yet)
        */

    }
}
