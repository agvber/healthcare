package com.sessac.healthcare.data.model.fake

abstract class DummyModel<T> {

    protected abstract fun build(): T
    fun get() = build()
}