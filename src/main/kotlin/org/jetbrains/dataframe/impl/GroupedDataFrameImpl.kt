package org.jetbrains.dataframe.impl

import org.jetbrains.dataframe.*

class GroupedDataFrameImpl<T, G>(val df: DataFrame<T>, override val groups: TableColumn<G>): GroupedDataFrame<T, G> {
    override val keys by lazy { df - groups }

    override operator fun get(key: GroupKey): DataFrame<T> {

        require(key.size < df.ncol) { "Invalid size of the key" }

        val keySize = key.size
        val filtered = df.filter { values.subList(0, keySize) == key }
        return filtered[groups].values.union().typed<T>()
    }

    override fun <R> modify(transform: DataFrame<G>.() -> DataFrame<R>) =
            df.update(groups) { transform(it) }.toGrouped { groups.typed<R>() }

    override fun asPlain() = df
}