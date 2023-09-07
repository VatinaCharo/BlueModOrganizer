package nju.eur3ka.bmo

import javafx.application.Application
import javafx.stage.Stage
import org.junit.jupiter.api.Test

import java.io.File

object BMOFileTreeNodeTest {
    val zipFileURI = BMOFileTreeNodeTest::class.java.getResource("rarTest.rar")!!.toURI()
    val modArchive = ModArchive(File(zipFileURI))

    class App : Application() {
        override fun start(primaryStage: Stage) {
            modArchive.buildModArchiveItemTree().run {
                this.children.first()
                    .children.first()
                    .children.first()
                    .children.first()
                    .getAllParentNodeList().reversed().forEach {
                        println(it.prefix + it.name)
                    }
            }
            primaryStage.show()
        }

    }

    @Test
    fun getAllParentNodeListTest() {
        Application.launch(App::class.java)
    }
}