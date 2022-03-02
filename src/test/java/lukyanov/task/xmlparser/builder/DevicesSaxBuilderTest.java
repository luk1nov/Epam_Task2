package lukyanov.task.xmlparser.builder;

import lukyanov.task.xmlparser.creator.AudioDeviceCreator;
import lukyanov.task.xmlparser.creator.StorageDeviceCreator;
import lukyanov.task.xmlparser.entity.*;
import lukyanov.task.xmlparser.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DevicesSaxBuilderTest {
    private static final Logger logger = LogManager.getLogger();
    private static final DevicesSaxBuilder saxBuilder = new DevicesSaxBuilder();
    private static final String PATH = "src/test/resources/data/devices_valid.xml";
    private static Set<Device> devices;

    @BeforeAll
    public static void beforeAll() {
        try {
            saxBuilder.buildSetDevices(PATH);
            devices = saxBuilder.getDeviceSet();
        } catch (CustomException e) {
           logger.error(e.getMessage());
        }
    }

    @Test
    void buildSetDevicesAudio() {
        Device expectedDevice = AudioDeviceCreator.createAudioDevice();
        logger.debug(devices);
        assertTrue(devices.contains(expectedDevice));
    }

    @Test
    void buildSetDevicesStorage() {
        Device expectedDevice = StorageDeviceCreator.createStorageDevice();
        assertTrue(devices.contains(expectedDevice));
    }

}