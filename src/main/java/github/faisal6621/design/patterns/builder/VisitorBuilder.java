package github.faisal6621.design.patterns.builder;

import java.util.function.Function;

/**
 * VisitorBuilder
 */
public interface VisitorBuilder<R> {

    void register(Class<?> type, Function<Object, R> function);
}
