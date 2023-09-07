package nju.eur3ka.bmo

import org.kordamp.ikonli.javafx.FontIcon
import org.kordamp.ikonli.materialdesign2.MaterialDesignD
import org.kordamp.ikonli.materialdesign2.MaterialDesignF
import org.kordamp.ikonli.materialdesign2.MaterialDesignP
import org.kordamp.ikonli.materialdesign2.MaterialDesignZ

object ICONS {
    fun zipIcon() = FontIcon(MaterialDesignZ.ZIP_BOX)
    fun folderIcon() = FontIcon(MaterialDesignF.FOLDER)
    fun fileIcon() = FontIcon(MaterialDesignF.FILE)
    // .md .txt
    fun txtIcon() = FontIcon(MaterialDesignF.FILE_DOCUMENT)
    fun presetFileIcon() = FontIcon(MaterialDesignF.FINGERPRINT)
    fun archiveFileIcon() = FontIcon(MaterialDesignF.FILE_MULTIPLE)
    // .xl .yaml .json .ini .toml .xml
    fun cfgFileIcon() = FontIcon(MaterialDesignF.FILE_COG)
    // .sqlite3 .kark
    fun databaseIcon() = FontIcon(MaterialDesignD.DATABASE)
    // .lua .reds .asi
    fun codeIcon() = FontIcon(MaterialDesignF.FILE_CODE)
    // .otf .ttf
    fun fontFileIcon() = FontIcon(MaterialDesignF.FORMAT_LETTER_CASE)
    // .exe .bat
    fun exeIcon() = FontIcon(MaterialDesignP.PLAY_BOX)
    fun dllIcon() = FontIcon(MaterialDesignP.PUZZLE)
    fun getFileIconByFileExtension(fileExtensionName:String)= when(fileExtensionName.lowercase()){
        "zip" -> zipIcon()
        "rar" -> zipIcon()
        "7z" -> zipIcon()
        "md" -> txtIcon()
        "txt" -> txtIcon()
        "preset" -> presetFileIcon()
        "archive" -> archiveFileIcon()
        "xl" -> cfgFileIcon()
        "yaml" -> cfgFileIcon()
        "json" -> cfgFileIcon()
        "ini" -> cfgFileIcon()
        "toml" -> cfgFileIcon()
        "xml" -> cfgFileIcon()
        "sqlite3" -> databaseIcon()
        "kark" -> databaseIcon()
        "lua" -> codeIcon()
        "reds" -> codeIcon()
        "asi" -> codeIcon()
        "otf" -> fontFileIcon()
        "ttf" -> fontFileIcon()
        "exe" -> exeIcon()
        "bat" -> exeIcon()
        "dll" -> dllIcon()
        else -> fileIcon()
    }
}