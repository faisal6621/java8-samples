package github.faisal6621.design.patterns.factory;

import java.util.function.Consumer;

import github.faisal6621.bean.Rectangle;
import github.faisal6621.bean.Shape;
import github.faisal6621.bean.Triangle;
import github.faisal6621.design.patterns.builder.Builder;
import github.faisal6621.design.patterns.registry.Registry;
import github.faisal6621.enums.ShapeEnum;

/**
 * PlayWithRegistryBuilder
 */
public class PlayWithRegistryBuilder {

    public static void main(String[] args) {
        Consumer<Builder<Shape>> rectangleConsumer = (builder) -> builder.register(ShapeEnum.RECTANGLE, Rectangle::new);
        Consumer<Builder<Shape>> triangleConsumer = (builder) -> builder.register(ShapeEnum.TRIANGLE, Triangle::new);
        Consumer<Builder<Shape>> initializer = rectangleConsumer.andThen(triangleConsumer);

        Registry registry = Registry.createRegistry(initializer, shape -> {
            throw new IllegalArgumentException("unknown shape: " + shape);
        });
        FactorySupplier<Shape> rectangleFactory = registry.buildShapeFactory(ShapeEnum.RECTANGLE);
        FactorySupplier<Shape> triangleFactory = registry.buildShapeFactory(ShapeEnum.TRIANGLE);
        FactorySupplier<Shape> squareFactory = registry.buildShapeFactory(ShapeEnum.SQUARE);
        System.out.println(rectangleFactory.newInstance());
        System.out.println(triangleFactory.newInstance());
        System.out.println(squareFactory.newInstance());
    }
}
