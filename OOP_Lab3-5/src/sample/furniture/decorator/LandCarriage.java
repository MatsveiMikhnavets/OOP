package sample.furniture.decorator;

public class LandCarriage implements CarriageBaggage {

    @Override
    public void carriage() {
        System.out.println("Land transport carries baggage");
    }
}
