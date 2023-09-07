package nju.eur3ka.bmo

import javafx.scene.control.CheckBoxTreeItem
import javafx.scene.control.TreeItem
import net.sf.sevenzipjbinding.SevenZip
import net.sf.sevenzipjbinding.impl.RandomAccessFileInStream
import org.kordamp.ikonli.javafx.FontIcon
import org.kordamp.ikonli.materialdesign2.MaterialDesignF
import org.kordamp.ikonli.materialdesign2.MaterialDesignZ
import java.io.File
import java.io.RandomAccessFile
import kotlin.io.path.Path
import kotlin.io.path.extension
import kotlin.io.path.name

class ModArchive(file: File) {
    private val name = file.nameWithoutExtension
    val modArchiveItemList = SevenZip.openInArchive(
        null,
        RandomAccessFileInStream(RandomAccessFile(file, "r"))
    ).simpleInterface.archiveItems.filter { !it.isFolder }.sortedBy { it.path }
    val isEmpty = modArchiveItemList.isEmpty()

    fun readModArchiveItemTree(): CheckBoxTreeItem<String> {
        val rootModArchiveItemTreeNode = CheckBoxTreeItem(name, FontIcon(MaterialDesignZ.ZIP_BOX))
        var indexTreeItem = rootModArchiveItemTreeNode
        if (isEmpty) return rootModArchiveItemTreeNode
        modArchiveItemList.forEach { archiveItem ->
            val path = Path(archiveItem.path)
            if (path.nameCount == 1) {
                // add single file leaf
                indexTreeItem.children.add(CheckBoxTreeItem(path.name, ICONS.getFileIconByFileExtension(path.extension)))
            } else {
                // add folder node
                for (pos in 0 until path.nameCount - 1) {
                    val folder = path.getName(pos)
                    // if folder exist, go next
                    val mayExistChildTreeItem = indexTreeItem.children.find{ it.value == folder.name }
                    if (mayExistChildTreeItem!=null){
                        indexTreeItem = mayExistChildTreeItem as CheckBoxTreeItem<String>
                        continue
                    }
                    val childTreeItem = CheckBoxTreeItem(folder.name, FontIcon(MaterialDesignF.FOLDER))
                    indexTreeItem.children.add(childTreeItem)
                    indexTreeItem = childTreeItem
                }
                // add file leaf
//                indexTreeItem.children.add(CheckBoxTreeItem(path.name, ICONS.getFileIconByFileExtension(path.extension)))
                indexTreeItem.children.add(CheckBoxTreeItem(path.name, ICONS.getFileIconByFileExtension(path.extension)))
                indexTreeItem = rootModArchiveItemTreeNode
            }
        }
        return rootModArchiveItemTreeNode
    }
}