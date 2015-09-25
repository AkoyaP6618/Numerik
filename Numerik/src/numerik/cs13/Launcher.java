package numerik.cs13;

public class Launcher {

    public static double[] y1;
    public static double[] y2;

    public static void main(String[] args) {
	RungeKutta rk = new RungeKutta();
	AWPtoRWP awpToRwp = new AWPtoRWP();

	System.out.println("Loesung folgender DGL 2. Ordnung als Randwertproblem:");
	System.out.println("-y'' + y = t^3 , y(0) = 2, y(2) = 1\r");
	System.out.println("1. 2 Anfangswertprobleme mit Runge-Kutta");
	double[] y1 = rk.rungeKutta(2, 4, 1);
	double[] y2 = rk.rungeKutta(0, 4, 2);
	double c = awpToRwp.calculateC(2, 1, y1, y2);
	double y[] = awpToRwp.toRWP(y1, y2, c);
	for (int i = 0; i < y.length; i++) {
	    double x = ((double) i) / 10;
	    System.out.println("x = " + x + " ;  y = " + y2[i]);

	}
    }

    public static void schiessverfahren() {
	// y" = y - t^3
	// ? ? ? ? ? ? ? ? ? ? ? ? ? ? ?
	// y' = y^2/2 - t^3*y + c
	// y  = y^3/6 - t^3*y + c*x + d
	// y(0)=2 , y'(0)=c solange in abh. von c integrieren bis y(2)=1

	// wenn y'(0)=c if(x^2/2-t^3x == -c)

    }
}
