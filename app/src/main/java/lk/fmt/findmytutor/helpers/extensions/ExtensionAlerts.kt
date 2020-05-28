package lk.fmt.findmytutor.helpers.extensions

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.andrognito.flashbar.Flashbar
import lk.fmt.findmytutor.R

fun AppCompatActivity.snackbarError(message: String) {
    Flashbar.Builder(this)
        .gravity(Flashbar.Gravity.TOP)
        .title("Oops!")
        .message(message)
        .backgroundColor(Color.RED)
        .duration(Flashbar.DURATION_LONG)
        .build()
        .show()
}


fun AppCompatActivity.snackbarSuccess(message: String){
    Flashbar.Builder(this)
        .gravity(Flashbar.Gravity.TOP)
        .title("Huzza!")
        .message(message)
        .backgroundColor(ContextCompat.getColor(this, R.color.green_dark))
        .duration(Flashbar.DURATION_LONG)
        .build()
        .show()
}