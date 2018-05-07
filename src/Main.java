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
        double y;
        double x;
        double d;
        double[] a = new double[8];
        double[] c = new double[8];
        double[] tz = new double[8];
        double sy = 0;
        double sx = 0;
        double sd;
        double sa;
        double se = 0;
        double E;
        sd = 0;
        for (int j = 0; j < 5; j++) {
            sy += p[j][0];
            sx += t[j];


        }

        y = sy / 5;
//            System.out.println(y[i]);
        x = sx / 5;
//        System.out.println(x);
//        System.out.println(y);
        for (int j = 0; j < 5; j++) {
            sd += Math.pow((t[j] - x), 2);
        }
        d = sd;

//        System.out.println(d);
        for (int i = 0; i < 8; i++) {
            sa = 0;
            for (int j = 0; j < 5; j++) {

                sa += (t[j] - x) * p[j][i];
            }

            a[i] = sa / d;
//            System.out.println(a[i]);
            c[i] = y - a[i] * x;
//            System.out.println(c[i]);
            tz[i] = -c[i] / a[i];
//            System.out.println(tz[i]);

        }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        double[] Vc = {0.02, 0.016667, 0.0142857, 0.0125, 0.0111111, 0.01, 0.009090909, 0.008333333};
        sy = 0;
        sx = 0;
        for (int j = 0; j < 8; j++) {
            sy += tz[j];
            sx += Vc[j];
        }
        y = sy / 8;
//            System.out.println(y[i]);
        x = sx / 8;
//        System.out.println(y);
//        System.out.println(x);
        sd = 0;
        for (int j = 0; j < 8; j++) {
            sd += Math.pow((Vc[j] - x), 2);

        }
        d = sd;
//        System.out.println(d);
        sa = 0;
        for (int j = 0; j < 8; j++) {
            sa += (Vc[j] - x) * tz[j];
            System.out.println(Vc[j] - x);
        }
//        System.out.println(sa);
        double aa = sa / d;
        double cc = y - aa * x;
//        System.out.println(aa);
//        System.out.println(cc);

        double e;
         se=0;
        for (int i=0;i<8;i++){
            se+=Math.pow((tz[i]-aa*Vc[i]-cc),2);

        }

        e=se/6;
        double dc;
        dc=Math.sqrt(((1/8)+(x/d))*e);
        double da = Math.sqrt(e/d);
        System.out.println(e);
        System.out.println(dc);
        System.out.println(da);
    }
}
