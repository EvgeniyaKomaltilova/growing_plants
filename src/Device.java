public abstract class Device implements Runnable {
    boolean isStarted = false;

    public abstract void on();

    public abstract void off();

    class AirHumiditySensor extends Device {
        boolean isTimeToSpraying = false;
        double currentAirHumidity = AirHumiditySimulation.getCurrentAirHumidity();

        @Override
        public void run() {
            while (isStarted) {
                if (currentAirHumidity < Requirements.minAirHumidity) {
                    isTimeToSpraying = true;
                }
            }
        }

        @Override
        public void on() {
            Thread threadAHS = new Thread(new AirHumiditySensor());
            threadAHS.start();
            isStarted = true;
        }

        @Override
        public void off() {
            isStarted = false;
        }
    }

    class Himidifier extends Device {
        @Override
        public void on() {

        }

        @Override
        public void off() {

        }

        @Override
        public void run() {

        }
    }
}
