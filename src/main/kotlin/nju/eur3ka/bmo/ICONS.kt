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
//    val zipIcon = ImageView(ICONS::class.java.getResource("icons/icon_archive_cfg_50.png")!!.toExternalForm())
//    val folderIcon = ImageView(ICONS::class.java.getResource("icons/icon_folder_50.png")!!.toExternalForm())
//    val fileIcon = ImageView(ICONS::class.java.getResource("icons/icon_file_50.png")!!.toExternalForm())
//    val txtIcon = ImageView(ICONS::class.java.getResource("icons/icon_txt_50.png")!!.toExternalForm())
//    val presetFileIcon = ImageView(ICONS::class.java.getResource("icons/icon_preset_50.png")!!.toExternalForm())
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
        "zip" -> FontIcon(MaterialDesignZ.ZIP_BOX)
        "rar" -> FontIcon(MaterialDesignZ.ZIP_BOX)
        "7z" -> FontIcon(MaterialDesignZ.ZIP_BOX)
        "md" -> FontIcon(MaterialDesignF.FILE_DOCUMENT)
        "txt" -> FontIcon(MaterialDesignF.FILE_DOCUMENT)
        "preset" -> FontIcon(MaterialDesignF.FINGERPRINT)
        else -> FontIcon(MaterialDesignF.FILE)
    }
}