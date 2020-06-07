package org.racket.lang.core;

import com.intellij.lang.Language;

public class RacketLanguage extends Language {
    public static final RacketLanguage INSTANCE = new RacketLanguage();

    private RacketLanguage() {
        super("Racket");
    }
}
