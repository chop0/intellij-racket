package org.racket.lang.core;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class RacketFileType extends LanguageFileType {
    public static final RacketFileType INSTANCE = new RacketFileType();

    private RacketFileType() {
        super(RacketLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Racket file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Racket language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "rkt";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return RacketIcons.FILE;
    }
}
