package lukyanov.task.xmlparser.builder;

public enum DeviceXmlTag {
    DEVICES,
    NAME,
    BRAND,
    PRICE,
    PERIPHERAL,
    POWER_USAGE,
    COOLER,
    PORTS,
    COM,
    USB,
    LPT,
    CRITICAL,
    WARRANTY,
    STORAGE_CAPACITY,
    WRITE_SPEED,
    READING_SPEED,
    WIRELESS,
    SURROUND,
    TYPE,
    DEVICE_ID,
    TITLE,
    STORAGE_DEVICE,
    AUDIO_DEVICE;

    private static final char UNDERSCORE = '_';
    private static final char HYPHEN = '-';

    public String getTagName(){
        String tagName = this.name();
        tagName = tagName.toLowerCase();
        tagName = tagName.replace(UNDERSCORE, HYPHEN);
        return tagName;
    }

}
