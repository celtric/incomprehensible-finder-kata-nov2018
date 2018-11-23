package algorithm;

import java.util.Objects;
import java.util.Optional;

public class Pair {
	private Person youngest;
	private Person oldest;

	public Pair(Person youngest, Person oldest) {
		if (oldest.isYoungerThan(youngest)) {
			throw new RuntimeException("First person must be the youngest");
		}

		this.youngest = youngest;
		this.oldest = oldest;
	}

	static Optional<Pair> fromUnordered(Person personA, Person personB) {
		if (personA.equals(personB)) {
			return Optional.empty();
		}

		return Optional.of(new Pair(
				personA.youngest(personB),
				personA.oldest(personB)));
	}

	private long ageDifference() {
		return oldest.ageDifferenceWith(youngest);
	}

	private boolean isCloserInAgeThan(Pair answer) {
		return ageDifference() < answer.ageDifference();
	}

	Pair closestInAge(Pair anotherPair) {
		return isCloserInAgeThan(anotherPair) ? this : anotherPair;
	}

	Pair furthestInAge(Pair anotherPair) {
		return isCloserInAgeThan(anotherPair) ? anotherPair : this;
	}

	Pair longestCombinedName(Pair anotherPair) {
		return combinedNameLength() > anotherPair.combinedNameLength() ? this : anotherPair;
	}

	private int combinedNameLength() {
		return youngest.nameLength() + oldest.nameLength();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Pair pair = (Pair) o;
		return Objects.equals(youngest, pair.youngest) &&
				Objects.equals(oldest, pair.oldest);
	}

	@Override
	public int hashCode() {
		return Objects.hash(youngest, oldest);
	}
}
