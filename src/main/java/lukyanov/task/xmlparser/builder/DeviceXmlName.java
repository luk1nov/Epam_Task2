package lukyanov.task.xmlparser.builder;

public enum DeviceXmlName {
    NAME,
    ORIGIN,
    PRICE,
    TYPE,
    PERIPHERAL,
    POWER_USAGE,
    COOLER,
    PORTS,
    COM,
    USB,
    LPT,
    CRITICAL,
    DEVICE_ID,
    TITLE,
    STORAGE_DEVICE_PARAMETERS,
    STORAGE_CAPACITY,
    WRITE_SPEED,
    READING_SPEED,
    AUDIO_DEVICE_PARAMETERS,
    WIRELESS,
    SURROUND;

    private static final char UNDERSCORE = '_';
    private static final char HYPHEN = '-';

    public String getTagName(){
        String tagName = this.name();
        tagName = tagName.toLowerCase();
        tagName = tagName.replace(UNDERSCORE, HYPHEN);
        return tagName;
    }

}
