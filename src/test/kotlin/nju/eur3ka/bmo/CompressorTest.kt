package nju.eur3ka.bmo

import java.util.zip.ZipFile
import kotlin.test.Test

class CompressorTest {
    val zipTestFile = CompressorTest::class.java.getResource("zipTest.zip")!!.openStream()
    val rarTestFile = CompressorTest::class.java.getResource("rarTest.rar")!!.openStream()
    val z7TestFile = CompressorTest::class.java.getResource("7zTest.7z")!!.openStream()
    val complexZipTestFile =
        CompressorTest::class.java.getResource("【复杂Zip测试】——露西义体-可选材质颜色版Customizable - Textures-6139-1-1-1669239767.zip")!!
            .openStream()
    @Test
    fun readZip() {
    }
}