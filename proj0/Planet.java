public class Planet {
    /** Properties／instance variables of the Planet class */
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName; // name of the image file (e.g., "jupiter.gif")

    /** Constructor for the Planet class */
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    /** Method to calculate the distance between two planets */
    public double calcDistance(Planet p) {
        double x = p.xxPos - this.xxPos;
        double y = p.yyPos - this.yyPos;
        double r = Math.sqrt(x * x + y * y);
        return r;
    }

    /** Method to calculate the force exerted on this planet by another planet */
    public double calcForceExertedBy(Planet p) {
        double distance = Math.pow(this.calcDistance(p), 2);
        double G = 6.67e-11; // gravitational constant
        double force = (G * this.mass * p.mass) / distance;
        return force;
    }

    /** Method to calculate the force exerted on this planet by another planet in the x direction */
    public double calcForceExertedByX(Planet p) {
        double F = this.calcForceExertedBy(p);
        double F_x = F * (p.xxPos - this.xxPos) / this.calcDistance(p);
        return F_x;
    }

    /** Method to calculate the force exerted on this planet by another planet in the y direction */
    public double calcForceExertedByY(Planet p) {
        double F = this.calcForceExertedBy(p);
        double F_y = F * (p.yyPos - this.yyPos) / this.calcDistance(p);
        return F_y;
    }

    /** Method to calculate the net force exerted on this planet by all other planets in the x direction */
    public double calcNetForceExertedByX(Planet[] planets){
        double netForceX = 0.0;
        for(Planet i : planets){
            if(this.equals(i)){
                continue;
            }
            netForceX += this.calcForceExertedByX(i);
        }
        return netForceX;
    }

    /** Method to calculate the net force exerted on this planet by all other planets in the y direction */
    public double calcNetForceExertedByY(Planet[] planets){
        double netForceY = 0.0;
        for(int i = 0; i < planets.length; i++){
            Planet temp = planets[i];
            if(this.equals(temp)){
                continue;
            }
            netForceY += this.calcForceExertedByY(temp);
        }
        return netForceY;
    }

    /** Method to update the planet's position and velocity based on the forces acting on it */
    public void update(double dt, double fx, double fy) {
        double ax = fx / this.mass;
        double ay = fy / this.mass;
        this.xxVel += ax * dt;
        this.yyVel += ay * dt;
        this.xxPos += this.xxVel * dt;
        this.yyPos += this.yyVel * dt; 
    }

    /** Method to draw the planet at its current position */
    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}