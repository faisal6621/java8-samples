package github.faisal6621.design.patterns.factory;

import java.util.function.Supplier;

import github.faisal6621.bean.Circle;
import github.faisal6621.enums.Color;

/**
 * PlayWithFactoryPattern
 */
public class PlayWithFactoryPattern {

    public static void main(String[] args) {
        Supplier<Circle> supplier = () -> new Circle();
        System.out.println("Circle from supplier: " + supplier.get());

        FactorySupplier<Circle> defaultCircleFactory = FactorySupplier.createInstance(Circle::new);
        System.out.println("new instance from factory: " + defaultCircleFactory.newInstance());

        System.out.println("Circles: " + defaultCircleFactory.getFiveInstances());

        FactorySupplier<Circle> redCircleFactory = FactorySupplier.createInstance(Color.RED, Circle::new);
        System.out.println("Red circle: " + redCircleFactory.newInstance());

        FactorySupplier<Circle> blackCircleSupplier = FactorySupplier.createInstance(Color.BLACK, Circle::new);
        FactorySupplier<Circle> blackCircleSingleton = FactorySupplier.singleton(blackCircleSupplier);
        Circle b1 = blackCircleSingleton.newInstance();
        Circle b2 = blackCircleSingleton.newInstance();
        System.out.println("is b1==b2? " + (b1 == b2));
    }
}
