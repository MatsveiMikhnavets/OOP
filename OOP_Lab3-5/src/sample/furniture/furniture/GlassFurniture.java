package sample.furniture.furniture;

import sample.furniture.engine.Engine;

public abstract class GlassFurniture extends Furniture {
    enum DRIVE_UNIT{FRONT_WHEEL, REAR_WHEEL}
    protected DRIVE_UNIT driveUnit;

    protected GlassFurniture(String furnitureType, String furnitureModel, Engine engine) {
        super(furnitureType, furnitureModel, engine);
    }

    public DRIVE_UNIT getDriveUnit() {
        return driveUnit;
    }

    public void setDriveUnit(DRIVE_UNIT driveUnit) {
        this.driveUnit = driveUnit;
    }

    public abstract void go();
}
