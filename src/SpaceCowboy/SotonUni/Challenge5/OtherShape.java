package SpaceCowboy.SotonUni.Challenge5;

public class OtherShape implements Equation{

    private Spirograph spiro;
    private final double R;
    private final double r;
    private final double a;


    public OtherShape(Spirograph sprio){
        this.spiro = sprio;


        R = spiro.getR();
        r = spiro.getr();
        a = spiro.getA();
    }

    @Override
    public double calculateX(double t) {
        return (R+r) * Math.cos(t) - (r+a) * Math.cos(((R+r)/r)*t);
    }

    @Override
    public double calculateY(double t) {
        return (R+r) * Math.sin(t) - (r+a) * Math.sin(((R+r)/r)*t);
    }

}
