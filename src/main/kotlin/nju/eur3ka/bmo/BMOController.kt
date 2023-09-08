package nju.eur3ka.bmo

import javafx.geometry.Orientation
import javafx.scene.control.Button
import javafx.scene.control.ListView
import javafx.scene.control.Separator
import javafx.scene.control.TableView
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import javafx.scene.control.ToolBar
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox

class BMOController(i18nTransform: TextTransform) {
    // === main view ===
    // rootVBox
    //    \--- mainToolBar [ profileBtn settingBtn ]
    //    \--- mainHBox
    //            \--- modVBox
    //                    \--- modToolBar [ modSavesBtn modBackupBtn modSearchTF modSearchBtn modToolBarSeparator modActivatedNT modNT]
    //                    \--- modTableView
    //            \--- archiveVBox
    //                    \--- archiveToolBar [ archiveNT ]
    //                    \--- archiveListView
    //    \--- logTA
    val rootVBox = VBox()
    val mainToolBar = ToolBar()
    val profileBtn = Button(i18nTransform.transform("button.profile"))
    val settingBtn = Button(i18nTransform.transform("button.setting"))
    val mainHBox = HBox()
    val modVBox = VBox()
    val modToolBar = ToolBar()
    val modSavesBtn = Button(i18nTransform.transform("button.saves"))
    val modBackupBtn = Button(i18nTransform.transform("button.backup"))
    val modSearchTF = TextField()
    val modSearchBtn = Button(i18nTransform.transform("button.search"))
    val modToolBarSeparator = Separator(Orientation.HORIZONTAL)
    val modActivatedNT = NumTracker(i18nTransform.transform("numtracker.modactivated"))
    val modNT = NumTracker(i18nTransform.transform("numtracker.mod"))
    val modTableView = TableView<ModEntry>()
    val archiveVBox = VBox()
    val archiveToolBar = ToolBar()
    val archiveNT = NumTracker(i18nTransform.transform("numtracker.archive"))
    val archiveListView = ListView<ModEntry>()
    val logTA = TextArea().apply { isEditable = false }

    // === mod install view ===
    val modArchiveInstallView = HBox()
    val modArchiveInfoVBox = VBox()
    val modArchiveOperationHBox = HBox()
    val modArchiveNameTF = TextField().apply { prefWidth = 200.0 }
    val modArchiveInstallBtn = Button(i18nTransform.transform("button.modarchive.install"))
    val modArchiveCancelBtn = Button(i18nTransform.transform("button.modarchive.cancel"))
    val modArchiveInfoTA = TextArea().apply { isEditable = false }
    var modArchiveTreeView = VBox() // mod 压缩包文件树显示
}