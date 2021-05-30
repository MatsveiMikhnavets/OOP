package sample;

import javafx.scene.canvas.GraphicsContext;
import static java.lang.Math.*;

public class MyEllipse extends MyCircle {
    private double radiusY;

    public MyEllipse(double startX, double startY,double endX,double endY,double thirdX,double thirdY) {
        super(startX, startY, endX,endY);
        this.radiusY = sqrt(pow(endX-thirdX,2)+pow(endY-thirdY,2));
    }

    public double getRadiusY() {
        return radiusY;
    }

    public void setRadiusY(int radiusY) {
        this.radiusY = radiusY;
    }

    @Override
    public void getFigure(GraphicsContext gc){
        gc.strokeOval(getStartX()-getRadius(),getStartY()-getRadiusY(),getRadius()*2,getRadiusY()*2);
    }
}
