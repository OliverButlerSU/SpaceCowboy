package SpaceCowboy.SotonUni.Challenge5;

public class Main {
    public static void main(String[] args){

        /*
        Resources used:
        http://www.mathematische-basteleien.de/spirographs.htm#top
        (basically stolen all formulae from this)

        Some cool values that works well (look at above link for better detail of what values mean)
        R -> Size of large circle radius
        r -> Size of small circle radius
        a -> distance away from centre of small circle

        Probably don't change these for now but do what you want
        incr = 0.01; -> The increment of each value calculated smaller = more values calculated so more accurate
        speed = 0.1; -> How fast it draws (probably stick around 0.1 to 1) smaller = faster
        iterations = 100 -> How many value it calculates where the amount done = iterations / incr
         */

        //Change for values you want it to be (just mess around with it that's how I did it)


        Spirograph spiro1 = new Spirograph(283,59,60);
        spiro1.setIncr(0.01);

        Draw draw = new Draw(spiro1, 0.01, 1000);
        draw.draw();
    }
}
