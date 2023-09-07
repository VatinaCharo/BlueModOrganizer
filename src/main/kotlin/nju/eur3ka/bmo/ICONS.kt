package nju.eur3ka.bmo

import org.kordamp.ikonli.javafx.FontIcon
import org.kordamp.ikonli.materialdesign2.MaterialDesignD
import org.kordamp.ikonli.materialdesign2.MaterialDesignF
import org.kordamp.ikonli.materialdesign2.MaterialDesignP
import org.kordamp.ikonli.materialdesign2.MaterialDesignZ

object ICONS {
    val zipIcon = FontIcon(MaterialDesignZ.ZIP_BOX)
    val folderIcon = FontIcon(MaterialDesignF.FOLDER)
    val fileIcon = FontIcon(MaterialDesignF.FILE)
    // .md .txt
    val txtIcon = FontIcon(MaterialDesignF.FILE_DOCUMENT)
    val presetFileIcon = FontIcon(MaterialDesignF.FINGERPRINT)
    val archiveFileIcon = FontIcon(MaterialDesignF.FILE_MULTIPLE)
    // .xl .yml .json .ini .toml .xml
    val cfgFileIcon = FontIcon(MaterialDesignF.FILE_COG)
    // .sqlite3 .kark
    val databaseIcon = FontIcon(MaterialDesignD.DATABASE)
    // .lua .reds .asi
    val codeIcon = FontIcon(MaterialDesignF.FILE_CODE)
    val fontFileIcon = FontIcon(MaterialDesignF.FORMAT_LETTER_CASE)
    // .exe .bat
    val exeIcon = FontIcon(MaterialDesignP.PLAY_BOX)
    val dllIcon = FontIcon(MaterialDesignP.PUZZLE)
    fun getFileIconByFileExtension(fileExtensionName:String)= when(fileExtensionName.lowercase()){
        "zip" -> zipIcon
        "rar" -> zipIcon
        "7z" -> zipIcon
        "md" -> txtIcon
        "txt" -> txtIcon
        "preset" -> presetFileIcon
        else -> fileIcon
    }
}