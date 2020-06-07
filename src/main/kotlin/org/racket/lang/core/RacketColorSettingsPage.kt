package org.racket.lang.core

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import javax.swing.Icon

class RacketColorSettingsPage : ColorSettingsPage {
    override fun getIcon(): Icon? {
        return RacketIcons.FILE
    }

    override fun getHighlighter(): SyntaxHighlighter {
        return RacketSyntaxHighlighter()
    }

    override fun getDemoText(): String {
        return """#lang racket/base
;; This is a comment
()
(define (a-thing a [b 3] #:c 8)
  (list 42 #t #f #true #false "hello world" #"\x00" 'fixme))"""
    }

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey>? {
        return null
    }

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        return DESCRIPTORS
    }

    override fun getColorDescriptors(): Array<ColorDescriptor> {
        return ColorDescriptor.EMPTY_ARRAY
    }

    override fun getDisplayName(): String {
        return "Racket"
    }

    companion object {
        val DESCRIPTORS = arrayOf(
                AttributesDescriptor("Identifier", RacketSyntaxHighlighter.Companion.IDENTIFIER),
                AttributesDescriptor("Keyword", RacketSyntaxHighlighter.Companion.KEYWORD),
                AttributesDescriptor("Comment", RacketSyntaxHighlighter.Companion.COMMENT),
                AttributesDescriptor("String", RacketSyntaxHighlighter.Companion.STRING),
                AttributesDescriptor("Constant", RacketSyntaxHighlighter.Companion.CONSTANT),  // TODO this is confusing QUOTE?
                AttributesDescriptor("Number", RacketSyntaxHighlighter.Companion.NUMBER),
                AttributesDescriptor("Boolean", RacketSyntaxHighlighter.Companion.BOOLEAN),
                AttributesDescriptor("Parentheses", RacketSyntaxHighlighter.Companion.PARENTHESES))
    }
}
