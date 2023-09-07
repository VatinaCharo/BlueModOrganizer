package nju.eur3ka.bmo

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.CheckBoxTreeItem
import javafx.scene.control.TreeView
import javafx.scene.control.cell.CheckBoxTreeCell
import javafx.stage.Stage
import net.sf.sevenzipjbinding.SevenZip
import net.sf.sevenzipjbinding.impl.RandomAccessFileInStream
import java.io.File
import java.io.RandomAccessFile
import kotlin.io.path.Path
import kotlin.io.path.name
import kotlin.test.Test

object CompressorDemo {
    val zipTestFileURL = CompressorDemo::class.java.getResource("zipTest.zip")!!
    val rarTestFileURL = CompressorDemo::class.java.getResource("rarTest.rar")!!
    val szTestFileURL = CompressorDemo::class.java.getResource("7zTest.7z")!!
    val complexZipTestFileURL = CompressorDemo::class.java.getResource("【复杂Zip测试】——露西义体-可选材质颜色版Customizable - Textures-6139-1-1-1669239767.zip")!!
    @Test
    fun readZip(){
        val file = File(rarTestFileURL.toURI())
        // 结合测试结果，某些zip格式不支持显示文件夹，采用读取实际文件来重建文件树
        SevenZip.openInArchive(null,RandomAccessFileInStream(RandomAccessFile(file,"r"))).use { inArchive ->
            val archive = inArchive.simpleInterface
            println("Name:${file.nameWithoutExtension} Extension:${file.extension} Num:${archive.numberOfItems}")
            println("   Size   | Compr.Sz. | isFolder  | FileName ")
            println("----------+-----------+-----------+----------")
            archive.archiveItems.forEach {
                println(String.format("%9s | %9s | %9s | %s", it.size, it.packedSize, it.isFolder, it.path))
            }
            println("----------+-----------+-----------+----------")
        }
    }
    class ReadZipDemoApp:Application() {
        override fun start(primaryStage: Stage) {
            val mod =  ModArchive(File(rarTestFileURL.toURI()))
            primaryStage.run {
                title = "readZip Demo"
                scene = Scene(TreeView<String>().apply {
                    root = mod.readModArchiveItemTree()
                    root.isExpanded = true
                    cellFactory = CheckBoxTreeCell.forTreeView()
                })
                show()
            }
        }
    }
    @Test
    fun readZipAndShow(){
        Application.launch(ReadZipDemoApp::class.java)
    }
}