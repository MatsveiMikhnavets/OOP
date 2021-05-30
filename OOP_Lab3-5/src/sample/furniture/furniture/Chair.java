package sample.furniture.furniture;

import sample.furniture.Composite.Order;
import sample.furniture.engine.Engine;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Chair")
public final class Chair extends GlassFurniture implements Order {
    private final static String TYPE = "Chair";

    public Chair(){
        super(TYPE, null, null);
    }

    public Chair(String model, Engine engine) {
        super(TYPE, model, engine);
    }

    @Override
    public Furniture create(String furnitureModel, Engine engine) {
        return new Chair(furnitureModel, engine);
    }



    @Override
    public void go() {
        System.out.println("chair glass");
    }

    @Override
    public int getCount() {
        return 1;
    }
}
