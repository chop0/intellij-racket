package com.aymanosman.racket.plugin.psi.impl;

import com.aymanosman.racket.plugin.psi.RacketNamedElement;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

public abstract class RacketNamedElementImpl extends ASTWrapperPsiElement implements RacketNamedElement {
    public RacketNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }
}
