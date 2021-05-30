package sample.furniture.furniture;
import sample.furniture.engine.Engine;

public abstract class WoodenFurniture extends Furniture {
    protected int displacement;

    protected WoodenFurniture(String furnitureType, String furnitureModel, Engine engine) {
        super(furnitureType, furnitureModel, engine);
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public abstract void swim();
}
