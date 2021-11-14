package SpaceCowboy.SotonUni.Challenge5;

public interface Equation {

    /**
     * Calculates X position
     * @param t (Time)
     * @return (X Positon)
     */
    public double calculateX(double t);

    /**
     * Calculates Y position
     * @param t (Time)
     * @return (Y Positon)
     */
    public double calculateY(double t);
}
