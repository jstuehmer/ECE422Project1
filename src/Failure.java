/*
 * Created on March 5, 2017
 * @author: Stuehmer
 */

public class Failure {

    public static boolean failOccurs(int memAccesses, double failProb) {
        double r = Math.random();
        return (r >= 0.5 && r <= 0.5 + memAccesses * failProb);
    }
}
