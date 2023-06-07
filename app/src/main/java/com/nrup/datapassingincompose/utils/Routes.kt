package com.nrup.datapassingincompose.utils

import com.nrup.datapassingincompose.utils.Routes.Values.SCREEN_VALUE

object Routes {

    const val FIRST_SCREEN = "first_screen"
    const val SECOND_SCREEN = "second_screen/{${SCREEN_VALUE}}"
    const val THIRD_SCREEN = "third_screen"

    fun getSecondScreenPath(myContent: String?): String =
        if (!myContent.isNullOrBlank()) "second_screen/$myContent" else "second_screen/Empty"

    object Values {
        const val SCREEN_VALUE = "myContent"
    }

}