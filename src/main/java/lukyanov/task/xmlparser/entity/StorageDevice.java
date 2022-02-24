package lukyanov.task.xmlparser.entity;

import java.util.Objects;

public class StorageDevice extends Device{
    private int storageCapacity;
    private int writeSpeed;
    private int readingSpeed;

    public StorageDevice() {
        super();
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
        StorageDevice that = (StorageDevice) o;
        return storageCapacity == that.storageCapacity && writeSpeed == that.writeSpeed && readingSpeed == that.readingSpeed;
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
}
