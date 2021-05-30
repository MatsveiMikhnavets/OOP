package sample.furniture.furniture;

import sample.furniture.Composite.Order;
import sample.furniture.engine.Engine;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Bed")
public class Bed extends WoodenFurniture implements Order {
    private final static String TYPE = "Bed";

    public Bed(){
        super(TYPE, null, null);
    }

    public Bed(String model, Engine engine) {
        super(TYPE, model, engine);
    }

    @Override
    public Furniture create(String furnitureModel, Engine engine) {
        return new Bed(furnitureModel, engine);
    }



    @Override
    public void swim() {
        System.out.println("bed wooden");
    }

    @Override
    public int getCount() {
        return 1;
    }
}
