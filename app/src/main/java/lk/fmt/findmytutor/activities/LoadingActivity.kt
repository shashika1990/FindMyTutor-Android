package lk.fmt.findmytutor.activities

import android.animation.Animator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_loading.*
import lk.fmt.findmytutor.R

class LoadingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        initActivity()
    }

    private fun initActivity() {
        window.setBackgroundDrawable(ContextCompat.getDrawable(this, R.color.transparent))
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)

        showProgressWheel()
    }

    private fun showProgressWheel() {
        wheel?.setVisibility = View.VISIBLE
        lottieSuccess?.visibility = View.INVISIBLE
    }

    private fun operationSuccess() {
        wheel?.setVisibility = View.GONE
        lottieSuccess?.visibility = View.VISIBLE
        lottieSuccess?.playAnimation()
        lottieSuccess?.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationEnd(animation: Animator?) {
                finishActivity()
            }

            override fun onAnimationRepeat(animation: Animator?) {}
            override fun onAnimationCancel(animation: Animator?) {}
            override fun onAnimationStart(animation: Animator?) {}

        })
    }

    private fun operationFailed() {

    }

    private fun finishActivity() {
        Handler().postDelayed(Runnable {
            finish()
        }, 300)
    }
}