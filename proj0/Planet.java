public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass  = m;
        imgFileName = img;
    }

    public Planet(Planet p){
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){
        return Math.sqrt((this.xxPos-p.xxPos)*(this.xxPos-p.xxPos) + (this.yyPos-p.yyPos)*(this.yyPos-p.yyPos));
    }

    public double calcForceExertedBy(Planet p){
        double r = calcDistance(p);
        double G = 6.67e-11;

        return G* this.mass*p.mass/(r*r) ;
    }


    public double calcForceExertedByX(Planet p){
        double r = calcDistance(p);
        double F = calcForceExertedBy(p);
        return F*(p.xxPos-this.xxPos)/r;
    }

    public double calcForceExertedByY(Planet p){
        double r = calcDistance(p);
        double F = calcForceExertedBy(p);
        return F*(p.yyPos-this.yyPos)/r;
    }

    public double calcNetForceExertedByX(Planet[] allp){
        double res = 0.0;
        for(Planet p : allp){
            if(this.equals(p)==false)
                res += calcForceExertedByX(p);
        }
        return res;
    }

    public double calcNetForceExertedByY(Planet[] allp){
        double res = 0.0;
        for(Planet p : allp){
            if(this.equals(p)==false)
                res += calcForceExertedByY(p);
        }
        return res;
    }

    public void  update(double dt, double fX, double fY){
        /* 1.get the net acceleration */
        double aX = fX/mass;
        double aY = fY/mass;

        double vNewX = xxVel + dt*aX;
        double vNewY = yyVel + dt*aY;

        double pNewX = xxPos + dt*vNewX;
        double pNewY = yyPos + dt*vNewY;

        xxVel = vNewX;
        yyVel = vNewY;
        xxPos = pNewX;
        yyPos = pNewY;
    }

    public void draw(){
        StdDraw.picture(xxPos,yyPos,"images/"+imgFileName);
    }

}
