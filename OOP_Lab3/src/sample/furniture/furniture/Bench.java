package sample.furniture.furniture;
import sample.furniture.Composite.Order;
import sample.furniture.engine.Engine;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Bench")
public final class Bench extends MetalFurniture implements Order {
    private final static String TYPE = "Bench";

    public Bench(){
        super(TYPE, null, null);
    }

    public Bench(String model, Engine engine) {
        super(TYPE, model, engine);
    }

    @Override
    public Furniture create(String furnitureModel, Engine engine) {
        return new Bench(furnitureModel, engine);
    }



    @Override
    public void fly() {
        System.out.println("bench metal");
    }

    @Override
    public int getCount() {
        return 1;
    }
}
