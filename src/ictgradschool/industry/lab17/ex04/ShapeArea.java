package ictgradschool.industry.lab17.ex04;

public class ShapeArea {

    private double Width;
    private double Height;
    private double radius;
    private double RectArea;
    private double CircleArea;
    String userinput;
    String userinput2;
    String Userinput3;


    public ShapeArea(double width, double height) {
        Width = width;
        Height = height;
    }

    public ShapeArea(double radius) {
        this.radius = radius;
    }


    public double WidthToDouble() {
        Width = Double.parseDouble(userinput);
        return Width;
    }

    public double HeightToDouble() {
        Height = Double.parseDouble(userinput2);
        return Height;
    }

    public double getRadius() {
        radius = Double.parseDouble(Userinput3);
        return radius;
    }

    public double RectArea() {
        RectArea = Width * Height;
        return RectArea;

    }

    public double CircleArea() {
        CircleArea = Math.PI * Math.pow(2, radius);
        return CircleArea;

    }

    public double CompareTo() {
        double diff = RectArea - CircleArea;
        if (diff < 0) {
            return RectArea;
        } else {
            int smallArea = (int) CircleArea;


        }
        return CircleArea;

    }
}
