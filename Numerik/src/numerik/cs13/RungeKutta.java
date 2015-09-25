package numerik.cs13;

public class RungeKutta {

    /**
     * loest das AWP bei gegebenem Startwert y(0)=y
     * 
     * @param y
     *            = y(0)
     * @param zielwert
     * <br>
     *            mindestens zu erreichendes x (muss groesser sein, als y(0))
     * @param f
     * <br>
     *            Loesung fuer AWP 1 oder Awp 2
     * @return Feld aller Ergebnisse von x=0 bis Zielwert
     */
    public double[] rungeKutta(double y, double zielwert, int f) {
	assert zielwert >= y;

	double[] r = new double[(int) (10 * zielwert + 1)];
	r[0] = y; // Anfangswert fuer y
	double x = 0; // Anfangswert fuer x
	double h = 0.1; // Schrittweite

	// Initialisierung der Variablen k fuer Runge-Kutta
	double k1 = 0;
	double k2 = 0;
	double k3 = 0;
	double k4 = 0;

	if (f == 1) {// i = Anzahl der Schritte
	    for (int i = 1; i <= 10 * zielwert; i++) {
		k1 = f1(x, y);
		k2 = f1(x + 0.5 * h, y + 0.5 * k1 * h);
		k3 = f1(x + 0.5 * h, y + 0.5 * k2 * h);
		k4 = f1(x + h, y + k3 * h);
		r[i] = r[i - 1] + (h / 6) * (k1 + 2 * k2 + 2 * k3 + k4);
		x = x + h;
	    }
	} else {// i = Anzahl der Schritte
	    for (int i = 1; i <= 10 * zielwert; i++) {
		k1 = f2(x, y);
		k2 = f2(x + 0.5 * h, y + 0.5 * k1 * h);
		k3 = f2(x + 0.5 * h, y + 0.5 * k2 * h);
		k4 = f2(x + h, y + k3 * h);
		r[i] = r[i - 1] + (h / 6) * (k1 + 2 * k2 + 2 * k3 + k4);
		x = x + h;
	    }
	}
	return r;
    }

    /**
     * <b>AWP 1:</b> y'' = y - t^3
     * 
     * @param x
     * @param y
     * @return
     */
    public double f1(double x, double y) {
	return y - Math.pow(x, 3);
    }

    /**
     * <b>AWP 2:</b> y'' = y
     * 
     * @param x
     * @param y
     * @return
     */
    public double f2(double x, double y) {
	return y;
    }

}
