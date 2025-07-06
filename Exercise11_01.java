/* ---------------------------------------------------------------
   File : Exercise11_01.java
   Path : src/main/java/assignments/Exercise11_01/Exercise11_01.java
---------------------------------------------------------------- */
package assignments.Exercise11_01;
import java.util.Scanner;

/* ---------- Driver / test program ---------- */
public class Exercise11_01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // prompt user
        System.out.print("Enter three sides separated by spaces: ");
        double s1 = input.nextDouble();
        double s2 = input.nextDouble();
        double s3 = input.nextDouble();

        System.out.print("Enter a color: ");
        String color = input.next();

        System.out.print("Is the triangle filled? (true/false): ");
        boolean filled = input.nextBoolean();

        // create triangle and set inherited props
        Triangle tri = new Triangle(s1, s2, s3);
        tri.setColor(color);
        tri.setFilled(filled);

        // show results
        System.out.println("\n" + tri);                 // toString()
        System.out.printf("Area      : %.4f%n", tri.getArea());
        System.out.printf("Perimeter : %.4f%n", tri.getPerimeter());
        System.out.println("Color     : " + tri.getColor());
        System.out.println("Filled    : " + tri.isFilled());
    }
}

/* ------------- Triangle (implements spec) ------------- */
class Triangle extends GeometricObject {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    /* no-arg constructor → default 1-1-1 */
    public Triangle() {}

    /* explicit-sides constructor */
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    /* ---- accessors ---- */
    public double getSide1() { return side1; }
    public double getSide2() { return side2; }
    public double getSide3() { return side3; }

    /* ---- core methods ---- */
    @Override
    public double getArea() {
        double p = getPerimeter() / 2.0;                // semi-perimeter
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public String toString() {
        return "Triangle: side1 = " + side1 +
               " side2 = " + side2 +
               " side3 = " + side3;
    }
}

/* ------------- GeometricObject (from the text) ------------- */
abstract class GeometricObject {
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated = new java.util.Date();

    protected GeometricObject() {}

    protected GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    /* accessors / mutators */
    public String  getColor()         { return color; }
    public void    setColor(String c) { color = c; }
    public boolean isFilled()         { return filled; }
    public void    setFilled(boolean f) { filled = f; }
    public java.util.Date getDateCreated() { return dateCreated; }

    /* abstract area/perimeter */
    public abstract double getArea();
    public abstract double getPerimeter();
}
