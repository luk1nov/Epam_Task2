package lukyanov.task.xmlparser.builder;

public enum DeviceXmlTag {
    NAME,
    BRAND,
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
    STORAGE_CAPACITY,
    WRITE_SPEED,
    READING_SPEED,
    WIRELESS,
    SURROUND,
    DEVICE_ID,
    TITLE,;

    private static final char UNDERSCORE = '_';
    private static final char HYPHEN = '-';

    public String getTagName(){
        String tagName = this.name();
        tagName = tagName.toLowerCase();
        tagName = tagName.replace(UNDERSCORE, HYPHEN);
        return tagName;
    }

}
