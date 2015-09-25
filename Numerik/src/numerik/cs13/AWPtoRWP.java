package numerik.cs13;

public class AWPtoRWP {

    /**
     * berechnet aus den Loesungen der beiden Anfangswertproblemen die Loesung
     * des Randwertproblems
     * 
     * @param y1
     *            = Loesung des 1. AWP
     * @param y2
     *            = Loesung des 2. AWP
     * @param c
     *            = Konstante (beta-y1(b))/y2(b) beim RWP gilt:<br>
     *            y(a) = alpha<br>
     *            y(b) = beta
     * @return Feld aller Ergebnisse von 0 bis zum Zielwert der AWP's
     */
    public double[] toRWP(double[] y1, double[] y2, double c) {
	int length;
	if (y1.length > y2.length) {
	    length = y2.length;
	} else {
	    length = y1.length;
	}
	double y[] = new double[length];
	for (int i = 0; i < length; i++) {
	    y[i] = y1[i] + (c * y2[i]);
	}
	return y;
    }

    public double calculateC(int b, int beta, double[] y1, double[] y2) {
	return (beta - y1[10 * b]) / y2[10 * b];
    }
}
