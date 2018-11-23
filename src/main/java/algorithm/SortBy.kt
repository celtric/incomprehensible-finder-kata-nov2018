package algorithm

enum class SortBy(private val doChoose: (pairA: Pair, pairB: Pair) -> Pair) {

    Closer(Pair::closestInAge),
    Further(Pair::furthestInAge),
    LongestCombinedName(Pair::longestCombinedName);

    internal fun choose(pairA: Pair, pairB: Pair) = doChoose(pairA, pairB)
}
