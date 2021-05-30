package sample;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Polygon;

public class Triangle extends MyLine{
    private double x3,y3;

    public Triangle(double startX, double startY, double endX, double endY, double x3, double y3) {
        super(startX, startY, endX, endY);
        this.x3 = x3;
        this.y3 = y3;
    }

    public double getX3() {
        return x3;
    }

    public void setX3(int x3) {
        this.x3 = x3;
    }

    public double getY3() {
        return y3;
    }

    public void setY3(int y3) {
        this.y3 = y3;
    }

    @Override
    public void getFigure(GraphicsContext gc){
        gc.strokePolygon(new double[]{(double)getStartX(),(double)getEndX(),getX3()},
                        new double[]{(double)getStartY(),(double)getEndY(),getY3()},
                   3  );
    }
}
