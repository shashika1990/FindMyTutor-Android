package lk.fmt.findmytutor.helpers.ui

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import androidx.appcompat.widget.AppCompatImageView

class FMTRotatingImageView(context: Context, attr: AttributeSet) :
    AppCompatImageView(context, attr) {

    private fun startAnimation() {
        val rotate = RotateAnimation(
            0F,
            180F,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        rotate.duration = 1000
        rotate.interpolator = AccelerateDecelerateInterpolator()
        rotate.repeatCount = Animation.INFINITE
        this.startAnimation(rotate)
    }

    var setVisibility: Int = View.GONE
        set(value) {
            if (View.VISIBLE == value) {
                super.setVisibility(View.VISIBLE)
                startAnimation()
            } else if (View.GONE == value) {
                super.setVisibility(View.GONE)
                clearAnimation()
            }
            field = value
        }

}