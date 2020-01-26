package com.aymanosman.racket.plugin.psi;

import com.aymanosman.racket.plugin.RacketLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class RacketTokenType extends IElementType {
    public RacketTokenType(@NotNull @NonNls String debugName) {
        super(debugName, RacketLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "RacketTokenType." + super.toString();
    }
}
