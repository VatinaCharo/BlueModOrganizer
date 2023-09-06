package nju.eur3ka.bmo

import net.sf.sevenzipjbinding.SevenZip
import net.sf.sevenzipjbinding.impl.RandomAccessFileInStream
import java.io.File
import java.io.RandomAccessFile
import kotlin.test.Test

class CompressorDemo {
    val zipTestFileURL = CompressorDemo::class.java.getResource("zipTest.zip")!!
    val rarTestFileURL = CompressorDemo::class.java.getResource("rarTest.rar")!!
    val szTestFileURL = CompressorDemo::class.java.getResource("7zTest.7z")!!
    val complexZipTestFileURL = CompressorDemo::class.java.getResource("【复杂Zip测试】——露西义体-可选材质颜色版Customizable - Textures-6139-1-1-1669239767.zip")!!
    @Test
    fun readZip(){
        // 结合
        SevenZip.openInArchive(null,RandomAccessFileInStream(RandomAccessFile(File(zipTestFileURL.toURI()),"r"))).use { inArchive ->
            val archive = inArchive.simpleInterface
            println("Num:${archive.numberOfItems}")
            println("   Size   | Compr.Sz. | isFolder | FileName ")
            println("----------+-----------+----------+----------")
            archive.archiveItems.forEach {
                println(String.format("%9s | %9s | %s | %s", it.size, it.packedSize, it.isFolder, it.path))
            }
            println("----------+-----------+---------")
        }
    }
}