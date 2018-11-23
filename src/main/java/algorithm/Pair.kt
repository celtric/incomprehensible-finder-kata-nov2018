package algorithm

data class Pair(private val youngest: Person, private val oldest: Person) {

    init {
        require(!oldest.isYoungerThan(youngest)) { "First person must be the youngest" }
    }

    companion object {
        fun fromUnordered(personA: Person, personB: Person): Pair? {
            return if (personA == personB) {
                null
            } else {
                Pair(personA.youngest(personB), personA.oldest(personB))
            }
        }
    }

    fun closestInAge(anotherPair: Pair) = if (isCloserInAgeThan(anotherPair)) this else anotherPair

    fun furthestInAge(anotherPair: Pair) = if (isCloserInAgeThan(anotherPair)) anotherPair else this

    private fun isCloserInAgeThan(answer: Pair) = ageDifference() < answer.ageDifference()

    private fun ageDifference() = oldest.ageDifferenceWith(youngest)

    fun longestCombinedName(anotherPair: Pair) =
            if (combinedNameLength() > anotherPair.combinedNameLength()) this else anotherPair

    private fun combinedNameLength() = youngest.nameLength() + oldest.nameLength()
}
