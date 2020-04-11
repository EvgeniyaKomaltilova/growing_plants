public abstract class Simulation implements Runnable {
    private static boolean isGoing = false;
    private static double defaultAirHumidity = 80;

    public static void go() {
        Thread threadAHSim = new Thread(new AirHumiditySimulation());
        threadAHSim.start();
        isGoing = true;
    }

    public static void off() {
        isGoing = false;
    }

    public static boolean getIsGoing() {
        return isGoing;
    }

    public static double getDefaultAirHumidity() {
        return defaultAirHumidity;
    }
}

class AirHumiditySimulation extends Simulation {
    private static double currentAirHumidity = getDefaultAirHumidity();
    private boolean isGoing = getIsGoing();

    public static double getCurrentAirHumidity() {
        return currentAirHumidity;
    }

    @Override
    public void run() {
        while (isGoing) {
            currentAirHumidity--;
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
