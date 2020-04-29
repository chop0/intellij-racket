package com.aymanosman.racket.plugin.psi;

import com.aymanosman.racket.plugin.RacketFileType;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFileFactory;

public class RacketElementFactory {
    public static RacketForm createForm(Project project, String name) {
        final RacketFile file = createFile(project, name);
        return (RacketForm) file.getFirstChild();
    }

    public static RacketFile createFile(Project project, String text) {
        String name = "dummy.rkt";
        return (RacketFile) PsiFileFactory.getInstance(project)
                .createFileFromText(name, RacketFileType.INSTANCE, text);
    }
}
