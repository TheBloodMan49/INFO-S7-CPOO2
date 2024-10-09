package exercises.exercise11;

import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class ExpFactory {
	Map<String, Supplier<ArithmExp>> map;

	public ExpFactory() {
		map = Map.of("mult", () -> new Mult(),
				"plus", () -> new Plus(),
				"min", () -> new Min(),
				"mod", () -> new Mod());
	}

	public Optional<ArithmExp> createExp(final String exp) {
		return Optional.ofNullable(map.getOrDefault(exp, () -> null).get());
	}
}

interface ArithmExp {}
class Mult implements ArithmExp {}
class Plus implements ArithmExp {}
class Min implements ArithmExp {}
class Mod implements ArithmExp {}


