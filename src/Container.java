import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Container implements Requirements{
    private static volatile Container instance;
    private int maxCapacity;
    //уровень влажности воздуха измеряется в %, это дробное положительное число
    private float currentAirHumidity = AirHumiditySimulation.getCurrentAirHumidity();
    //уровень освещенности измеряется в люксах (лк), это целое положительное число
    private int currentLightLevel;
    //список растений, содержащихся в контейнере
    public static List<Plant> plantsIntoContainer = new ArrayList<>();

    private static Container getInstance(int capacity) {
        Container localInstance = instance;
        if (localInstance == null) {
            synchronized (Container.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Container(capacity);
                }
            }
        }
        return localInstance;
    }

    private Container(int capacity) {
        this.maxCapacity = capacity;
    }

    public static void createContainer(int capacity) {
        getInstance(capacity);
        System.out.println(new Date() + " Вы видите контейнер. Давайте поместим в него растения!");
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public float getAirHumidity() {
        return currentAirHumidity;
    }

    public void setAirHumidity(float airHumidity) {
        this.currentAirHumidity = airHumidity;
    }

    public int getLightLevel() {
        return currentLightLevel;
    }

    public void setLightLevel(int lightLevel) {
        this.currentLightLevel = lightLevel;
    }
}
