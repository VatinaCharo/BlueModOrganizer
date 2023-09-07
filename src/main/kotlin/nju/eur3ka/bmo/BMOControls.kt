package nju.eur3ka.bmo

import javafx.scene.control.Label
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import org.kordamp.ikonli.javafx.FontIcon
import org.kordamp.ikonli.materialdesign2.MaterialDesignF
import org.kordamp.ikonli.materialdesign2.MaterialDesignZ
import kotlin.io.path.Path
import kotlin.io.path.extension

class BMOTreeView(val bmoTree:BMOFileTreeNode){
    fun build():VBox{
        val tree = VBox(10.0).apply {
            val lines = bmoTree.getDFSNodeList().map {
                HBox(10.0).apply {
                    val icon =
                        if (it.children.isEmpty())
                            ICONS.getFileIconByFileExtension(Path(it.name).extension)
                        else
                            FontIcon(MaterialDesignF.FOLDER)
                    children.addAll(Label("  ".repeat(it.layer)), icon, Label(it.name))
                }
            }
            lines.first().children[1] = FontIcon(MaterialDesignZ.ZIP_BOX)
            children.addAll(lines)
        }
        return tree
    }
}