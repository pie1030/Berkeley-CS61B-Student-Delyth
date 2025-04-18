public class TestforPlanet {
    public static void main(String[] args) {
        Planet p1 = new Planet(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
        Planet p2 = new Planet(2.0, 1.0, 3.0, 2.0, 5.0, "kevin.gif");
        System.out.println("Distance between p1 and p2: " + p1.calcDistance(p2)); // Expected: 1.0
        System.out.println("Force between p2 and p1: " + Math.abs(p1.calcForceExertedBy(p2))); // Expected: 0.0 (since they are at the same y position)
    }
}
