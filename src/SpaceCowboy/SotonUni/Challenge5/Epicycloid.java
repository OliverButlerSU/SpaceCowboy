package SpaceCowboy.SotonUni.Challenge5;

public class Epicycloid implements Equation{

    private Spirograph spiro;
    private final double R;
    private final double r;
    private final double a;


    public Epicycloid(Spirograph sprio){
        this.spiro = sprio;


        R = spiro.getR();
        r = spiro.getr();
        a = spiro.getA();
    }

    @Override
    public double calculateX(double t) {
        return (R+r) * Math.cos(r/R*t) - a*Math.cos((1+r/R)*t);
    }

    @Override
    public double calculateY(double t) {
        return (R+r) * Math.sin(r/R*t)- a*Math.sin((1+r/R)*t);
    }

}
