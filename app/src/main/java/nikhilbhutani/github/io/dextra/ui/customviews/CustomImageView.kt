package nikhilbhutani.github.io.dextra.ui.customviews

import android.content.Context
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet
import android.view.View


class CustomImageView : AppCompatImageView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val d = drawable
        if (d != null) {
            val w = View.MeasureSpec.getSize(widthMeasureSpec)
            val h = w * d.intrinsicHeight / d.intrinsicWidth
            setMeasuredDimension(w, h)
        } else
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }
}