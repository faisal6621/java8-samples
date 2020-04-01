package github.faisal6621.design.patterns.visitor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

import github.faisal6621.design.patterns.builder.VisitorBuilder;

/**
 * Visitor
 */
@FunctionalInterface
public interface Visitor<R> {

    R visit(Object o);

    static <R> Visitor<R> of(Consumer<VisitorBuilder<R>> consumer) {
        Map<Class<?>, Function<Object, R>> registry = new HashMap<>();
        consumer.accept(registry::put);
        return object -> registry.get(object.getClass()).apply(object);
    }

    static <R> X<R> forType(Class<?> type) {
        return () -> type;
    }

    @FunctionalInterface
    public interface X<R> {
        Class<?> type();

        default Y<R> execute(Function<Object, R> function) {
            return visitorBuilder -> visitorBuilder.register(type(), function);
        }

    }

    public interface Y<R> extends Consumer<VisitorBuilder<R>> {
        default Z<R> forType(Class<?> type) {
            return index -> index == 0 ? type : this;
        }

        default Y<R> andThen(Y<R> after) {
            return t -> {
                this.accept(t);
                after.accept(t);
            };
        }
    }

    public interface Z<R> {
        Object get(int index);

        default Class<?> type() {
            return (Class<?>) get(0);
        }

        @SuppressWarnings("unchecked")
        default Y<R> previousConsumer() {
            return (Y<R>) get(1);
        }

        default Y<R> execute(Function<Object, R> function) {
            return previousConsumer().andThen(visitorBuilder -> visitorBuilder.register(type(), function));
        }

    }
}
