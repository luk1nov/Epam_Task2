package lukyanov.task.xmlparser.entity;

import java.util.Objects;

public class AudioDevice extends Device{
    private String surround;
    private boolean wireless;

    public AudioDevice() {
        super();
    }

    public String getSurround() {
        return surround;
    }

    public void setSurround(String surround) {
        this.surround = surround;
    }

    public boolean isWireless() {
        return wireless;
    }

    public void setWireless(boolean wireless) {
        this.wireless = wireless;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AudioDevice that = (AudioDevice) o;
        return wireless == that.wireless && surround.equals(that.surround);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 17 * result + Objects.hash(surround);
        result = 17 * result + (wireless ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AudioDevice{");
        sb.append(super.toString());
        sb.append(", surround=").append(surround);
        sb.append(", wireless=").append(wireless);
        sb.append('}');
        return sb.toString();
    }
}
