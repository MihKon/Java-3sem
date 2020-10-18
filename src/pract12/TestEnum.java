package pract12;

public enum TestEnum {
    RED("\u001B[38;2;255;0;0;1m"),
    BLUE("\u001B[38;2;0;55;218;1m"),
    BLACK("\u001B[38;2;0;0;0;1m"),
    WHITE("\u001B[38;2;255;255;255;1m"),
    YELLOW("\u001B[38;2;229;229;16;1m"),
    GREEN("\u001B[38;2;19;161;14;1m"),
    MAGENTA("\u001B[38;2;205;0;205;1m"),
    USSR("\u001B[93;1;48;2;255;0;0m"),
    TRON("\u001B[96;1;4;48;2;0;0;0m");

    private final String color;

    TestEnum(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void printText(String text, TestEnum testEnum) {
        System.out.println(testEnum.getColor() + text);
    }
}
