package org.jetbrains.dataframe.impl.columns.missing

import org.jetbrains.dataframe.ColumnResolutionContext
import org.jetbrains.dataframe.columns.ColumnWithPath
import org.jetbrains.dataframe.columns.DataColumn
import kotlin.reflect.KType

internal abstract class MissingDataColumn<T> : DataColumn<T> {

    val name: String
        get() = throw UnsupportedOperationException()
    override val values: Iterable<T>
        get() = throw UnsupportedOperationException()
    override val ndistinct: Int
        get() = throw UnsupportedOperationException()
    override val type: KType
        get() = throw UnsupportedOperationException()
    override val size: Int
        get() = throw UnsupportedOperationException()

    override fun name() = name

    override fun get(index: Int) = throw UnsupportedOperationException()

    override fun defaultValue() = throw UnsupportedOperationException()

    override fun slice(range: IntRange) = throw UnsupportedOperationException()

    override fun get(columnName: String) = throw UnsupportedOperationException()

    override fun slice(indices: Iterable<Int>) = throw UnsupportedOperationException()

    override fun slice(mask: BooleanArray) = throw UnsupportedOperationException()

    override fun toSet() = throw UnsupportedOperationException()

    override fun resolve(context: ColumnResolutionContext) = emptyList<ColumnWithPath<T>>()
}