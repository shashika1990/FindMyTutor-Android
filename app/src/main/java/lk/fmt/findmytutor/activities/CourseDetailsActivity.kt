package lk.fmt.findmytutor.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_course_details.*
import lk.fmt.findmytutor.R
import lk.fmt.findmytutor.models.Course

class CourseDetailsActivity : AppCompatActivity() {

    private lateinit var course: Course

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_details)

        initActivity()
    }

    private fun initActivity() {
        btnBack?.setOnClickListener { super.onBackPressed() }
        fabCall?.setOnClickListener { openDialer() }

        bindData()
    }

    /**
     * Binds course details to the UI
     */
    private fun bindData() {
        course = intent.getParcelableExtra("course")!!

        txtCourseTitle?.text = course.title
        txtSubject?.text = course.subject
        txtLanguage?.text = course.mediumClient
        txtGrade?.text = course.grade
        chipDate?.text = String.format("%s | %s", course.day, course.time)
        chipLocation?.text = String.format("%s, %s", course.city, course.district)
        txtDisplayName?.text = course.tutor?.displayName
        txtFullName?.text = course.tutor?.fullName
        txtPhone?.text = course.tutor?.mobile
        txtEmail?.text = course.tutor?.email
        course.description?.let {
            if (it.isNotEmpty()) txtDesc?.text = course.description
            else txtDesc?.text = "N/A"
        }
    }

    /**
     * Opens a phone number with the dialer
     */
    private fun openDialer() {
        course.tutor?.mobile?.let { phoneNumber ->
            val uri = Uri.parse("tel:$phoneNumber")
            Intent(Intent.ACTION_DIAL, uri).apply {
                startActivity(this)
            }
        }
    }

}