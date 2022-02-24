package lukyanov.task.xmlparser.entity;

public class Ports {
    boolean com;
    boolean usb;
    boolean lpt;

    public Ports() {
    }

    public boolean isCom() {
        return com;
    }

    public void setCom(boolean com) {
        this.com = com;
    }

    public boolean isUsb() {
        return usb;
    }

    public void setUsb(boolean usb) {
        this.usb = usb;
    }

    public boolean isLpt() {
        return lpt;
    }

    public void setLpt(boolean lpt) {
        this.lpt = lpt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ports ports = (Ports) o;
        return com == ports.com && usb == ports.usb && lpt == ports.lpt;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (com ? 1 : 0);
        result = 31 * result + (usb ? 1 : 0);
        result = 31 * result + (lpt ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ports{");
        sb.append("com=").append(com);
        sb.append(", usb=").append(usb);
        sb.append(", lpt=").append(lpt);
        sb.append('}');
        return sb.toString();
    }
}