package org.racket.lang.core;

import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase;

public class RacketAnnotatorTest extends LightJavaCodeInsightFixtureTestCase {
    @Override
    protected String getTestDataPath() {
        return "src/test/testData";
    }

    public void testAnnotation() {
        myFixture.configureByFiles("annotator-test-data.rkt");

        myFixture.checkHighlighting(false, true, true, true);
    }
}
