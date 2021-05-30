package sample;

import java.net.URL;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Canvas canvas;

    @FXML
    private Button buttonLine;

    @FXML
    private Button resetButton;

    @FXML
    private Button circleButton;

    @FXML
    private Button ellipseButton;

    @FXML
    private Button rectangleButton;

    @FXML
    private Button squareButton;

    @FXML
    private Button triangleButton;

    @FXML
    private Button cursorButton;

    @FXML
    private Button brokenLineButton;

    private void reset(GraphicsContext gc, Canvas canvas) {
        canvas.removeEventHandler(MouseEvent.MOUSE_PRESSED, handler);
        clear();
        i = 0;
        gc.setFill(new Color(0.8, 0.8, 0.8, 1));
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    private void clear() {
        X.clear();
        Y.clear();
    }

    private EventHandler<MouseEvent> handler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {

        }
    };

    private Queue<Double> X = new LinkedList<>();
    private Queue<Double> Y = new LinkedList<>();
    private int i = 0;

    @FXML
    void initialize() {


        GraphicsContext gc = canvas.getGraphicsContext2D();
        reset(gc, canvas);

        resetButton.setOnAction(event -> reset(gc, canvas));

        cursorButton.setOnAction(event -> {
            canvas.removeEventHandler(MouseEvent.MOUSE_PRESSED, handler);
            clear();
        });

        circleButton.setOnAction(event -> {

            handler = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    getPoints(gc, X, Y, e);
                    if (X.size() == 2) {
                        draw(gc, new MyCircle(X.poll(), Y.poll(), X.poll(), Y.poll()));
                    }
                }
            };
            canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, handler);
        });

        ellipseButton.setOnAction(event -> {
            canvas.removeEventHandler(MouseEvent.MOUSE_PRESSED, handler);
            clear();
            handler = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    getPoints(gc, X, Y, e);
                    if (X.size() == 3) {
                        draw(gc, new MyEllipse(X.poll(), Y.poll(), X.poll(), Y.poll(), X.poll(), Y.poll()));
                    }
                }
            };
            canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, handler);
        });

        squareButton.setOnAction(event -> {
            canvas.removeEventHandler(MouseEvent.MOUSE_PRESSED, handler);
            clear();
            handler = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    getPoints(gc, X, Y, e);
                    if (X.size() == 2) {
                        draw(gc, new Square(X.poll(), Y.poll(), X.poll(), Y.poll()));
                    }
                }
            };
            canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, handler);
        });

        rectangleButton.setOnAction(event -> {
            canvas.removeEventHandler(MouseEvent.MOUSE_PRESSED, handler);
            clear();
            handler = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    getPoints(gc, X, Y, e);
                    if (X.size() == 3) {
                        draw(gc, new MyRectangle(X.poll(), Y.poll(), X.poll(), Y.poll(), X.poll(), Y.poll()));
                    }
                }
            };
            canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, handler);
        });

        triangleButton.setOnAction(event -> {
            canvas.removeEventHandler(MouseEvent.MOUSE_PRESSED, handler);
            clear();
            handler = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    getPoints(gc, X, Y, e);
                    if (X.size() == 3) {
                        draw(gc, new Triangle(X.poll(), Y.poll(), X.poll().intValue(), Y.poll(), X.poll(), Y.poll()));
                    }
                }
            };
            canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, handler);
        });

        buttonLine.setOnAction(event -> {
            clear();
            canvas.removeEventHandler(MouseEvent.MOUSE_PRESSED, handler);
            handler = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    getPoints(gc, X, Y, e);
                    if (X.size() == 2) {
                        draw(gc, new MyLine(X.poll(), Y.poll(), X.poll(), Y.poll()));
                    }
                }
            };
            canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, handler);
        });

        brokenLineButton.setOnAction(event -> {
            clear();
            canvas.removeEventHandler(MouseEvent.MOUSE_PRESSED, handler);
            handler = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    getPoints(gc, X, Y, e);
                    if (X.size() == 2) {
                            MyLine line = new MyLine(X.poll(), Y.poll(), X.peek(), Y.peek());
                            line.getFigure(gc);
                    }
                }
            };
            canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, handler);
        });
    }

    private void draw(GraphicsContext gc, AbstractFigure figure) {
        figure.getFigure(gc);
        canvas.removeEventHandler(MouseEvent.MOUSE_PRESSED, handler);
    }

    private void getPoints(GraphicsContext gc, Queue<Double> X, Queue<Double> Y, MouseEvent e) {
        gc.clearRect(e.getX() - 2, e.getY() - 2, 4, 4);
        X.add(e.getX());
        Y.add(e.getY());
    }

}

