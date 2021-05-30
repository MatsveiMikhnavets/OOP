package sample.furniture.furniture;

import sample.furniture.engine.Engine;

public abstract class MetalFurniture extends Furniture {
    protected int flightAltitude;

    protected MetalFurniture(String furnitureType, String furnitureModel, Engine engine) {
        super(furnitureType, furnitureModel, engine);
    }

    public int getFlightAltitude() {
        return flightAltitude;
    }

    public void setFlightAltitude(int flightAltitude) {
        this.flightAltitude = flightAltitude;
    }

    public abstract void fly();
}
