package org.racket.lang.core

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class RacketFileType private constructor() : LanguageFileType(RacketLanguage) {
    override fun getName(): String {
        return "Racket file"
    }

    override fun getDescription(): String {
        return "Racket language file"
    }

    override fun getDefaultExtension(): String {
        return "rkt"
    }

    override fun getIcon(): Icon? {
        return RacketIcons.FILE
    }

    companion object {
        val INSTANCE = RacketFileType()
    }
}
