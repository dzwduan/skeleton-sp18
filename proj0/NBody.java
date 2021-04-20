public class NBody {
    public static double readRadius(String path){
        In in = new In(path);
        int num = in.readInt();
        double rad = in.readDouble();
        return rad;
    }

    public static Planet[] readPlanets(String path){
        In in = new In(path);
        int num = in.readInt();
        double rad = in.readDouble();
        Planet[] res = new Planet[num];
        for(int i=0;i<num;i++){
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass =  in.readDouble();
            String imgFileName =  in.readString();
            res[i] = new Planet(xxPos,yyPos,xxVel,yyVel,mass,imgFileName);
        }
        return res;
    }


    public static  void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt= Double.parseDouble(args[1]);
        String filename = args[2];

        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        StdDraw.setScale(-radius,radius);
        StdDraw.clear();
        StdDraw.picture(512,512,"images/starfield.jpg");
        //StdDraw.show();

        for(Planet p: planets){
            p.draw();
        }

        StdDraw.enableDoubleBuffering();

        double start = 0;

        for(double t = 0; t<T; t+=dt){
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];


            for(int i=0;i< planets.length;i++){
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }

            for(int i=0;i<planets.length;i++){
                planets[i].update(dt,xForces[i],yForces[i]);
            }

            StdDraw.setScale(-radius,radius);
            StdDraw.clear();
            StdDraw.picture(512,512,"images/starfield.jpg");
            //StdDraw.show();

            for(Planet p: planets){
                p.draw();
            }

            StdDraw.show();
            StdDraw.pause(10);
        }


        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }

    }

}
