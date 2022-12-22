package com.ottogroup.nhcc

import android.os.Bundle
import android.os.Parcelable
import androidx.core.os.bundleOf
import kotlinx.parcelize.Parcelize

@Parcelize
sealed interface SomeSealedInterface : NavArgs, Parcelable {
    val text: String
    val number: Int

    @Parcelize
    data class A(
        override val text: String,
        override val number: Int
    ) : SomeSealedInterface

    @Parcelize
    data class B(
        override val text: String,
        override val number: Int
    ) : SomeSealedInterface

    override fun toBundle(): Bundle {
        return bundleOf(SomeSealedInterface::class.java.simpleName to this)
    }

    companion object : NavArgs.Creator<SomeSealedInterface> {
        @JvmStatic
        override fun fromBundle(bundle: Bundle): SomeSealedInterface {
            return checkNotNull(bundle.getParcelable(SomeSealedInterface::class.java.simpleName)) { "NavArgs are not present" }
        }
    }
}

interface NavArgs : androidx.navigation.NavArgs {
    fun toBundle(): Bundle
    interface Creator<T> {
        fun fromBundle(bundle: Bundle): T
    }
}