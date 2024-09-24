package exercises.exercise19;

import java.util.function.Function;

public class Optional<T> {
    public static final Optional<?> EMPTY = new Optional<>();
    private T value;

    // Value constructor
    private Optional(T value) {
        this.value = value;
    }
    // Empty contructor
    private Optional() {
        this.value = null;
    }

    public static<S> Optional<S> of(S value) {
        return new Optional<>(value);
    }

    public static<S> Optional<S> empty() {
        return new Optional<>();
    }

    public boolean isPresent() {
        return value != null;
    }

    public T get() {
        if (isPresent()) {
            return value;
        } else {
            throw new IllegalStateException("No value present");
        }
    }

    public T orElse(T other) {
        if (isPresent()) {
            return value;
        } else {
            return other;
        }
    }

    public<S> Optional<S> map(Function<T, S> function) {
        if (isPresent()) {
            return Optional.of(function.apply(value));
        } else {
            return Optional.empty();
        }
    }
}
