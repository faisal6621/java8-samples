package github.faisal6621.design.patterns.registry;

import github.faisal6621.bean.Rectangle;
import github.faisal6621.bean.Shape;
import github.faisal6621.bean.Square;
import github.faisal6621.bean.Triangle;
import github.faisal6621.design.patterns.FactorySupplier;

/**
 * SwitchRegistry
 */
public class SwitchRegistry {

    public FactorySupplier<? extends Shape> buildShapeFactory(github.faisal6621.enums.Shape shape) {
        switch (shape) {
            case SQUARE:
                return Square::new;
            case RECTANGLE:
                return Rectangle::new;
            case TRIANGLE:
                return Triangle::new;
            default:
                throw new IllegalArgumentException("unknown shape: " + shape);
        }
    }
}
