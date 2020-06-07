package org.racket.lang.core

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import org.racket.lang.core.psi.RacketTypes
import java.util.*

class RacketAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element is LeafPsiElement) {
            val leaf = element
            if (leaf.elementType === RacketTypes.HASH_LANG) {
                annotate_hash_lang(holder, leaf)
            } else if (leaf.elementType === RacketTypes.IDENTIFIER) {
                if (KEYWORDS.contains(leaf.text)) {
                    annotate_keyword(element, holder)
                }
            }
        }
    }

    private fun annotate_keyword(element: PsiElement, holder: AnnotationHolder) {
        val annotation = holder.createInfoAnnotation(element, null)
        annotation.textAttributes = DefaultLanguageHighlighterColors.KEYWORD
    }

    private fun annotate_hash_lang(holder: AnnotationHolder, leaf: LeafPsiElement) {
        val hashLangRange = TextRange(leaf.startOffset, leaf.startOffset + 5)
        val annotation = holder.createInfoAnnotation(hashLangRange, null)
        annotation.textAttributes = DefaultLanguageHighlighterColors.KEYWORD
    }

    companion object {
        private val KEYWORDS: Set<String> = HashSet(Arrays.asList( // TODO: Obviously this is not a scalable solution.
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
