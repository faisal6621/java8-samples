package github.faisal6621.design.patterns.registry;

import github.faisal6621.bean.Shape;
import github.faisal6621.design.patterns.factory.FactorySupplier;
import github.faisal6621.enums.ShapeEnum;

/**
 * PlayWithSwitchRegistry
 */
public class PlayWithSwitchRegistry {

    public static void main(String[] args) {
        SwitchRegistry registry = new SwitchRegistry();
        FactorySupplier<? extends Shape> rectangleFactory = registry.buildShapeFactory(ShapeEnum.RECTANGLE);
        System.out.println(rectangleFactory.newInstance());
    }
}
