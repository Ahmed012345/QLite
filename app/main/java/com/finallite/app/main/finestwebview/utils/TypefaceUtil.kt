package com.finallite.app.main.finestwebview.utils

import android.content.Context
import android.graphics.Typeface
import androidx.collection.SimpleArrayMap

/**
 * Created by Leonardo on 11/14/15.
*/

object TypefaceUtil {
    private val cache = SimpleArrayMap<String, Typeface>()

    operator fun get(c: Context, name: String): Typeface? {
        synchronized(cache) {
            return if (!cache.containsKey(name)) {
                try {
                    val t = Typeface.createFromAsset(c.assets, String.format("fonts/%s", name))
                    cache.put(name, t)
                    t
                } catch (e: RuntimeException) {
                    null
                }
            } else cache[name]
        }
    }
}