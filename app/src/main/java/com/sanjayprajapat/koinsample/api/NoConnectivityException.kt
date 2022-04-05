package com.sanjayprajapat.koinsample.api

import android.content.Context
import com.sanjayprajapat.koinsample.R
import java.io.IOException

class NoConnectivityException (val context: Context): IOException() {

    override val message: String?
        get() = context?.getString(R.string.no_internet_connection)
}

