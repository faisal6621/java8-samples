package github.faisal6621.design.patterns.visitor;

import java.util.function.Consumer;

import github.faisal6621.bean.Body;
import github.faisal6621.bean.Car;
import github.faisal6621.bean.Engine;
import github.faisal6621.design.patterns.builder.VisitorBuilder;

/**
 * PlayWithVisitor
 */
public class PlayWithVisitor {
    public static void main(String[] args) {
        Car car = new Car();
        Engine engine = new Engine();
        Body body = new Body();

        Consumer<VisitorBuilder<String>> consumer = Visitor.<String>forType(Car.class)
                .execute(c -> "Visiting car: " + c).forType(Engine.class).execute(e -> "Visiting engine: " + e)
                .forType(Body.class).execute(b -> "Visiting body: " + b);

        Visitor<String> visitor = Visitor.of(consumer);

        System.out.println("Visiting car: " + visitor.visit(car));
        System.out.println("Visiting engine: " + visitor.visit(engine));
        System.out.println("Visiting body: " + visitor.visit(body));
    }
}
