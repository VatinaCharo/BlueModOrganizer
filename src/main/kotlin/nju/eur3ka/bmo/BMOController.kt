package nju.eur3ka.bmo

import javafx.scene.control.Button
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.ToolBar
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox

object BMOController {
    val rootVBox = VBox()
    val mainToolBar = ToolBar()
    val profileBtn = Button(BMOApp.i18nTransform.transform("button.profile"))
    val settingBtn = Button(BMOApp.i18nTransform.transform("button.setting"))
    val mainHBox = HBox()
    val modVBox = VBox()
    val modToolBar = ToolBar()
}