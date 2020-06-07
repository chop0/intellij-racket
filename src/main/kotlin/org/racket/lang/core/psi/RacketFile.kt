package org.racket.lang.core.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import org.racket.lang.core.RacketFileType
import org.racket.lang.core.RacketLanguage

class RacketFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, RacketLanguage) {
    override fun getFileType(): FileType {
        return RacketFileType.Companion.INSTANCE
    }

    override fun toString(): String {
        return "Racket file"
    }

}