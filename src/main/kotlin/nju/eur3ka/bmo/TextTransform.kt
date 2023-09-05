package nju.eur3ka.bmo

import java.nio.charset.Charset

class TextTransform(local:I18nType) {
    private val i18nResource = BMOApp::class.java.getResource("lang/${local}.lang")?:throw NoSuchFieldException("Not find /lang/${local}.lang")
    private val i18nContent = i18nResource.openStream().readAllBytes().toString(Charset.defaultCharset()).split("\n").filter { it.contains("=") }
    private val textTransformMap = i18nContent.associate {
        val pair = it.split("=")
        pair.first() to pair.last()
    }

    fun transform(identifier: String) = textTransformMap[identifier]?:identifier
}