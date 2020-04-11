import java.util.ArrayList;
import java.util.List;

public class Container {
    private static volatile Container instance;
    private int maxCapacity;
    private double airHumidity; //уровень влажности воздуха измеряется в %, это дробное положительное число
    private int lightLevel; //уровень освещенности измеряется в люксах (лк), это целое положительное число
    public static List<Plant> plantsIntoContainer = new ArrayList<>(); //список растений, содержащихся в контейнере

    public static Container getInstance(int capacity) {
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

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public double getAirHumidity() {
        return airHumidity;
    }

    public void setAirHumidity(double airHumidity) {
        this.airHumidity = airHumidity;
    }

    public int getLightLevel() {
        return lightLevel;
    }

    public void setLightLevel(int lightLevel) {
        this.lightLevel = lightLevel;
    }
}
