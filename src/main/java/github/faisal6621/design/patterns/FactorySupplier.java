package github.faisal6621.design.patterns;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * FactorySupplier
 */
@FunctionalInterface
public interface FactorySupplier<T> extends Supplier<T> {

    default T newInstance() {
        return get();
    }

    default List<T> getFiveInstances() {
        return IntStream.range(0, 5).mapToObj(i -> newInstance()).collect(Collectors.toList());
    }

    static <T> FactorySupplier<T> createInstance(Supplier<T> supplier) {
        Objects.requireNonNull(supplier);
        return () -> supplier.get();
    }

    static <T, P> FactorySupplier<T> createInstance(P param, Function<P, T> constructor) {
        Objects.requireNonNull(param);
        Objects.requireNonNull(constructor);
        return () -> constructor.apply(param);
    }

    static <T> FactorySupplier<T> singleton(Supplier<T> supplier) {
        Objects.requireNonNull(supplier);
        T singleton = supplier.get();
        return () -> singleton;
    }

}
