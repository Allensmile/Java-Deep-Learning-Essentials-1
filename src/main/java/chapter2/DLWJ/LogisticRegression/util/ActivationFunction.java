package chapter2.DLWJ.LogisticRegression.util;


public final class ActivationFunction {

    public static int step(double x) {
        if (x >= 0) {
            return 1;
        } else {
            return -1;
        }
    }

    public static double sigmoid(double x) {
        return 1. / (1. + Math.pow(Math.E, -x));
    }

    public static double[] softmax(double[] x, int n) {

        double[] y = new double[n];
        double max = 0.;
        double sum = 0.;

        for (int i = 0; i < n; i++) {
            if (max < x[i]) {
                max = x[i];  // to prevent overflow, 防止什么溢出？sum吗？
            }
        }

        for (int i = 0; i < n; i++) {
        	// FIX 为什么减去max?
            y[i] = Math.exp( x[i] - max );
            sum += y[i];
        }

        for (int i = 0; i < n; i++) {
            y[i] /= sum;
        }

        return y;
    }

}
