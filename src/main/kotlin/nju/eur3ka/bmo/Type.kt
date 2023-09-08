package nju.eur3ka.bmo

enum class I18nType{
    zh_CN,
    en_US;
}
enum class ModType{
    NATIVE,
    CET,
    ARCHIVE,
    REDSCRIPT,
    RED4EXT,
    OTHER;

    override fun toString(): String {
        return super.toString().lowercase()
    }
}