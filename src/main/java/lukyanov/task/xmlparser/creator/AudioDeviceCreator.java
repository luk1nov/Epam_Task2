package lukyanov.task.xmlparser.creator;

import lukyanov.task.xmlparser.entity.AudioDevice;
import lukyanov.task.xmlparser.entity.Brand;
import lukyanov.task.xmlparser.entity.DeviceType;
import lukyanov.task.xmlparser.entity.Ports;

import java.time.LocalDate;

public class AudioDeviceCreator {

    public static AudioDevice createAudioDevice(){
        Ports ports = new Ports(false, true, false);
        DeviceType deviceType = new DeviceType(true, 3, false, ports);
        return new AudioDevice.AudioDeviceBuilder()
                .deviceId("a3")
                .title("headphones logitech")
                .name("Headphones")
                .brand(Brand.LOGITECH.getBrand())
                .price(89.99)
                .type(deviceType)
                .critical(false)
                .warranty(LocalDate.parse("2023-03-01"))
                .wireless(true)
                .surround("7.1")
                .build();
    }
}
