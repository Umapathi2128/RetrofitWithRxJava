package com.uma.retrofitwithrxjava.ui

import android.view.View
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.uma.retrofitwithrxjava.ui.TopDissolveLayoutManager


/**
 * Author     : Umapathi
 * Email      : umapathir2@gmail.com
 * Github     : https://github.com/umapathi2128
 * Created on : 2020-10-09.
 */
class StartSnapHelper : LinearSnapHelper() {
    override fun calculateDistanceToFinalSnap(
        layoutManager: RecyclerView.LayoutManager,
        targetView: View
    ): IntArray {
        val out = IntArray(2)
        out[0] = 0
        out[1] = (layoutManager as TopDissolveLayoutManager).getSnapHeight()
        return out
    }

    override fun findSnapView(layoutManager: RecyclerView.LayoutManager): View? {
        val custLayoutManager = layoutManager as TopDissolveLayoutManager
        return custLayoutManager.findSnapView()
    }
}