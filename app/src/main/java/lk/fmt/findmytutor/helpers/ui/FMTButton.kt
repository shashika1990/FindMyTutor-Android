package lk.fmt.findmytutor.helpers.ui

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import androidx.appcompat.widget.AppCompatButton

class FMTButton(context: Context, attr: AttributeSet) : AppCompatButton(context, attr) {

    private var buttonTxt: String = this.text.toString()
    private var isVisible: Boolean = true


    private fun startAnimation(toWidth: Float, fromWidth: Float) {
        val scale = ScaleAnimation(
            fromWidth,
            toWidth,
            1f,
            1f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )

        scale.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationEnd(animation: Animation?) {
                if (!isVisible) {
                    this@FMTButton.setVisibility = View.INVISIBLE
                } else {
                    this@FMTButton.text = buttonTxt
                }
            }

            override fun onAnimationRepeat(animation: Animation?) {}

            override fun onAnimationStart(animation: Animation?) {
                if (isVisible) {
                    this@FMTButton.setVisibility = View.VISIBLE
                } else {
                    this@FMTButton.text = ""
                }
            }
        })

        scale.duration = 300
        scale.interpolator = AccelerateDecelerateInterpolator()
        scale.isFillEnabled = true
        scale.fillAfter = true
        this.startAnimation(scale)
    }

    private var setVisibility: Int = View.VISIBLE
        set(value) {
            if (View.VISIBLE == value) {
                super.setVisibility(View.VISIBLE)
            } else if (View.INVISIBLE == value) {
                super.setVisibility(View.INVISIBLE)
            }
            field = value
        }

    fun setVisibility(isVisible: Boolean) {
        if (isVisible) {
            this.isVisible = true
            startAnimation(1f, 0f)
        } else {
            this.isVisible = false
            startAnimation(0f, 1f)
        }
    }

}