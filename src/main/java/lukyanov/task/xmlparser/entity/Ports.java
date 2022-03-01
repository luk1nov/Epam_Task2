package lukyanov.task.xmlparser.entity;

public class Ports {
    private boolean com;
    private boolean usb;
    private boolean lpt;

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
        if (com != ports.com) return false;
        if (usb != ports.usb) return false;
        return lpt == ports.lpt;
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
