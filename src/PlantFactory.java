import java.util.Date;

public class PlantFactory {

    private static Plant getPlant(PlantSpecies species) {
        Plant newPlant = null;
            switch (species) {
                case STRAWBERRY:
                    newPlant = new Strawberry();
                    break;
                default:
                    throw new IllegalArgumentException("Неизвестный вид");
            }
            return newPlant;
    }

    public static void putPlantsIntoContainer(PlantSpecies species, int number) {
        for (int i = 0; i < number; i++) {
            getPlant(species);
        }
    }
}

class Strawberry implements Plant{
    String name;
    float minSoilMoisture = 40;
    float maxSoilMoisture = 80;
    float minAirHumidity = 70;
    float maxAirHumidity = 80;

    public Strawberry() {
        Container.plantsIntoContainer.add(this);
        this.name = "клубника #" + Container.plantsIntoContainer.indexOf(this);
        System.out.println(new Date() + " " + name + " помещена в контейнер!");
    }
}
