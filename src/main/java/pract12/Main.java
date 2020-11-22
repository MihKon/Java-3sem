package pract12;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        for (TestEnum e : TestEnum.values()) {
            printColorText(e);
        }
    }

    public static void printColorText(TestEnum testEnum) {
        switch (testEnum) {
            case RED:
                testEnum.printText("THIS IS RED", testEnum);
                break;
            case BLUE:
                testEnum.printText("THIS IS BLUE", testEnum);
                break;
            case BLACK:
                testEnum.printText("THIS IS BLACK", testEnum);
                break;
            case GREEN:
                testEnum.printText("THIS IS GREEN", testEnum);
                break;
            case MAGENTA:
                testEnum.printText("THIS IS PURPLE", testEnum);
                break;
            case YELLOW:
                testEnum.printText("THIS IS YELLOW", testEnum);
                break;
            case WHITE:
                testEnum.printText("THIS IS WHITE", testEnum);
                break;
            case TRON:
                testEnum.printText("THIS IS TRON. THE SYSTEM IS WAITING YOU.", testEnum);
                break;
            case USSR:
                testEnum.printText("SOVIET UNION", testEnum);
                break;
        }
    }
}
