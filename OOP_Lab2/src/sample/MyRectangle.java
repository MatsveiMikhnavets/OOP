package sample;

import javafx.scene.canvas.GraphicsContext;

import static java.lang.Math.*;

public class MyRectangle extends Square {
    private double height;

    public MyRectangle(double startX, double startY,  double endX,double endY,double thirdX,double thirdY) {
        super(startX, startY, endX,endY);
        this.height = sqrt(pow(endX-thirdX,2)+pow(endY-thirdY,2));
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void getFigure(GraphicsContext gc){
        gc.strokeRect(getStartX(),getStartY(),getWidth(),height);
    }
}
