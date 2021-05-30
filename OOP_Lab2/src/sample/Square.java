package sample;

import static java.lang.Math.*;
import javafx.scene.canvas.GraphicsContext;

public class Square extends AbstractFigure {
    private double width;

    public Square(double startX, double startY, double endX,double endY) {
        super(startX, startY);
        this.width =sqrt(pow(endX-startX,2)+pow(endY-startY,2)) ;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void getFigure(GraphicsContext gc){
        gc.strokeRect(getStartX(),getStartY(),width,width);
    }

}
