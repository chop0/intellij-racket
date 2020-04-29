package com.aymanosman.racket.plugin;

import com.aymanosman.racket.plugin.psi.RacketTypes;
import com.intellij.lang.annotation.Annotation;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RacketAnnotator implements Annotator {
    static private final Set<String> KEYWORDS
            = new HashSet<>(Arrays.asList(
            // TODO: Obviously this is not a scalable solution.
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
            "when"));

    @Override
    public void annotate(@NotNull final PsiElement element, @NotNull AnnotationHolder holder) {
        if (element instanceof LeafPsiElement) {
            LeafPsiElement leaf = (LeafPsiElement) element;
            if (leaf.getElementType() == RacketTypes.HASH_LANG) {
                annotate_hash_lang(holder, leaf);
            } else if (leaf.getElementType() == RacketTypes.IDENTIFIER) {
                if (KEYWORDS.contains(leaf.getText())) {
                    annotate_keyword(element, holder);
                }
            }
        }
    }

    private void annotate_keyword(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        Annotation annotation = holder.createInfoAnnotation(element, null);
        annotation.setTextAttributes(DefaultLanguageHighlighterColors.KEYWORD);
    }

    private void annotate_hash_lang(@NotNull AnnotationHolder holder, LeafPsiElement leaf) {
        TextRange hashLangRange = new TextRange(leaf.getStartOffset(), leaf.getStartOffset() + 5);
        Annotation annotation = holder.createInfoAnnotation(hashLangRange, null);
        annotation.setTextAttributes(DefaultLanguageHighlighterColors.KEYWORD);
    }
}
