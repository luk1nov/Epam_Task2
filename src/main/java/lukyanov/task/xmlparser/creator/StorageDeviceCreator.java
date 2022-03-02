package lukyanov.task.xmlparser.creator;

import lukyanov.task.xmlparser.entity.*;

import java.time.LocalDate;

public class StorageDeviceCreator {
    public static StorageDevice createStorageDevice(){
        Ports ports = new Ports(false, false, true);
        DeviceType deviceType = new DeviceType(false, 15, false, ports);
        return new StorageDevice.StorageDeviceBuilder()
                .deviceId("s3")
                .title("hdd western-digital")
                .name("HDD")
                .brand(Brand.WD.getBrand())
                .price(1449.0)
                .type(deviceType)
                .critical(false)
                .warranty(LocalDate.parse("2023-01-01"))
                .storageCapacity(512)
                .writeSpeed(2000)
                .readingSpeed(1700)
                .build();

    }
}
