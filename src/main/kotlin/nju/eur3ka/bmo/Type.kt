package nju.eur3ka.bmo

enum class I18nType{
    ZH_CN,
    EN_US;

    override fun toString(): String {
        val strList = super.toString().split("_")
        return "${strList.first().lowercase()}_${strList.last()}"
    }
}
