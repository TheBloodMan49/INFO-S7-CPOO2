package exercises.exercise2;

import java.util.Arrays;
import java.util.Optional;

public enum ColourCard {
	SPADE, CLUB, HEART, DIAMOND;

	public static Optional<ColourCard> getColourCard(final String colourCard) {
		return Arrays
				.stream(ColourCard.values())
				.filter(card -> card.name().equals(colourCard))
				.findFirst();
	}
}


