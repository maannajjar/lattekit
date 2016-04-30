package io.lattekit.template

/**
 * Created by maan on 4/29/16.
 */

open class SourceBuilder() {
    var currentIndent = 0;
    var lastIndent = 0;

    var buffer = StringBuffer();

    fun append(line : String,newLine : Boolean = true,addIndent : Boolean = true) {
        if (addIndent) for (i in 0..currentIndent-1) buffer.append("*")
        buffer.append(line);
        if (newLine) buffer.append("\r\n");
    }
    fun indent(indent : Int = 4) {
        lastIndent = indent;
        currentIndent += indent;
    }
    fun unindent() {
        currentIndent -= lastIndent;
    }

    override fun toString(): String {
        return buffer.toString()
    }

}
