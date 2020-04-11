import java.util.Date;

public class Device implements Runnable {
    volatile static boolean isStarted = false;
    volatile static boolean isTimeToSpraying = false;
    volatile static int currentAirHumidity;

    @Override
    public void run() { }
    public static void on() {
        System.out.println(new Date() + " Все девайсы запущены");
        isStarted = true;
    }
    public static void off() {
        System.out.println(new Date() + " Все девайсы отключены");
        isStarted = false;
    }

    static class AirHumiditySensor extends Device {

        public AirHumiditySensor() {
            Thread threadAHS = new Thread(this);
            threadAHS.start();
        }
        @Override
        public void run() {
            while (isStarted) {
                currentAirHumidity = AirHumiditySimulation.getCurrentAirHumidity();
                System.out.println(new Date() + " Влажность воздуха в контейнере: " + currentAirHumidity + "%");
                if (!isTimeToSpraying && currentAirHumidity <= Requirements.minAirHumidity) {
                    System.out.println(new Date() + " Внимание! Низкий уровень влажности!");
                    isTimeToSpraying = true;
                    new Humidifier();
                }
                if (isTimeToSpraying && currentAirHumidity >= Requirements.maxAirHumidity) {
                    System.out.println(new Date() + " Уровень влажности нормализован");
                    isTimeToSpraying = false;
                    System.out.println(new Date() + " Увлажнитель отключен");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    class Humidifier extends Device {

        public Humidifier() {
            Thread threadH = new Thread(this);
            threadH.start();
            System.out.println(new Date() + " Увлажнитель запущен!");
        }

        @Override
        public void run() {
            while (isTimeToSpraying) {
                if (currentAirHumidity < Requirements.maxAirHumidity) {
                    currentAirHumidity++;
                    AirHumiditySimulation.setCurrentAirHumidity(currentAirHumidity);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    //isTimeToSpraying = false;
            }

            }
        }
    }
}
