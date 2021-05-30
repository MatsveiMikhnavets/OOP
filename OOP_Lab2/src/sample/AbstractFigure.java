package sample;

import javafx.scene.canvas.GraphicsContext;

public abstract class AbstractFigure {
    private double startX,startY;

    public AbstractFigure(double startX, double startY) {
        this.startX = startX;
        this.startY = startY;
    }

    public double getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public double getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public abstract void getFigure(GraphicsContext gc);
}
