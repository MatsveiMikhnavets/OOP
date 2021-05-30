package sample.furniture.furniture;

import sample.furniture.engine.Engine;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.io.*;

@XmlSeeAlso({Wardrobe.class, Table.class, Door.class, Bench.class, Bed.class, Chair.class})
public abstract class Furniture implements Serializable {
    protected String furnitureType;
    protected String furnitureModel;
    protected Engine engine;

    protected Furniture(String furnitureType, String furnitureModel, Engine engine) {
        this.furnitureType = furnitureType;
        this.furnitureModel = furnitureModel;
        this.engine = engine;
    }

    public String getXML() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Furniture.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringWriter sw = new StringWriter();
        marshaller.marshal(this, sw);
        return sw.toString();
    }


    public abstract Furniture create(String vehicleModel, Engine engine);

    public String getFurnitureType() {
        return furnitureType;
    }

    public String getFurnitureModel() {
        return furnitureModel;
    }

    public void setFurnitureType(String furnitureType) {
        this.furnitureType = furnitureType;
    }

    public void setFurnitureModel(String furnitureModel) {
        this.furnitureModel = furnitureModel;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getWarranty() {
        if (engine != null)
            return engine.getSpeed();
        return "1 year";
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
