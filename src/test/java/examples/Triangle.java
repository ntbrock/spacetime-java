package examples;

public class Triangle {

    private int a, b, c;

    public Triangle( int lengthSideA , int lengthSideB , int lengthSideC ) {
        a = lengthSideA;
        b = lengthSideB;
        c = lengthSideC;
    }

    public boolean isValid() {
        return a > 0 && b > 0 && c > 0;
    }
}
