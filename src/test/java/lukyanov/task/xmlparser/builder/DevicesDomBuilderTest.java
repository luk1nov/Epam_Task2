package lukyanov.task.xmlparser.builder;

import lukyanov.task.xmlparser.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DevicesDomBuilderTest {
    private static final Logger logger = LogManager.getLogger();
    private static final DevicesDomBuilder domBuilder = new DevicesDomBuilder();
    private static final String PATH = "resources/data/devices.xml";

    @Test
    void buildSetDevices() {
        domBuilder.buildSetDevices(PATH);
        Set<Device> devices = domBuilder.getDeviceSet();

        AudioDevice expectedDevice = new AudioDevice();
        expectedDevice.setDeviceId("a3");
        expectedDevice.setTitle("headphones logitech");
        expectedDevice.setName("Headphones");
        expectedDevice.setBrand(Brand.LOGITECH.getBrand());
        expectedDevice.setPrice(89.99);
        DeviceType deviceType = expectedDevice.getType();
        deviceType.setPeripheral(true);
        deviceType.setPowerUsage(3);
        deviceType.setCooler(false);
        Ports ports = deviceType.getPorts();
        ports.setCom(false);
        ports.setUsb(true);
        ports.setLpt(false);
        expectedDevice.setCritical(false);
        expectedDevice.setWarranty(LocalDate.parse("2023-03-01"));
        expectedDevice.setWireless(true);
        expectedDevice.setSurround("7.1");

        assertTrue(devices.contains(expectedDevice));
    }
}