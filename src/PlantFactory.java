public class PlantFaсtory {

    private static Plant getPlant(PlantSpecies species, int amount) {
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

    public static Plant 

}

class Strawberry implements Plant{
    double minSoilMoisture = 40;
    double maxSoilMoisture = 80;
    double minAirHumidity = 70;
    double maxAirHumidity = 80;

    public Strawberry() {
        Container.plantsIntoContainer.add(this);
    }
}
