package lukyanov.task.xmlparser.factory;

import lukyanov.task.xmlparser.builder.*;


public class DeviceBuilderFactory {

    private enum TypeParser{
        SAX,
        STAX,
        DOM
    }

    private DeviceBuilderFactory(){
    }

    public static AbstractDeviceBuilder createDeviceBuilder(String typeParser){
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM -> {
                return new DevicesDomBuilder();
            }
            case STAX -> {
                return new DevicesStaxBuilder();
            }
            case SAX -> {
                return new DevicesSaxBuilder();
            }
            default -> throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());

        }
    }


}
