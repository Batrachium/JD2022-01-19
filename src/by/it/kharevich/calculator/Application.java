package by.it.kharevich.calculator;

import java.util.Scanner;

public class Application {

    public static final String END = "end";
    private final Printer printer;
    private final Parser parser;

    public Application(Printer printer, Parser parser) {
        this.printer = printer;
        this.parser = parser;
    }

    public void run() {
        System.out.println("App started");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            if (!line.equals(END)) {
                try {
                    Var result = parser.calc(line);
                    printer.print(result);
                } catch (CalcException e) {
                    printer.print(e);
                }
            } else {
                System.out.println("App finished");
                break;
            }
        }
    }
}
