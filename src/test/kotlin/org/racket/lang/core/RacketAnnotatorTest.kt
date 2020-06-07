package org.racket.lang.core

import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase

class RacketAnnotatorTest : LightJavaCodeInsightFixtureTestCase() {
    override fun getTestDataPath(): String {
        return "src/test/testData"
    }

    fun testAnnotation() {
        myFixture.configureByFiles("annotator-test-data.rkt")
        myFixture.checkHighlighting(false, true, true, true)
    }
}
