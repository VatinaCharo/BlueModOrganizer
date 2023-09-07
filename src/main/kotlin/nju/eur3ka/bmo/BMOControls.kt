package nju.eur3ka.bmo

import javafx.collections.MapChangeListener
import javafx.scene.control.Label
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import kotlin.io.path.Path
import kotlin.io.path.extension

class BMOTreeView(private val bmoTree: BMOFileTreeNode) {
    private val tree = VBox(10.0)
    fun build(): VBox {
        val lines = bmoTree.getDFSNodeList().map { treeNode ->
            // 根据文件类型构建图标
            val icon = if (treeNode.children.isEmpty()) ICONS.getFileIconByFileExtension(Path(treeNode.name).extension)
            else ICONS.folderIcon()
            icon.iconSize = 18
            // 构建文件树行
            HBox(10.0).apply {
                val prefixLabel = Label(treeNode.prefix)
                val checkBox = treeNode.checkBox.apply {
                    // 默认所有子项全选
                    isSelected = true
                    properties["name"] = treeNode.name
                    properties["count"] = treeNode.count() + 1
                    properties["selected"] = properties["count"]
                }
                val name = Label(treeNode.name)
                children.addAll(prefixLabel, checkBox, icon, name)
            }
        }
        // 设置根节点图标
        lines.first().children[2] = ICONS.zipIcon().apply { iconSize = 18 }
        // 添加文件树显示
        tree.children.addAll(lines)
        // 设置事件响应
        action()
        return tree
    }

    private fun action() {
        bmoTree.getDFSNodeList().forEach { treeNode ->
            treeNode.checkBox.run {
                // 确保不会循环激活事件处理
                var isUserChange = true
                // 设置选中状态数对选中状态的事件处理
                properties.addListener(MapChangeListener {
                    isUserChange = false
                    val selected = it.map["selected"] as Int
                    val count = it.map["count"] as Int
                    isIndeterminate = selected in 1 until count
                    isSelected = selected == count
                    isUserChange = true
                })
                // 设置选中事件对其他项的影响的事件处理
                selectedProperty().addListener { _, oldValue, newValue ->
                    if (oldValue == newValue) return@addListener
                    if (!isUserChange) return@addListener
                    if (newValue) {
                        // 子节点全选
                        treeNode.getDFSNodeList()
                            .forEach { it.checkBox.properties["selected"] = it.checkBox.properties["count"] }
                        // 父节点增加已选数
                        treeNode.getAllParentNodeList().forEach {
                            it.checkBox.apply {
                                properties["selected"] = (properties["selected"] as Int) + 1
                            }
                        }
                    } else {
                        // 子节点全不选
                        treeNode.getDFSNodeList().forEach {
                            it.checkBox.properties["selected"] = 0
                        }
                        // 父节点减少已选数
                        treeNode.getAllParentNodeList().forEach {
                            it.checkBox.apply {
                                properties["selected"] = (properties["selected"] as Int) - 1
                            }
                        }
                    }
                }
            }
        }
    }

    fun getSelectedFileNameList() = bmoTree.getDFSNodeList()
        .filter { it.children.isEmpty() } // 筛选文件节点，去除文件夹节点
        .filter { it.checkBox.isSelected } // 检查是否被选择
        .map { it.name }
}