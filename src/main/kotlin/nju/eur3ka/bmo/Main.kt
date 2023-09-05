package nju.eur3ka.bmo

import ink.bluecloud.css.CssResources
import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage

object BMOApp : Application() {
    val appName = "BlueModOrganizer"
    val version = "0.0.1-alpha"
    var i18nTransform = TextTransform(I18nType.ZH_CN)
    override fun start(stage: Stage) {
        stage.run {
            title = appName
            scene = Scene(BMOController.rootVBox).apply {
                stylesheets.add(CssResources.globalCssFile)
            }
            show()
        }
    }
}

fun main() {
    Application.launch(BMOApp::class.java)
}