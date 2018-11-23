package test

import org.junit.Assert.assertEquals

import java.util.*

import org.junit.Test

import algorithm.Pair
import algorithm.SortBy
import algorithm.Finder
import algorithm.Person
import kotlin.test.assertNull

class FinderTests {

    private val sue = Person("Sue", Date(50, 0, 1))
    private val greg = Person("Greg", Date(52, 5, 1))
    private val sarah = Person("Sarah", Date(82, 0, 1))
    private val mike = Person("Mike", Date(79, 0, 1))

    @Test
    fun Returns_Empty_Results_When_Given_Empty_List() {
        val people = emptyList<Person>()

        val result = Finder(people).find(SortBy.Closer)

        assertNull(result)
    }

    @Test
    fun Returns_Empty_Results_When_Given_One_Person() {
        val people = listOf(sue)

        val result = Finder(people).find(SortBy.Closer)

        assertNull(result)
    }

    @Test
    fun Returns_Closest_Two_For_Two_People() {
        val people = listOf(sue, greg)

        val result = Finder(people).find(SortBy.Closer)

        assertEquals(Pair(sue, greg), result)
    }

    @Test
    fun Returns_Furthest_Two_For_Two_People() {
        val list = listOf(mike, greg)

        val result = Finder(list).find(SortBy.Further)

        assertEquals(Pair(greg, mike), result)
    }

    @Test
    fun Returns_Furthest_Two_For_Four_People() {
        val list = listOf(sue, sarah, mike, greg)

        val result = Finder(list).find(SortBy.Further)

        assertEquals(Pair(sue, sarah), result)
    }

    @Test
    fun Returns_Closest_Two_For_Four_People() {
        val list = listOf(sue, sarah, mike, greg)

        val result = Finder(list).find(SortBy.Closer)

        assertEquals(Pair(sue, greg), result)
    }

    @Test
    fun returns_pair_with_longest_combined_name() {
        val shortName1 = Person("Short 1", Date(50, 0, 1))
        val shortName2 = Person("Short 2", Date(50, 0, 2))
        val longName1 = Person("Long name 1", Date(50, 0, 1))
        val longName2 = Person("Long name 2", Date(50, 0, 2))
        val people = Arrays.asList(shortName1, shortName2, longName1, longName2)

        val result = Finder(people).find(SortBy.LongestCombinedName)

        assertEquals(Pair(longName1, longName2), result)
    }
}
