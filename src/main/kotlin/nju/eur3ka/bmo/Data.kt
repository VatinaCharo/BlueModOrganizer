package nju.eur3ka.bmo

import javafx.scene.control.CheckBox

/**
 * Mod entry
 *
 * @property modName
 * @property typeList
 * @property path
 * @constructor Create empty Mod entry
 */
data class ModEntry(val modName: String, val typeList: List<ModType>, val path: String)

/**
 * BMO file tree node
 *
 * @property prefix
 * @property name
 * @property children
 * @constructor Create default BMO file tree node
 */
data class BMOFileTreeNode(
    var prefix: String,
    val name: String,
    val checkBox: CheckBox,
    val parent: BMOFileTreeNode?,
    val children: MutableList<BMOFileTreeNode>
) {
    constructor(name: String, parent: BMOFileTreeNode?) : this("", name, CheckBox(), parent, mutableListOf())

    /**
     * Get DFS node list
     *
     * @return
     */
    fun getDFSNodeList(): List<BMOFileTreeNode> {
        val nodeList = mutableListOf(this)
        if (this.children.isEmpty()) return nodeList
        children.forEach { nodeList.addAll(it.getDFSNodeList()) }
        return nodeList
    }

    /**
     * Get all parent node list
     *
     * @return nodeList
     */
    fun getAllParentNodeList():List<BMOFileTreeNode> {
        val nodeList = mutableListOf<BMOFileTreeNode>()
        if (parent==null) return nodeList
        return nodeList.apply {
            add(parent)
            addAll(parent.getAllParentNodeList())
        }
    }

    /**
     * Format
     *
     * 格式化输出文本
     *
     * @param prePrefix
     */
    fun format(prePrefix: String) {
        children.forEachIndexed { index, node ->
            if (index != children.size - 1) {
                node.prefix = "$prePrefix├───"
                node.format("$prePrefix│   ")
            } else {
                node.prefix = "$prePrefix└───"
                node.format("$prePrefix    ")
            }
        }
    }

    /**
     * Clear all prefix
     *
     */
    fun clearAllPrefix() {
        this.prefix = ""
        children.forEach { it.clearAllPrefix() }
    }
    fun count():Int{
        if (children.isEmpty()) return 0
        return children.sumOf { it.count() + 1 }
    }
}