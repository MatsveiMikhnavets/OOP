package sample.furniture.furniture;

import sample.furniture.Composite.Order;
import sample.furniture.engine.Engine;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Table")
public final class Table extends GlassFurniture implements Order {
    private final static String TYPE = "Table";

    public Table(){
        super(TYPE, null, null);
    }

    public Table(String model, Engine engine) {
        super(TYPE, model, engine);
    }

    @Override
    public Furniture create(String vehicleModel, Engine engine) {
        return new Table(vehicleModel, engine);
    }



    @Override
    public void go() {
        System.out.println("table glass");

    }

    @Override
    public int getCount() {
        return 1;
    }
}
