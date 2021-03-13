package io.kotest.springissue

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.core.spec.style.FunSpec
import io.kotest.spring.SpringListener
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest

class FlakyKotestConfig : AbstractProjectConfig() {
	override val parallelism: Int = 10
}

/**
 * These tests are flaky and will sometimes fail when run in parallel
 * Exception is java.util.NoSuchElementException: Key io.kotest.springissue.FlakySpringTest.... is missing in the map.
 */
abstract class AbstractFlakyTest(val name: String) : FunSpec({
	listener(SpringListener)

	test("Test") {}
})

@JdbcTest
class FlakySpringTestOne() : AbstractFlakyTest("One")

@JdbcTest
class FlakySpringTestTwo() : AbstractFlakyTest("Two")

@JdbcTest
class FlakySpringTestThree() : AbstractFlakyTest("Three")

@JdbcTest
class FlakySpringTestFour() : AbstractFlakyTest("Four")

@JdbcTest
class FlakySpringTestFive() : AbstractFlakyTest("Five")

@JdbcTest
class FlakySpringTestSix() : AbstractFlakyTest("Six")

@JdbcTest
class FlakySpringTestSeven(): AbstractFlakyTest("Seven")

@JdbcTest
class FlakySpringTestEight() : AbstractFlakyTest("Eight")

@JdbcTest
class FlakySpringTestNine() : AbstractFlakyTest("Nine")

@JdbcTest
class FlakySpringTestTen() : AbstractFlakyTest("Ten")