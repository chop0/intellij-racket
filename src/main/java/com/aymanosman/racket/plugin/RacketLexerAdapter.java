package com.aymanosman.racket.plugin;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class RacketLexerAdapter extends FlexAdapter {
    public RacketLexerAdapter() {
        super(new RacketLexer((Reader) null));
    }
}
