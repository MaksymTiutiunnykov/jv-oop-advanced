package core.basesyntax;

import java.util.Random;

public class FigureSupplier {
    private final Random random = new Random();
    private final ColorSupplier colorSupplier = new ColorSupplier();

    public Figure getRandomFigure() {
        int typeOfFigure = random.nextInt(5);
        Color color = colorSupplier.getRandomColor();

        return switch (typeOfFigure) {
            case 0 -> new Square(color, randomSize());
            case 1 -> new Rectangle(color, randomSize(), randomSize());
            case 2 -> new RightTriangle(color, randomSize(), randomSize());
            case 3 -> new Circle(color, randomSize());
            default -> new IsoscelesTrapezoid(color, randomSize(), randomSize(), randomSize());
        };
    }

    public Figure getDefaultFigure() {
        return new Circle(Color.WHITE, 10);
    }

    private double randomSize() {
        return 1 + random.nextInt(20);
    }
}
