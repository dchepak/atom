package ru.atom.geometry;

public class Bar implements Collider {
    private final Point p1;
    private final Point p2;

    public Bar(int x1, int y1, int x2, int y2) {
        this(new Point(x1, y1), new Point(x2, y2));
    }

    public Bar(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public boolean isColliding(Collider other) {
        if (other instanceof Point) {
            Point point = (Point) other;
            int minX = Math.min(p1.getX(), p2.getX());
            int minY = Math.min(p1.getY(), p2.getY());
            int maxX = Math.max(p1.getX(), p2.getX());
            int maxY = Math.max(p1.getY(), p2.getY());
            return
                    point.getX() >= minX && point.getX() <= maxX &&
                            point.getY() >= minY && point.getY() <= maxY;
        }
        if (other instanceof Bar) {
            int minX = Math.min(p1.getX(), p2.getX());
            int minY = Math.min(p1.getY(), p2.getY());
            int maxX = Math.max(p1.getX(), p2.getX());
            int maxY = Math.max(p1.getY(), p2.getY());

            Bar bar = (Bar) other;
            Point bp1 = bar.p1;
            Point bp2 = bar.p2;
            int min2X = Math.min(bp1.getX(), bp2.getX());
            int min2Y = Math.min(bp1.getY(), bp2.getY());
            int max2X = Math.max(bp1.getX(), bp2.getX());
            int max2Y = Math.max(bp1.getY(), bp2.getY());

            return minX <= max2X && maxX >= min2X && minY <= max2Y && maxY >= min2Y;

        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Bar bar = (Bar) obj;

        int minX = Math.min(p1.getX(), p2.getX());
        int minY = Math.min(p1.getY(), p2.getY());
        int maxX = Math.max(p1.getX(), p2.getX());
        int maxY = Math.max(p1.getY(), p2.getY());

        Point bp1 = bar.p1;
        Point bp2 = bar.p2;
        int min2X = Math.min(bp1.getX(), bp2.getX());
        int min2Y = Math.min(bp1.getY(), bp2.getY());
        int max2X = Math.max(bp1.getX(), bp2.getX());
        int max2Y = Math.max(bp1.getY(), bp2.getY());

        return (bar.p1.equals(p1) && bar.p2.equals(p2)) ||
                (minX == min2X && maxX == max2X && minY == min2Y && maxY == max2Y);
    }
}
