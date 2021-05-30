package sample.furniture.furniture;
import sample.furniture.engine.Engine;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Door")
public final class Door extends MetalFurniture {
    private final static String TYPE = "Door";

    public Door() {
        super(TYPE, null, null);
    }

    public Door(String model, Engine engine) {
        super(TYPE, model, engine);
    }

    @Override
    public Furniture create(String furnitureModel, Engine engine) {
        return new Door(furnitureModel, engine);
    }



    @Override
    public void fly() {
        System.out.println("door metal");
    }
}
