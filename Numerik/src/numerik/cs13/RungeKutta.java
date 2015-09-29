package numerik.cs13;

public class RungeKutta {

    /**
     * loest das AWP bei gegebenem Startwert y(0)=y
     * 
     * @param y1
     *            = y(0) = y1(0)
     * @param y2
     *            = y'(0) = y2(0)
     * @param f
     * <br>
     *            Loesung fuer AWP 1 oder Awp 2
     * @return Feld aller Ergebnisse von x=0 bis Zielwert
     * @author Matthias Thurow
     */
    public double[] rungeKutta(double y1, double y2, double zielwert, double schrittweite, int f) {
	double[] r1 = new double[(int) ((1 / schrittweite) * zielwert + 1)];
	r1[0] = y1; // Anfangswert fuer y1

	double[] r2 = new double[(int) ((1 / schrittweite) * zielwert + 1)];
	r2[0] = y2;

	double h = schrittweite;

	double t = 0; // Anfangswert fuer t
	// 0 da Anfangswertproblem

	// Initialisierung der Variablen k und l fuer Runge-Kutta
	double k1 = 0;
	double k2 = 0;
	double k3 = 0;
	double k4 = 0;

	double l1 = 0;
	double l2 = 0;
	double l3 = 0;
	double l4 = 0;

	if (f == 1) {// i = Anzahl der Schritte
	    for (int i = 1; i <= (1 / schrittweite) * zielwert; i++) {
		k1 = f11(y1, y2, t);
		l1 = f12(y1, y2, t);

		k2 = f11(y1 + 0.5 * k1, y2 + 0.5 * l1, t + 0.5 * h);
		l2 = f12(y1 + 0.5 * k1, y2 + 0.5 * l1, t + 0.5 * h);

		k3 = f11(y1 + 0.5 * k2, y2 + 0.5 * l2, t + 0.5 * h);
		l3 = f12(y1 + 0.5 * k2, y2 + 0.5 * l2, t + 0.5 * h);

		k4 = f11(y1 + k3, y2 + l3 * h, t + 0.5 * h);
		l4 = f12(y1 + k3, y2 + l3 * h, t + 0.5 * h);

		r1[i] = r1[i - 1] + (h / 6) * (k1 + 2 * k2 + 2 * k3 + k4);
		r2[i] = r2[i - 1] + (h / 6) * (l1 + 2 * l2 + 2 * l3 + l4);
		t += h;
	    }
	} else {// i = Anzahl der Schritte
	    for (int i = 1; i <= (1 / schrittweite) * zielwert; i++) {
		k1 = f21(y1, y2, t);
		l1 = f22(y1, y2, t);

		k2 = f21(y1 + 0.5 * k1, y2 + 0.5 * l1, t + 0.5 * h);
		l2 = f22(y1 + 0.5 * k1, y2 + 0.5 * l1, t + 0.5 * h);

		k3 = f21(y1 + 0.5 * k2, y2 + 0.5 * l2, t + 0.5 * h);
		l3 = f22(y1 + 0.5 * k2, y2 + 0.5 * l2, t + 0.5 * h);

		k4 = f21(y1 + k3, y2 + l3 * h, t + 0.5 * h);
		l4 = f22(y1 + k3, y2 + l3 * h, t + 0.5 * h);

		r1[i] = r1[i - 1] + (h / 6) * (k1 + 2 * k2 + 2 * k3 + k4);
		r2[i] = r2[i - 1] + (h / 6) * (l1 + 2 * l2 + 2 * l3 + l4);
		t += h;
	    }
	}
	return r1;
    }

    /**
     * 1. Gleichung 1. AWP
     * 
     * @param y1
     * @param y2
     * @param t
     * @return
     * @author Matthias Thurow
     */
    public double f11(double y1, double y2, double t) {
	return y2;
    }

    /**
     * 2. Gleichung 1. AWP
     * 
     * @param y1
     * @param y2
     * @param t
     * @return
     * @author Matthias Thurow
     */
    public double f12(double y1, double y2, double t) {
	return y1 - Math.pow(t, 3);
    }

    /**
     * 1. Gleichung 2. AWP
     * 
     * @param y1
     * @param y2
     * @param t
     * @return
     * @author Matthias Thurow
     */
    public double f21(double y1, double y2, double t) {
	return y2;
    }

    /**
     * 2. Gleichung 2. AWP
     * 
     * @param y1
     * @param y2
     * @param t
     * @return
     * @author Matthias Thurow
     */
    public double f22(double y1, double y2, double t) {
	return y1;
    }

}
