package sample.furniture.furniture;

import sample.furniture.Composite.Order;
import sample.furniture.engine.Engine;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Wardrobe")
public final class Wardrobe extends WoodenFurniture implements Order {
    private final static String TYPE = "Wardrobe";

    public Wardrobe(){
        super(TYPE, null, null);
    }

    public Wardrobe(String model, Engine engine) {
        super(TYPE, model, engine);
    }

    @Override
    public Furniture create(String furnitureModel, Engine engine) {
        return new Wardrobe(furnitureModel, engine);
    }



    @Override
    public void swim() {
        System.out.println("wardrobe wooden");
    }

    @Override
    public int getCount() {
        return 1;
    }
}
