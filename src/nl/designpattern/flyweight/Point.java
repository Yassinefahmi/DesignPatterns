package nl.designpattern.flyweight;

public class Point
{
    private final int x;
    private final int y;
    private final PointIcon pointIcon;

    public Point(int x, int y, PointIcon pointIcon)
    {
        this.x = x;
        this.y = y;
        this.pointIcon = pointIcon;
    }

    public void draw()
    {
        System.out.printf("%s at (%d, %d)", pointIcon.getPointType(), x, y);
    }
}
