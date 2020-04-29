package com.aymanosman.racket.plugin;

import com.aymanosman.racket.plugin.psi.RacketTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

public class RacketSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey IDENTIFIER =
            TextAttributesKey.createTextAttributesKey("RACKET_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey KEYWORD =
            TextAttributesKey.createTextAttributesKey("RACKET_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey STRING =
            TextAttributesKey.createTextAttributesKey("RACKET_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey CONSTANT =
            TextAttributesKey.createTextAttributesKey("RACKET_CONSTANT", DefaultLanguageHighlighterColors.CONSTANT);
    public static final TextAttributesKey NUMBER =
            TextAttributesKey.createTextAttributesKey("RACKET_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey BOOLEAN =
            TextAttributesKey.createTextAttributesKey("RACKET_BOOLEAN", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey PARENTHESES =
            TextAttributesKey.createTextAttributesKey("RACKET_PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES);
    public static final TextAttributesKey CHARACTER =
            TextAttributesKey.createTextAttributesKey("RACKET_CHARACTER", DefaultLanguageHighlighterColors.CONSTANT);
    public static final TextAttributesKey COMMENT =
            TextAttributesKey.createTextAttributesKey("RACKET_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);

    public static final TextAttributesKey[] IDENTIFIER_KEYS = new TextAttributesKey[]{IDENTIFIER};
    public static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD};
    public static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING};
    public static final TextAttributesKey[] CONSTANT_KEYS = new TextAttributesKey[]{CONSTANT};
    public static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};
    public static final TextAttributesKey[] BOOLEAN_KEYS = new TextAttributesKey[]{BOOLEAN};
    public static final TextAttributesKey[] PARENTHESES_KEYS = new TextAttributesKey[]{PARENTHESES};
    public static final TextAttributesKey[] CHARACTER_KEYS = new TextAttributesKey[]{CHARACTER};
    public static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    public static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new RacketLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(RacketTypes.IDENTIFIER)) {
            return IDENTIFIER_KEYS;
        } else if (tokenType.equals(RacketTypes.KEYWORD)) {
            return KEYWORD_KEYS;
        } else if (tokenType.equals(RacketTypes.STRING)) {
            return STRING_KEYS;
        } else if (tokenType.equals(RacketTypes.CONSTANT)) {
            return CONSTANT_KEYS;
        } else if (tokenType.equals(RacketTypes.NUMBER)) {
            return NUMBER_KEYS;
        } else if (tokenType.equals(RacketTypes.BOOLEAN)) {
            return BOOLEAN_KEYS;
        } else if (tokenType.equals(RacketTypes.CHARACTER)) {
            return CHARACTER_KEYS;
        } else if (tokenType.equals(RacketTypes.OPEN_PAREN)
                || tokenType.equals(RacketTypes.CLOSE_PAREN)
                || tokenType.equals(RacketTypes.OPEN_SQUARE)
                || tokenType.equals(RacketTypes.CLOSE_SQUARE)) {
            return PARENTHESES_KEYS;
        } else if (tokenType.equals(RacketTypes.COMMENT)
                || tokenType.equals(RacketTypes.SEXP_COMMENT)) {
            return COMMENT_KEYS;
        } else {
            return EMPTY_KEYS;
        }
    }
}
