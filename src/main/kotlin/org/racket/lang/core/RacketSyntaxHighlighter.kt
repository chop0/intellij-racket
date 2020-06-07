package org.racket.lang.core

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import org.racket.lang.core.lexer.RacketLexerAdapter
import org.racket.lang.core.psi.RacketTypes

class RacketSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return RacketLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return if (tokenType == RacketTypes.IDENTIFIER) {
            IDENTIFIER_KEYS
        } else if (tokenType == RacketTypes.KEYWORD) {
            KEYWORD_KEYS
        } else if (tokenType == RacketTypes.STRING) {
            STRING_KEYS
        } else if (tokenType == RacketTypes.CONSTANT) {
            CONSTANT_KEYS
        } else if (tokenType == RacketTypes.NUMBER) {
            NUMBER_KEYS
        } else if (tokenType == RacketTypes.BOOLEAN) {
            BOOLEAN_KEYS
        } else if (tokenType == RacketTypes.CHARACTER) {
            CHARACTER_KEYS
        } else if (tokenType == RacketTypes.OPEN_PAREN || tokenType == RacketTypes.CLOSE_PAREN || tokenType == RacketTypes.OPEN_SQUARE || tokenType == RacketTypes.CLOSE_SQUARE) {
            PARENTHESES_KEYS
        } else if (tokenType == RacketTypes.COMMENT || tokenType == RacketTypes.SEXP_COMMENT) {
            COMMENT_KEYS
        } else {
            EMPTY_KEYS
        }
    }

    companion object {
        val IDENTIFIER = TextAttributesKey.createTextAttributesKey("RACKET_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER)
        val KEYWORD = TextAttributesKey.createTextAttributesKey("RACKET_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
        val STRING = TextAttributesKey.createTextAttributesKey("RACKET_STRING", DefaultLanguageHighlighterColors.STRING)
        val CONSTANT = TextAttributesKey.createTextAttributesKey("RACKET_CONSTANT", DefaultLanguageHighlighterColors.CONSTANT)
        val NUMBER = TextAttributesKey.createTextAttributesKey("RACKET_NUMBER", DefaultLanguageHighlighterColors.NUMBER)
        val BOOLEAN = TextAttributesKey.createTextAttributesKey("RACKET_BOOLEAN", DefaultLanguageHighlighterColors.KEYWORD)
        val PARENTHESES = TextAttributesKey.createTextAttributesKey("RACKET_PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES)
        val CHARACTER = TextAttributesKey.createTextAttributesKey("RACKET_CHARACTER", DefaultLanguageHighlighterColors.CONSTANT)
        val COMMENT = TextAttributesKey.createTextAttributesKey("RACKET_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
        val IDENTIFIER_KEYS = arrayOf(IDENTIFIER)
        val KEYWORD_KEYS = arrayOf(KEYWORD)
        val STRING_KEYS = arrayOf(STRING)
        val CONSTANT_KEYS = arrayOf(CONSTANT)
        val NUMBER_KEYS = arrayOf(NUMBER)
        val BOOLEAN_KEYS = arrayOf(BOOLEAN)
        val PARENTHESES_KEYS = arrayOf(PARENTHESES)
        val CHARACTER_KEYS = arrayOf(CHARACTER)
        val COMMENT_KEYS = arrayOf(COMMENT)
        val EMPTY_KEYS = emptyArray<TextAttributesKey>()
    }
}
