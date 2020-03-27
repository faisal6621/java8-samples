package github.faisal6621.mapfilterreduce;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * Reduction
 */
public class Reduction {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4, 5, 3, 2);

        // Associativity
        BinaryOperator<Integer> sumOfNumbers = (i, j) -> i + j; // true
        BinaryOperator<Integer> highestOfNumbers = (i, j) -> Integer.max(i, j); // true
        BinaryOperator<Integer> sumOfSquares = (i, j) -> (i * i) + (j * j); // false
        BinaryOperator<Integer> firstNumber = (i, j) -> i; // true
        BinaryOperator<Integer> lastNumber = (i, j) -> j; // true
        BinaryOperator<Integer> avgOfNumbers = (i, j) -> (i + j) / 2; // false

        numbers.stream().reduce(sumOfNumbers).ifPresent(System.out::println);
        numbers.stream().reduce(highestOfNumbers).ifPresent(System.out::println);
        numbers.stream().reduce(sumOfSquares).ifPresent(System.out::println);
        numbers.stream().reduce(firstNumber).ifPresent(System.out::println);
        numbers.stream().reduce(lastNumber).ifPresent(System.out::println);
        numbers.stream().reduce(avgOfNumbers).ifPresent(System.out::println);
    }
}
