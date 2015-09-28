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

	double t = 0; // TODO

	// Initialisierung der Variablen k fuer Runge-Kutta
	double k1 = 0;
	double k2 = 0;
	double k3 = 0;
	double k4 = 0;

	if (f == 1) {// i = Anzahl der Schritte
	    for (int i = 1; i <= 10 * zielwert; i++) {
		k1 = f11(x, y, t);
		k2 = f11(x + 0.5 * h, y + 0.5 * k1 * h, t);
		k3 = f11(x + 0.5 * h, y + 0.5 * k2 * h, t);
		k4 = f11(x + h, y + k3 * h, t);
		r[i] = r[i - 1] + (h / 6) * (k1 + 2 * k2 + 2 * k3 + k4);

		k1 = f12(x, y, t);
		k2 = f12(x + 0.5 * h, y + 0.5 * k1 * h, t);
		k3 = f12(x + 0.5 * h, y + 0.5 * k2 * h, t);
		k4 = f12(x + h, y + k3 * h, t);
		r[i] = r[i - 1] + (h / 6) * (k1 + 2 * k2 + 2 * k3 + k4);
		x = x + h;
	    }
	} else {// i = Anzahl der Schritte
	    for (int i = 1; i <= 10 * zielwert; i++) {
		//		k1 = f2(x, y);
		//		k2 = f2(x + 0.5 * h, y + 0.5 * k1 * h);
		//		k3 = f2(x + 0.5 * h, y + 0.5 * k2 * h);
		//		k4 = f2(x + h, y + k3 * h);
		r[i] = r[i - 1] + (h / 6) * (k1 + 2 * k2 + 2 * k3 + k4);
		x = x + h;
	    }
	}
	return r;
    }

    public double f11(double y1, double y2, double t) {
	return y2;
    }

    public double f12(double y1, double y2, double t) {
	return y1 - Math.pow(t, 3);
    }

    public double f21(double y1, double y2, double t) {
	return t;//TODO
    }

    public double f22(double y1, double y2, double t) {
	return t;// TODO
    }

}
