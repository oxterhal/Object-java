class Triangle {
    private int a, b, c;
    private double area, perimeter;

    public Triangle(int side1, int side2, int side3) {
        a = side1;
        b = side2;
        c = side3;
    }

    public boolean isTri() {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    public void calculate() {
        if (isTri()) {
            perimeter = a + b + c;
            double s = perimeter / 2.0;
            area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
            
            System.out.println("Area: " + area);
            System.out.println("Perimeter: " + perimeter);
        } else {
            System.out.println("Not a valid triangle");
        }
    }

    public static void main(String[] args) {
        Triangle tri = new Triangle(3, 4, 5);
        tri.calculate();
    }
}