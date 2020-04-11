public class Main {
    public static void main(String[] args) throws InterruptedException {
        Container.createContainer(10);
        PlantFactory.putPlantsIntoContainer(PlantSpecies.STRAWBERRY, 5);
        Simulation.go();
        Device.on();
        new Device.AirHumiditySensor();
        Thread.sleep(60000);
        Device.off();
        Simulation.off();
    }
}
