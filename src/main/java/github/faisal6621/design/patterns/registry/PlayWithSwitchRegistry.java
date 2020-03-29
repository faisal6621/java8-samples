package github.faisal6621.design.patterns.registry;

import github.faisal6621.design.patterns.FactorySupplier;
import github.faisal6621.enums.Shape;

/**
 * PlayWithSwitchRegistry
 */
public class PlayWithSwitchRegistry {

    public static void main(String[] args) {
        SwitchRegistry registry = new SwitchRegistry();
        FactorySupplier<? extends github.faisal6621.bean.Shape> rectangleFactory = registry
                .buildShapeFactory(Shape.RECTANGLE);
        System.out.println(rectangleFactory.newInstance());
    }
}
