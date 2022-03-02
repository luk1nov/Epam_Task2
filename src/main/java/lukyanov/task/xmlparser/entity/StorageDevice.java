package lukyanov.task.xmlparser.entity;

public class StorageDevice extends Device{
    private int storageCapacity;
    private int writeSpeed;
    private int readingSpeed;

    public StorageDevice() {
        super();
    }

    public StorageDevice(StorageDeviceBuilder builder){
        super(builder.deviceId, builder.title, builder.name, builder.brand, builder.price, builder.type, builder.critical, builder.warranty);
        this.storageCapacity = builder.storageCapacity;
        this.writeSpeed = builder.writeSpeed;
        this.readingSpeed = builder.readingSpeed;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    public int getWriteSpeed() {
        return writeSpeed;
    }

    public void setWriteSpeed(int writeSpeed) {
        this.writeSpeed = writeSpeed;
    }

    public int getReadingSpeed() {
        return readingSpeed;
    }

    public void setReadingSpeed(int readingSpeed) {
        this.readingSpeed = readingSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StorageDevice that = (StorageDevice) o;
        if (storageCapacity != that.storageCapacity) return false;
        if (writeSpeed != that.writeSpeed) return false;
        return readingSpeed == that.readingSpeed;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 17 * result + storageCapacity;
        result = 17 * result + writeSpeed;
        result = 17 * result + readingSpeed;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StorageDevice{");
        sb.append(super.toString());
        sb.append(", storageCapacity=").append(storageCapacity);
        sb.append(", writeSpeed=").append(writeSpeed);
        sb.append(", readingSpeed=").append(readingSpeed);
        sb.append('}');
        return sb.toString();
    }

    public static class StorageDeviceBuilder extends Device.DeviceBuilder<StorageDeviceBuilder>{
        private int storageCapacity;
        private int writeSpeed;
        private int readingSpeed;

        public StorageDeviceBuilder(){
        }

        public StorageDeviceBuilder storageCapacity(int storageCapacity){
            this.storageCapacity = storageCapacity;
            return this;
        }

        public StorageDeviceBuilder writeSpeed(int writeSpeed){
            this.writeSpeed = writeSpeed;
            return this;
        }

        public StorageDeviceBuilder readingSpeed(int readingSpeed){
            this.readingSpeed = readingSpeed;
            return this;
        }

        @Override
        public StorageDevice build(){
            return new StorageDevice(this);
        }
    }
}
