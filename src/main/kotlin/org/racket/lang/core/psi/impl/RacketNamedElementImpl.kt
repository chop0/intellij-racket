package org.racket.lang.core.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import org.racket.lang.core.psi.RacketNamedElement;

public abstract class RacketNamedElementImpl extends ASTWrapperPsiElement implements RacketNamedElement {
    public RacketNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }
}
