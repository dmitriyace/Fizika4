public class Main {
    public static void main(String... args) {
        double[] d1p1 = {-26.8, -36.7, -45.5, -52.5, -58, -62.1, -65.9, -68.9};
        double[] d1p2 = {-26.7, -35.6, -45.4, -52.2, -58, -62.3, -66, -69};
        double[] d2p1 = {-16.7, -33.5, -42.5, -49.9, -55.5, -60.1, -63.4, -64.8};
        double[] d2p2 = {-16.8, -33.1, -42.6, -49.7, -55.3, -59.8, -63.5, -64.9};
        double[] d3p1 = {-15.2, -29.2, -38.9, -46.5, -52.4, -57.5, -60.2, -63.7};
        double[] d3p2 = {-15.1, -28.8, -38.4, -45.6, -51.4, -56.2, -60.1, -63.8};
        double[] d4p1 = {-14.4, -25.2, -35.2, -43.1, -49.6, -55.1, -59.1, -62.7};
        double[] d4p2 = {-14.3, -24.9, -34.6, -43.0, -49.5, -54.9, -59.1, -62.8};
        double[] d5p1 = {-12.9, -23.3, -33.6, -42.0, -48.6, -53.7, -58.1, -61.7};
        double[] d5p2 = {-13.0, -22.8, -32.8, -41.5, -48.4, -53.7, -58, -61.8};

        final double p0 = 100151.78;
        double[] t = {15.9, 29.2, 42.2, 50.8, 58.2};
        double[][] p = new double[5][8];
        for (int i = 0; i < 8; i++) {
            p[0][i] = p0 / 1000 + (d1p1[i] + d1p2[i]) / 2;
        }
        for (int i = 0; i < 8; i++) {
            p[1][i] = p0 / 1000 + (d2p1[i] + d2p2[i]) / 2;
        }
        for (int i = 0; i < 8; i++) {
            p[2][i] = p0 / 1000 + (d3p1[i] + d3p2[i]) / 2;
        }
        for (int i = 0; i < 8; i++) {
            p[3][i] = p0 / 1000 + (d4p1[i] + d4p2[i]) / 2;
        }
        for (int i = 0; i < 8; i++) {
            p[4][i] = p0 / 1000 + (d5p1[i] + d5p2[i]) / 2;
        }
        double[] y = new double[8];
        double[] x = new double[8];
        double[] d = new double[8];
        double[] a = new double[8];
        double[] c = new double[8];
double[]tz = new double[8];
        double sy;
        double sx;
        double sd;
        double sa;
        for (int i = 0; i < 8; i++) {
            sy = 0;
            sx = 0;
            sd = 0;
            sa = 0;
            for (int j = 0; j < 5; j++) {
                sy += p[j][i];
                sx += t[j];

            }
            y[i] =    sy/5;
            x[i] =  sx/5;
            for (int j = 0; j < 5; j++) {
                sd += Math.pow((t[j] - x[i]), 2);
                sa += (t[j] - x[i]) * y[i];
            }
            d[i] = sd;

            a[i] =  sa/d[i];
            c[i]=y[i]-a[i]*x[i];
            tz[i]=-a[i]/c[i];
            System.out.println(tz[i]);
        }

    }
}
