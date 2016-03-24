package io.lattekit.util

/**
 * Created by maan on 2/23/16.
 */

fun regex(init: RegexBuilder.() -> Unit): RegexBuilder {
    val re = RegexBuilder()
    re.init()
    return re
}


class RegexBuilder() {
    var children : MutableList<Any> = mutableListOf()
    var matchResult : MatchResult? = null
    var groups : MutableMap<String,Int> = mutableMapOf()
    var modifier : String? = ""
    var groupName : String? = null;
    val regEx : Regex by lazy {
        Regex(build())
    }

    fun group(name : String, modifier : String = "", init: RegexBuilder.() -> Unit): RegexBuilder {
        val group = RegexBuilder()
        group.groupName = name
        group.modifier = modifier
        children.add(group)
        group.init()
        return this
    }
    fun group(name : String, pattern : String = "", modifier : String = ""): RegexBuilder {
        val group = RegexBuilder()
        group.groupName = name
        group.modifier = modifier
        group.children.add(pattern)
        children.add(group)
        return this
    }

    fun group(modifier : String = "", init: RegexBuilder.() -> Unit): RegexBuilder {
        val group = RegexBuilder()
        group.groupName = null
        group.modifier = modifier
        children.add(group)
        group.init()
        return this
    }

    fun group(init: RegexBuilder.() -> Unit): RegexBuilder {
        val group = RegexBuilder()
        group.groupName = null
        group.modifier = ""
        children.add(group)
        group.init()
        return this
    }
    fun pattern(pattern: String) : RegexBuilder {
        children.add(pattern)
        return this
    }
    fun build() : String {
        var buffer = StringBuilder()
        this.groups.clear()
        build( buffer, this.groups)
        return buffer.toString()
    }
    fun build(buffer : StringBuilder, groupMap : MutableMap<String,Int>) {
        groupMap.put(groupName ?: groupMap.keys.size.toString(), groupMap.keys.size)
        children.forEach {
            if (it is String) {
                buffer.append(it)
            } else if (it is RegexBuilder) {
                buffer.append("(")
                it.build(buffer,groupMap)
                buffer.append(")")
                if (it.modifier != null) {
                    buffer.append(it.modifier)
                }
            }
        }
    }

    fun match(str : String) : RegexBuilder {
        matchResult = regEx.matchEntire(str)
        return this
    }

    fun get(str : String) : String? {
        var value = matchResult?.groupValues?.get(groups.get(str)!!)
        return if (value == "") null else value
    }

    fun getGroupValues() : Map<String,String?> {
        var results = mutableMapOf<String,String?>()
        groups.forEach { var (groupName, groupNumber) = it;
            results.put(groupName,get(groupName))
        }
        return results
    }
}
