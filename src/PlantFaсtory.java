public class PlantFaсtory {

    public Plant getPlant(PlantSpecies species, int amount) {
        Plant newPlant = null;
        for (int i = 0; i < amount; i++) {
            switch (species) {
                case STRAWBERRY:
                    newPlant = new Strawberry();
                    break;
                default:
                    throw new IllegalArgumentException("Неизвестный вид");
            }
        }
            return newPlant;
    }

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
