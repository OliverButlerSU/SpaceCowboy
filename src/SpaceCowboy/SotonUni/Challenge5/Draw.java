package SpaceCowboy.SotonUni.Challenge5;

public class Draw {

    private final Spirograph spirograph;
    private final double speed;
    private final int iterations;

    public Draw(Spirograph spirograph, double speed, int iterations){
        this.spirograph = spirograph;
        this.speed = speed;
        this.iterations = iterations;
    }


    /**
     * Draws the spirograph
     */
    public void draw(){

        final double R = spirograph.getR();
        final double r = spirograph.getr();
        final double a = spirograph.getA();
        final double incr = spirograph.getIncr();


        double lastX = spirograph.calculateX(0);
        double lastY = spirograph.calculateY(0);


        Turtle draw = new Turtle(lastX,lastY);
        draw.speed(speed);


        for(double t = 0; t < iterations; t+=incr){


            //Another formulae I was originally going to use might add tomorrow
            //double newX = (R+r) * Math.cos(t) - (r+a) * Math.cos(((R+r)/r)*t);
            //double newY = (R+r) * Math.sin(t) - (r+a) * Math.sin(((R+r)/r)*t);

            double newX = spirograph.calculateX(t);
            double newY = spirograph.calculateY(t);

            double lengthX = newX - lastX;
            double lengthY = newY - lastY;


            lastX = newX;
            lastY = newY;

            double length = Math.sqrt(Math.pow(lengthX,2) + Math.pow(lengthY,2));
            draw.face(lastX,lastY);
            draw.forward(length);

        }

    }
}
