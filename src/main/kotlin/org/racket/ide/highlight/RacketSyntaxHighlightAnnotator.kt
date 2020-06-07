package org.racket.ide.highlight

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import org.racket.lang.core.psi.RacketElementTypes
import java.util.*

class RacketSyntaxHighlightAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        when (element) {
            is LeafPsiElement ->
                when (element.elementType) {
                    RacketElementTypes.HASH_LANG ->
                        annotateHashLang(holder, element)
                    RacketElementTypes.IDENTIFIER ->
                        if (KEYWORDS.contains(element.text)) {
                            annotateKeyword(element, holder)
                        }
                }
        }
    }

    private fun annotateKeyword(element: PsiElement, holder: AnnotationHolder) {
        val annotation = holder.createInfoAnnotation(element, null)
        annotation.textAttributes = DefaultLanguageHighlighterColors.KEYWORD
    }

    private fun annotateHashLang(holder: AnnotationHolder, leaf: LeafPsiElement) {
        val hashLangRange = TextRange(leaf.startOffset, leaf.startOffset + 5)
        val annotation = holder.createInfoAnnotation(hashLangRange, null)
        annotation.textAttributes = DefaultLanguageHighlighterColors.KEYWORD
    }

    companion object {
        // TODO: Obviously this is not a scalable solution.
        private val KEYWORDS: Set<String> = HashSet(listOf(
                "define",
                "raise-argument-error",
                "make-parameter",
                "lambda",
                "module+",
                "printf",
                "loop",
                "for/list",
                "match",
                "cons",
                "list*",
                "define/contract",
                "class",
                "object%",
                "define/public",
                "null?",
                "eq?",
                "add1",
                "equal?",
                "define-values",
                "cond",
                "else",
                "define-struct",
                "case",
                "do",
                "parameterize",
                "with-handlers",
                "provide",
                "require",
                "syntax-rules",
                "define-syntax-rule",
                "and",
                "or",
                "unless",
                "if",
                "append",
                "not",
                "values",
                "struct",
                "list",
                "set!",
                "for",
                "let",
                "let*",
                "let-values",
                "let*-values",
                "when"))
    }
}
