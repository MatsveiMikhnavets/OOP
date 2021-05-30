package sample;

import javafx.scene.canvas.GraphicsContext;

public class MyLine extends AbstractFigure{
    private double endX,endY;

    public double getEndX() {
        return endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public double getEndY() {
        return endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    @Override
    public void getFigure(GraphicsContext gc){
        gc.strokeLine(getStartX(),getStartY(),getEndX(),getEndY());
    }

    public MyLine(double startX,double startY,double endX,double endY){
        super(startX,startY);
        this.endX=endX;
        this.endY=endY;
    }
}
