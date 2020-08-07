package lk.fmt.findmytutor.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import lk.fmt.findmytutor.R

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initActivity()
    }

    private fun initActivity() {
        layoutTution.setOnClickListener { navigateToTutionScreen() }
        layoutCourses.setOnClickListener { navigateToCoursesScreen() }
    }

    private fun navigateToTutionScreen() {
        Intent(this, CoursesActivity::class.java)
            .apply {
                startActivity(this)
            }
    }

    private fun navigateToCoursesScreen() {
        Intent(this, CoursesActivity::class.java)
            .apply {
                startActivity(this)
            }
    }

}
