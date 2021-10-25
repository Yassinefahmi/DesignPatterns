package nl.designpattern.bridge;

public class RemoteControl
{
    protected final Device device;

    public RemoteControl(Device device)
    {
        this.device = device;
    }

    public void turnOn()
    {
        device.turnOn();
    }

    public void turnOff()
    {
        device.turnOff();
    }
}
