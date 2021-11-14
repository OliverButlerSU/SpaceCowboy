package SpaceCowboy.SotonUni.Challenge5;

public class Spirograph {

    private final double R;
    private final double r;
    private final double a;
    double incr = 0.01;

    public Spirograph(double R, double r, double a){
        this.R = R;
        this.r = r;
        this.a = a;
    }

    public double getR() {
        return R;
    }

    public double getr(){
        return r;
    }

    public double getA() {
        return a;
    }

    public double getIncr(){
        return incr;
    }


    public void setIncr(double incr) {
        if(incr > 0){
            this.incr = incr;
        }
    }


    /**
     * Calculates X position
     * @param t (Time)
     * @return (X position)
     */
    public double calculateX(double t){
        return (R-r) * Math.cos(r/R*t) + a*Math.cos((1-r/R)*t);
    }

    /**
     * Calculates Y position
     * @param t (Time)
     * @return (Y Positon)
     */
    public double calculateY(double t){
        return (R-r) * Math.sin(r/R*t)- a*Math.sin((1-r/R)*t);
    }
}
