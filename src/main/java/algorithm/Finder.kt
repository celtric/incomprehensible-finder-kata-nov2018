package algorithm

class Finder(private val people: List<Person>) {

    fun find(sortBy: SortBy) = pairs().let {
        if (it.isEmpty()) null else it.reduce(sortBy::choose)
    }

    private fun pairs() = people.flatMap { combineAllWith(it) }

    private fun combineAllWith(person: Person) = people.mapNotNull { Pair.fromUnordered(it, person) }
}
