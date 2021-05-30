package sample;

import static  java.lang.Math.*;
import javafx.scene.canvas.GraphicsContext;

public class MyCircle extends AbstractFigure{
    private double radius;

    public MyCircle(double startX, double startY, double endX,double endY) {
        super(startX, startY);
        this.radius = sqrt(pow(startX-endX,2)+pow(startY-endY,2));
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void getFigure(GraphicsContext gc){
        gc.strokeOval(getStartX()-radius,getStartY()-radius,radius*2,radius*2);
    }
}
