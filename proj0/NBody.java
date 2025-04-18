public class NBody {

    public static double readRadius(String filename) {
        In file = new In(filename);
        int numPlanets = file.readInt(); // Skip the number of planets
        double radius = file.readDouble(); // Read the radius
        return radius;
    }   

    public static Planet[] readPlanets(String filename) {
        In file = new In(filename);
        int numPlanets = file.readInt(); // Skip the number of planets
        double radius = file.readDouble();

        Planet[] planets = new Planet[numPlanets];
        for(int i = 0; i < numPlanets; i++) {
            planets[i] = new Planet(
                file.readDouble(), // xxPos
                file.readDouble(), // yyPos
                file.readDouble(), // xxVel
                file.readDouble(), // yyVel
                file.readDouble(), // mass
                file.readString()  // imgFileName
            );
        }
        return planets;        
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = NBody.readRadius(filename);
        Planet[] planets = NBody.readPlanets(filename);
    
        // Set the scale of the universe
        StdDraw.setScale(-radius, radius);
        
        // Draw the background
        StdDraw.picture(0, 0, "images/starfield.jpg", 2*radius, 2*radius);
        
        // Draw all the planets
        for (Planet planet : planets) {
            planet.draw();
        }
        enableDoubleBuffering();
        enableDoubleBuffering();
        show();
        double time = 0.0;
    }
}
