package algorithm

enum class SortBy {

    Closer {
        override fun choose(pairA: Pair, pairB: Pair): Pair {
            return pairA.closestInAge(pairB)
        }
    },

    Further {
        override fun choose(pairA: Pair, pairB: Pair): Pair {
            return pairA.furthestInAge(pairB)
        }
    },

    LongestCombinedName {
        override fun choose(pairA: Pair, pairB: Pair): Pair {
            return pairA.longestCombinedName(pairB)
        }
    };

    internal abstract fun choose(pairA: Pair, pairB: Pair): Pair
}
