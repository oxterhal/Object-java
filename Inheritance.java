class Rectangle {
  int length, width;
  double perimeter, area;

  public Rectangle(int length, int width) {
      this.length = length;
      this.width = width;
      this.perimeter = 2 * (length + width);
      this.area = length * width;
  }

  public void print() {
      System.out.println("Rectangle:");
      System.out.println("Sides: " + length + ", " + width);
      System.out.println("Perimeter: " + perimeter);
      System.out.println("Area: " + area);
  }
}

class Triangle {
  int side1, side2, side3;
  double perimeter, area;

  public Triangle(int side1, int side2, int side3) {
      this.side1 = side1;
      this.side2 = side2;
      this.side3 = side3;
      this.perimeter = side1 + side2 + side3;
      double semiPerimeter = perimeter / 2;
      this.area = Math.sqrt(semiPerimeter * (semiPerimeter - side1) * 
                            (semiPerimeter - side2) * (semiPerimeter - side3));
  }

  public void print() {
      System.out.println("Triangle:");
      System.out.println("Sides: " + side1 + ", " + side2 + ", " + side3);
      System.out.println("Perimeter: " + perimeter);
      System.out.println("Area: " + area);
  }
}

class Circle {
  int radius;
  double perimeter, area;

  public Circle(int radius) {
      this.radius = radius;
      this.perimeter = 2 * Math.PI * radius;
      this.area = Math.PI * radius * radius;
  }

  public void print() {
      System.out.println("Circle:");
      System.out.println("Radius: " + radius);
      System.out.println("Circumference: " + perimeter);
      System.out.println("Area: " + area);
  }
}

public class Inheritance {
  public static void main(String[] args) {
      Rectangle myRect = new Rectangle(10, 20);
      Triangle myTri = new Triangle(10, 20, 15);
      Circle myCirc = new Circle(5);

      myRect.print();
      myTri.print();
      myCirc.print();
  }
}
