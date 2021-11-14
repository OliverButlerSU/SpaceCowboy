package SpaceCowboy.SotonUni.Challenge5;

public class Main {
    public static void main(String[] args){

        /*
        Resources used:
        http://www.mathematische-basteleien.de/spirographs.htm#top
        (basically stolen all formula from this)

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
        Spirograph spiro2 = new Spirograph(102, 20, 90);

        Hypercloid hypercloid = new Hypercloid(spiro1);
        Epicycloid epicycloid = new Epicycloid(spiro2);
        OtherShape otherShape = new OtherShape(spiro2);

        Draw draw1 = new Draw(hypercloid, 0.01, 1000, 0.01);
        Draw draw2 = new Draw(epicycloid, 0.01, 1000, 0.01);
        Draw draw3 = new Draw(otherShape, 0.01, 1000, 0.01);

        draw3.draw();
    }
}
