public class Switch {
    private Switchable device;

    public Switch(Switchable device) {
        this.device = device;
    }

    public void operate() {
        device.turnOn();
    }

    public void shutDown() {
        device.turnOff();
    }

    public static void main(String[] args) {
        Switch normalSwitch = new Switch(new LightBulb());
        normalSwitch.operate();
        normalSwitch.shutDown();

        Switch ledSwitch = new Switch(new LEDLightBulb());
        ledSwitch.operate();
        ledSwitch.shutDown();
    }
}
