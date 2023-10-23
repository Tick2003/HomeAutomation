// Device interface representing common functionality for all devices
interface Device {
    void turnOn();
    void turnOff();
    boolean isOn();
}

// Light class implementing the Device interface
class Light implements Device {
    private boolean isOn;

    public Light() {
        isOn = false; // Light is initially off
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Light is ON");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Light is OFF");
    }

    @Override
    public boolean isOn() {
        return isOn;
    }
}

// HomeAutomationController class to manage multiple devices
class HomeAutomationController {
    private Device[] devices;

    public HomeAutomationController(int numberOfDevices) {
        devices = new Device[numberOfDevices];
    }

    public void addDevice(Device device, int index) {
        if (index >= 0 && index < devices.length) {
            devices[index] = device;
        } else {
            System.out.println("Invalid device index");
        }
    }

    public void controlDevice(int deviceIndex, String action) {
        if (deviceIndex >= 0 && deviceIndex < devices.length) {
            Device device = devices[deviceIndex];
            if (action.equalsIgnoreCase("on")) {
                device.turnOn();
            } else if (action.equalsIgnoreCase("off")) {
                device.turnOff();
            } else {
                System.out.println("Invalid action");
            }
        } else {
            System.out.println("Invalid device index");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        HomeAutomationController controller = new HomeAutomationController(1);

        // Create a new Light and add it to the controller
        Light livingRoomLight = new Light();
        controller.addDevice(livingRoomLight, 0);

        // Control the light
        controller.controlDevice(0, "on");
        controller.controlDevice(0, "off");
    }
}
