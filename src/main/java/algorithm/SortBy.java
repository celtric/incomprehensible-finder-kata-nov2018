package algorithm;

public enum SortBy {

	Closer {
        @Override
        Pair choose(Pair pairA, Pair pairB) {
            return pairA.closestInAge(pairB);
        }
    },

    Further {
        @Override
        Pair choose(Pair pairA, Pair pairB) {
            return pairA.furthestInAge(pairB);
        }
    },

    LongestCombinedName {
        @Override
        Pair choose(Pair pairA, Pair pairB) {
            return pairA.longestCombinedName(pairB);
        }
    };

    abstract Pair choose(Pair pairA, Pair pairB);
}
