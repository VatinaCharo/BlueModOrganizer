package nju.eur3ka.bmo

import kotlin.test.assertEquals
import kotlin.test.Test

class TextTransformTest {

    @Test
    fun transform() {
        val transformer = TextTransform(I18nType.zh_CN)
        assertEquals(transformer.transform("button.profile"),"档案")
        assertEquals(transformer.transform("btn.setting"),"btn.setting")
    }
    @Test
    fun debug(){
        println("============ DEBUG ============")
        TextTransform(I18nType.zh_CN).debug()
        println("============ DEBUG ============")
    }
}