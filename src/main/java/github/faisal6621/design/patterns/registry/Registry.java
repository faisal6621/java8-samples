package github.faisal6621.design.patterns.registry;

import java.util.EnumMap;
import java.util.function.Consumer;
import java.util.function.Function;

import github.faisal6621.bean.Shape;
import github.faisal6621.design.patterns.builder.Builder;
import github.faisal6621.design.patterns.factory.FactorySupplier;
import github.faisal6621.enums.ShapeEnum;

/**
 * Registry
 */
public interface Registry {

    FactorySupplier<Shape> buildShapeFactory(ShapeEnum shape);

    public static Registry createRegistry(Consumer<Builder<Shape>> consumer,
            Function<ShapeEnum, FactorySupplier<Shape>> errorFunction) {
        EnumMap<ShapeEnum, FactorySupplier<Shape>> map = new EnumMap<>(ShapeEnum.class);
        Builder<Shape> builder = map::put;
        consumer.accept(builder);

        return shape -> map.computeIfAbsent(shape, errorFunction);
    }

}
