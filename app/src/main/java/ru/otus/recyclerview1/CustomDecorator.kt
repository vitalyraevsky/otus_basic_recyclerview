package ru.otus.recyclerview1

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

class CustomDecorator : ItemDecoration() {

    private val bounds = Rect()
    private val paint = Paint().apply {
        color = Color.BLACK
        strokeWidth = 8f
    }

    override fun onDraw(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(canvas, parent, state)

        val childCount = parent.childCount
        for (index in 0 until childCount) {
            val child = parent.getChildAt(index)
            parent.getDecoratedBoundsWithMargins(child, bounds)

            val positionCurrent = parent.getChildAdapterPosition(child)
            if (positionCurrent != RecyclerView.NO_POSITION) {
                val lastElementPosition = parent.adapter?.itemCount?.minus(1)
                if (positionCurrent != lastElementPosition) {
                    canvas.drawLine(
                        bounds.left.toFloat(),
                        bounds.bottom.toFloat(),
                        bounds.right.toFloat(),
                        bounds.bottom.toFloat(),
                        paint
                    )
                }
            }
        }
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        //super.getItemOffsets(outRect, view, parent, state)
        val paddingLeft = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            40f,
            view.context.resources.displayMetrics
        )
        outRect.apply {
            left = paddingLeft.toInt()
            right = 0
            top = 25
            bottom = 0
        }
    }
}