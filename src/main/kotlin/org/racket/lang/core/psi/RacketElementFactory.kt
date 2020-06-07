package org.racket.lang.core.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFileFactory;
import org.racket.lang.core.RacketFileType;

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
