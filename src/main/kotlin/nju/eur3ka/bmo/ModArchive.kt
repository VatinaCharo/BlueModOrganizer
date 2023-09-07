package nju.eur3ka.bmo

import net.sf.sevenzipjbinding.SevenZip
import net.sf.sevenzipjbinding.impl.RandomAccessFileInStream
import java.io.File
import java.io.RandomAccessFile
import kotlin.io.path.Path
import kotlin.io.path.name

class ModArchive(file: File) {
    private val name = file.nameWithoutExtension
    val modArchiveItemList = SevenZip.openInArchive(
        null,
        RandomAccessFileInStream(RandomAccessFile(file, "r"))
    ).simpleInterface.archiveItems
        .filter { !it.isFolder } //过滤掉纯文件夹
        .sortedBy { if(Path(it.path).nameCount==1) "1" else "0" + it.path } // 按照通常的文件管理器中的顺序来排序

    fun buildModArchiveItemTree(): BMOFileTreeNode {
        val rootModArchiveItemTreeNode = BMOFileTreeNode(name)
        if (modArchiveItemList.isEmpty()) return rootModArchiveItemTreeNode
        var indexTreeItem = rootModArchiveItemTreeNode
        modArchiveItemList.forEach { archiveItem ->
            val path = Path(archiveItem.path)
            if (path.nameCount == 1) {
                // add single file leaf
                indexTreeItem.children.add(BMOFileTreeNode(path.name))
            } else {
                // add folder node
                for (pos in 0 until path.nameCount - 1) {
                    val folder = path.getName(pos)
                    // if folder exist, go next
                    val mayExistChildTreeItem = indexTreeItem.children.find{ it.name == folder.name }
                    if (mayExistChildTreeItem!=null){
                        indexTreeItem = mayExistChildTreeItem
                        continue
                    }
                    val childTreeItem = BMOFileTreeNode(folder.name)
                    indexTreeItem.children.add(childTreeItem)
                    indexTreeItem = childTreeItem
                }
                // add file leaf
                indexTreeItem.children.add(BMOFileTreeNode(path.name))
                indexTreeItem = rootModArchiveItemTreeNode
            }
        }
        // 格式化显示
        rootModArchiveItemTreeNode.format("")
        return rootModArchiveItemTreeNode
    }
}