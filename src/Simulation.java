import org.w3c.dom.ls.LSOutput;

import java.util.Date;

public abstract class Simulation implements Runnable {
    private static boolean isGoing = false;
    private static int defaultAirHumidity = 80;

    public static void go() {
        isGoing = true;
        Thread threadAHSim = new Thread(new AirHumiditySimulation());
        threadAHSim.start();
        System.out.println(new Date() + " Симуляция запущена");
    }

    public static void off() {
        isGoing = false;
        System.out.println(new Date() + " Симуляция отключена");
    }

    public static boolean getIsGoing() {
        return isGoing;
    }

    public static int getDefaultAirHumidity() {
        return defaultAirHumidity;
    }
}

class AirHumiditySimulation extends Simulation {
    private static volatile int currentAirHumidity = getDefaultAirHumidity();
    private boolean isGoing = getIsGoing();

    public static int getCurrentAirHumidity() {
        return currentAirHumidity;
    }

    public static void setCurrentAirHumidity(int currentAirHumidity) {
        AirHumiditySimulation.currentAirHumidity = currentAirHumidity;
    }

    @Override
    public void run() {
        while (isGoing) {
            currentAirHumidity--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
