package nju.eur3ka.bmo

data class ModEntry(val modName:String,val typeList: List<ModType>,val version:String)

data class BMOFileTreeNode(val layer:Int, val name:String, val children:MutableList<BMOFileTreeNode>){
    fun getDFSNodeList():List<BMOFileTreeNode>{
        val nodeList = mutableListOf(this)
        if (this.children.isEmpty()) return nodeList
        children.forEach { nodeList.addAll(it.getDFSNodeList()) }
        return nodeList
    }
}