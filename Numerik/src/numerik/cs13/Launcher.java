package numerik.cs13;

public class Launcher {

    public static void main(String[] args) {
	rungeKutta();
    }

    // aendern
    public static void rungeKutta() {

	double y = 2;
	double x = 0;
	double h = 0.1;

	double k1 = 0;
	double k2 = 0;
	double k3 = 0;
	double k4 = 0;

	// i aendern!
	for (int i = 0; i <= 5; i++) {

	    // x = xi = ?
	    k1 = f(x, y);
	    k2 = f(x + 0.5 * h, y + 0.5 * k1 * h);
	    k3 = f(x + 0.5 * h, y + 0.5 * k2 * h);
	    k4 = f(x + h, y + k3 * h);
	    y = y + 1 / 6 * (k1 + 2 * k2 + 2 * k3 + k4) * h;
	    x = x + h;

	    System.out.println("Schritt " + i + ": " + x + " ; " + y);

	}

	// 		Formel Runge-Kutta: 
	//		yn+1 = yn + 1/6 (k1 + 2 * k2 + 2 * k3 + k4) h
	//			k1 = f(xi, yi)
	//			k2 = f(xi + 1/2 * h, yi + 1/2 * k1 * h)
	//			k3 = f(xi + 1/2 * h, yi + 1/2 * k2 * h)
	//			k4 = f(xi + h, yi + k3 * h)

    }

    public static double f(double x, double y) {
	// Definiere funktion hier!
	return y - Math.pow(x, 3);
    }

}
