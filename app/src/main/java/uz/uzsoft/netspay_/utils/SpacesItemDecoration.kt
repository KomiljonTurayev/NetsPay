package com.example.kidya_example.util

import android.content.res.Resources
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SpacesItemDecoration(
    private val space: Int,
    private val vertical: Boolean = false,
    val span: Int,
    val grid: Boolean = false
) : RecyclerView.ItemDecoration() {


    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val itemPosition = parent.getChildLayoutPosition(view)

        val dpSpace= dpToPx(space)
        if (span == 3) {
            if (itemPosition == 0) {
                outRect.left = dpSpace * 2
                outRect.top = dpSpace * 2 - dpSpace / 2
                outRect.right = dpSpace * 2 - dpSpace / 2
                outRect.bottom = dpSpace * 2 - dpSpace / 2

            } else {
                if (itemPosition == 1) {
//                outRect.left = dpToPx(space)
                    outRect.right = dpSpace * 2
                    outRect.top = dpSpace * 2 - dpSpace / 2
                    outRect.bottom = dpSpace * 2 -dpSpace / 2
//            outRect.top = space * 2 + space / 2
                } else {
                    if (itemPosition % 2 == 0) {
                        outRect.left = dpSpace * 2
                        outRect.bottom = dpSpace * 2 - dpSpace / 2
                        outRect.right = dpSpace * 2 - dpSpace / 2

                    } else {
                        if (itemPosition % 2 != 0) {
                            outRect.right = dpSpace * 2
                            outRect.bottom = dpSpace * 2 -dpSpace / 2
                        }
                    }
                }
            }
        } else {

            if (span == 2) {

                if (itemPosition == 0) {
                    outRect.left = dpSpace * 2
                    outRect.top = dpSpace
                    outRect.right = dpSpace
                    outRect.bottom = dpSpace * 2 - dpSpace / 2

                } else {
                    outRect.top = dpSpace
                    outRect.right = dpSpace
                    outRect.bottom = dpSpace * 2 -dpSpace / 2

                }

            } else

                if (vertical) {
//            outRect.left = space
//            outRect.right = space

                    if (itemPosition == 0) {
                        outRect.left = dpSpace * 2
                        outRect.right = dpSpace * 2
                        outRect.bottom = dpSpace * 2 - dpSpace / 2
                    } else {
                        outRect.left = dpSpace * 2
                        outRect.right = dpSpace * 2
                        outRect.bottom =dpSpace * 2 - dpSpace / 2
                        outRect.top = 0
                    }
                } else
                    if (itemPosition == 0) {
                        outRect.left = dpSpace * 2
//            outRect.top = space * 2 + space / 2
                        outRect.right = dpSpace / 2
//            outRect.bottom = space * 2 + space / 2

                    } else {
                        outRect.left = dpSpace
                        outRect.right = dpSpace / 2
//            outRect.top = space * 2 + space / 2
//            outRect.bottom = space * 2 + space / 2
                    }
        }
    }
}

fun dpToPx(dp: Int): Int {
    return (dp * Resources.getSystem().displayMetrics.density).toInt()
}

