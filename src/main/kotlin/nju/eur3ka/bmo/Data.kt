package nju.eur3ka.bmo

data class ModEntry(val modName: String, val typeList: List<ModType>, val version: String)

data class BMOFileTreeNode(var prefix: String, val name: String, val children: MutableList<BMOFileTreeNode>) {
    constructor(name: String) : this("", name, mutableListOf())

    fun getDFSNodeList(): List<BMOFileTreeNode> {
        val nodeList = mutableListOf(this)
        if (this.children.isEmpty()) return nodeList
        children.forEach { nodeList.addAll(it.getDFSNodeList()) }
        return nodeList
    }

    fun format(prePrefix: String) {
        children.forEachIndexed { index, node ->
            if (index != children.size - 1){
                node.prefix = "$prePrefix├──"
                node.format("$prePrefix│  ")
            }else{
                node.prefix = "$prePrefix└──"
                node.format("$prePrefix   ")
            }
        }
    }
    fun clearAllPrefix(){
        this.prefix = ""
        children.forEach { it.clearAllPrefix() }
    }
}