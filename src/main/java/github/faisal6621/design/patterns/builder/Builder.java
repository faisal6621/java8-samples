package github.faisal6621.design.patterns.builder;

import github.faisal6621.bean.Shape;
import github.faisal6621.design.patterns.factory.FactorySupplier;
import github.faisal6621.enums.ShapeEnum;

/**
 * Builder
 */
// @FunctionalInterface
public interface Builder<T> {

    void register(ShapeEnum shape, FactorySupplier<Shape> supplier);
}
