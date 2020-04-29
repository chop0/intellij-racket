// This is a generated file. Not intended for manual editing.
package com.aymanosman.racket.plugin.psi.impl;

import com.aymanosman.racket.plugin.psi.RacketForm;
import com.aymanosman.racket.plugin.psi.RacketItem;
import com.aymanosman.racket.plugin.psi.RacketVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RacketItemImpl extends ASTWrapperPsiElement implements RacketItem {

    public RacketItemImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull RacketVisitor visitor) {
        visitor.visitItem(this);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof RacketVisitor) accept((RacketVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public RacketForm getForm() {
        return findChildByClass(RacketForm.class);
    }

}
