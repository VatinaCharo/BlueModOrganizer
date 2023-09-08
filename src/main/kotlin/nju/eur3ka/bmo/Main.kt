package nju.eur3ka.bmo

import ink.bluecloud.css.CssResources
import javafx.application.Application
import javafx.geometry.Orientation
import javafx.scene.Scene
import javafx.stage.Stage

class BMOApp : Application() {
    val appName = "BlueModOrganizer"
    val version = "0.0.1-alpha"
    var i18nTransform = TextTransform(I18nType.zh_CN)
    private val controller = BMOController(i18nTransform)
    private fun ui() {
        controller.rootVBox.run {
            children.addAll(controller.mainToolBar, controller.mainHBox, controller.logTA)
        }
        controller.mainToolBar.run {
            orientation = Orientation.HORIZONTAL
            items.addAll(controller.profileBtn, controller.settingBtn)
        }
        controller.mainHBox.run {
            children.addAll(controller.modVBox, controller.archiveVBox)
        }
        controller.modVBox.run {
            children.addAll(controller.modToolBar, controller.modTableView)
        }
        controller.modToolBar.run {
            items.addAll(
                controller.modSavesBtn,
                controller.modBackupBtn,
                controller.modSearchTF,
                controller.modSearchBtn,
                controller.modToolBarSeparator,
                controller.modActivatedNT,
                controller.modNT
            )
        }
        controller.archiveVBox.run {
            children.addAll(controller.archiveToolBar, controller.archiveListView)
        }
        controller.archiveToolBar.run {
            items.addAll(controller.archiveNT)
        }
    }

    override fun start(stage: Stage) {
        ui()
        stage.run {
            title = appName + " " + version
            scene = Scene(controller.rootVBox).apply {
                stylesheets.add(CssResources.globalCssFile)
            }
            show()
        }
    }
}

fun main() {
    Application.launch(BMOApp::class.java)
}