package SpaceCowboy.SotonUni.Challenge5;

public class Draw {
    private final Equation equation;
    private final double speed;
    private final int iterations;
    private double incr = 0.01;

    public Draw(Equation equation, double speed, int iterations, double incr){
        this.equation = equation;
        this.speed = speed;
        this.iterations = iterations;
        if(incr > 0){
            this.incr = incr;
        }
    }


    /**
     * Draws the spirograph
     */
    public void draw(){
        double lastX = equation.calculateX(0);
        double lastY = equation.calculateY(0);

        Turtle draw = new Turtle(lastX,lastY);
        draw.speed(speed);


        for(double t = 0; t < iterations; t+=incr){

            double newX = equation.calculateX(t);
            double newY = equation.calculateY(t);

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
