public class LEDLightBulb implements Switchable {
    @Override
    public void turnOn() {
        System.out.println("LED LightBulb turned on (energy-saving)");
    }

    @Override
    public void turnOff() {
        System.out.println("LED LightBulb turned off");
    }
}
