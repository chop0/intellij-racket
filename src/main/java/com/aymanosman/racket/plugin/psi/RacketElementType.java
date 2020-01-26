package com.aymanosman.racket.plugin.psi;

import com.aymanosman.racket.plugin.RacketLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class RacketElementType extends IElementType {
    public RacketElementType(@NotNull @NonNls String debugName) {
        super(debugName, RacketLanguage.INSTANCE);
    }
}
