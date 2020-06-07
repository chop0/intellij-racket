package org.racket.lang.core.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;
import org.racket.lang.core.RacketFileType;
import org.racket.lang.core.RacketLanguage;

import javax.swing.*;

public class RacketFile extends PsiFileBase {
    public RacketFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, RacketLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return RacketFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Racket file";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}
