package exercises.exercise18;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

// There already exists Inject annotations in javax.inject for example.
// Retention means: by default an annotation is not kept in class files to be used at run time.
// So, we need to tell the compiler this annotation Inject must be saved in class files
// (otherwise, the injection will not work as the program will not find annotations at run time).
@Retention(RetentionPolicy.RUNTIME)
@interface Inject {
}

public class Injector {

	public <T> Optional<T> createInstance(final Class<T> cl) {
		return createInstance2(cl, new HashSet<>());
	}
	public <T> Optional<T> createInstance2(final Class<T> cl, Set<Class<?>> classes) {
		if(cl == null) {
			return Optional.empty();
		}
		if(cl.isPrimitive() || cl.isArray() || cl.isEnum() || classes.contains(cl)) {
			return Optional.empty();
		}
		try {
			final T instance = cl.getDeclaredConstructor().newInstance();
			classes.add(cl);

            Arrays.stream(cl.getDeclaredFields())
					.filter(field -> field.isAnnotationPresent(Inject.class))
					.filter(field -> !field.getType().isPrimitive())
					.forEach(field -> {
						try {
							field.set(instance, createInstance2(field.getType(), new HashSet<>(classes)).orElse(null));
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						}
					});

			return Optional.of(instance);

		} catch(InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
		}

		return Optional.empty();
	}
}
