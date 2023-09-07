package nju.eur3ka.bmo

data class ModEntry(val modName:String,val typeList: List<ModType>,val version:String)

data class FileTreeNode(val fileName:String, val children:MutableList<FileTreeNode>){
}