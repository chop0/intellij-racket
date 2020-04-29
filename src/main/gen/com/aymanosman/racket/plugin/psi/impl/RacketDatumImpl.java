// This is a generated file. Not intended for manual editing.
package com.aymanosman.racket.plugin.psi.impl;

import com.aymanosman.racket.plugin.psi.RacketDatum;
import com.aymanosman.racket.plugin.psi.RacketForm;
import com.aymanosman.racket.plugin.psi.RacketVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;

public class RacketDatumImpl extends ASTWrapperPsiElement implements RacketDatum {

    public RacketDatumImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull RacketVisitor visitor) {
        visitor.visitDatum(this);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof RacketVisitor) accept((RacketVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public RacketForm getForm() {
        return findNotNullChildByClass(RacketForm.class);
    }

}
