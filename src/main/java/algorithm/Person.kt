package algorithm

import java.util.Date

class Person(private val name: String, private val birthDate: Date) {

    fun ageDifferenceWith(anotherPerson: Person) = birthDate.time - anotherPerson.birthDate.time

    fun youngest(anotherPerson: Person) = if (isYoungerThan(anotherPerson)) this else anotherPerson

    fun oldest(anotherPerson: Person) = if (isYoungerThan(anotherPerson)) anotherPerson else this

    internal fun isYoungerThan(anotherPerson: Person) = birthDate.time < anotherPerson.birthDate.time

    fun nameLength() = name.length
}
