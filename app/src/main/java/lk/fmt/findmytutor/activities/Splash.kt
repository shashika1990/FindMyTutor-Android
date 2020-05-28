package lk.fmt.findmytutor.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import lk.fmt.findmytutor.R

class Splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        /*Handler().postDelayed(
            {
                Intent(this, SignInActivity::class.java).apply {
                    startActivity(this)
                    finish()
                }
            },
            100000
        )*/

        Intent(this, SignInActivity::class.java).apply {
            startActivity(this)
            finish()
        }
    }
}
