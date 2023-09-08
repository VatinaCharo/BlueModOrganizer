package nju.eur3ka.bmo

import java.nio.charset.Charset

class TextTransform(local:I18nType) {
    private val i18nResource = BMOApp::class.java.getResource("lang/${local}.lang")?:throw NoSuchFieldException("Not find /lang/${local}.lang")
    private val i18nContent = i18nResource.openStream().readAllBytes().toString(Charset.defaultCharset())
        .replace("\r\n","\n").replace("\r","\n") // 统一换行符
        .split("\n") // 行切割文本
        .filter { it.contains("=") } // 过滤有效键值对
    private val textTransformMap = i18nContent.associate {
        val pair = it.split("=")
        pair.first() to pair.last()
    }
    fun debug(){
        println("i18nContent")
        i18nContent.forEach(::println)
        println("textTransformMap")
        textTransformMap.forEach(::println)
    }

    fun transform(identifier: String) = textTransformMap[identifier]?:identifier
}