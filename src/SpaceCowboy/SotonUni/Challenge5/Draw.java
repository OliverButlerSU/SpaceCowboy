package SpaceCowboy.SotonUni.Challenge5;

public class Draw {
    private final Equation equation;
    private final double speed;
    private final int iterations;
    private double incr = 0.01;
    private double size = 1;

    //private int[] colors = new int[] {0,0,0}; -> R,G,B
    private final String[] colors=new String[] {"red","orange","yellow","green","blue", "indigo", "violet"};

    public Draw(Equation equation, double speed, int iterations, double incr, double size){
        this.equation = equation;
        this.speed = speed;
        this.iterations = iterations;
        if(incr > 0){
            this.incr = incr;
        }
        if(size != 0){
            this.size = size;
        }
    }


    /**
     * Draws the spirograph
     */
    public void draw(){
        double lastX = size * equation.calculateX(0);
        double lastY = size * equation.calculateY(0);

        Turtle draw = new Turtle(lastX,lastY);
        draw.speed(speed);


        for(double t = 0; t < iterations; t+=incr){

            double newX = size * equation.calculateX(t);
            double newY = size * equation.calculateY(t);

            double lengthX = newX - lastX;
            double lengthY = newY - lastY;

            lastX = newX;
            lastY = newY;

            double length = Math.sqrt(Math.pow(lengthX,2) + Math.pow(lengthY,2));
            draw.face(lastX,lastY);
            draw.forward(length);

            draw.penColor(rainbowEffect(t));
        }

    }


    /**
     * Returns the color used being any value from color array
     * @param t (Tth value)
     * @return (String of color using color array)
     */
    private String rainbowEffect(double t){
        return colors[(int)t%colors.length];
    }


    /*
    Grey scale

    private Color rainbowEffect(){
        for(int i = 0; i < colors.length; i++){
            colors[i] = incrementColour(colors[i]);
        }
        return new Color(colors[0],colors[1],colors[2]);
    }

    private int incrementColour(int number){
        number++;
        if(number>255){
            return 0;
        }
        return number;
    }

     */
}
