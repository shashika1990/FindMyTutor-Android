package lk.fmt.findmytutor.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.motion.widget.MotionLayout
import kotlinx.android.synthetic.main.activity_course_details.*
import kotlinx.android.synthetic.main.activity_course_details_start.*
import kotlinx.android.synthetic.main.activity_course_details_start.btnBack
import kotlinx.android.synthetic.main.activity_course_details_start.btnViewProfile
import kotlinx.android.synthetic.main.activity_course_details_start.fabCall
import kotlinx.android.synthetic.main.activity_course_details_start.mainLayout
import kotlinx.android.synthetic.main.activity_course_details_start.txtCourseTitle
import kotlinx.android.synthetic.main.activity_course_details_start.txtDesc
import kotlinx.android.synthetic.main.activity_course_details_start.txtDisplayName
import kotlinx.android.synthetic.main.activity_course_details_start.txtEmail
import kotlinx.android.synthetic.main.activity_course_details_start.txtFullName
import kotlinx.android.synthetic.main.activity_course_details_start.txtGrade
import kotlinx.android.synthetic.main.activity_course_details_start.txtLanguage
import kotlinx.android.synthetic.main.activity_course_details_start.txtPhone
import kotlinx.android.synthetic.main.activity_course_details_start.txtSubject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import lk.fmt.findmytutor.R
import lk.fmt.findmytutor.models.Course

class CourseDetailsActivity : AppCompatActivity() {

    private lateinit var course: Course

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_details_start)

        /*val constraintSet = ConstraintSet()
        constraintSet.clone(this, R.layout.activity_course_details)
        val transition = ChangeBounds()
        transition.duration = 1000
        transition.interpolator = AnticipateOvershootInterpolator()
        TransitionManager.beginDelayedTransition(mainLayout, transition)
        constraintSet.applyTo(mainLayout)*/

        initActivity()
    }


    private fun initActivity() {
        btnBack?.setOnClickListener { super.onBackPressed() }
        fabCall?.setOnClickListener { openDialer() }
        btnViewProfile?.setOnClickListener { navigateToProfileScreen() }

        // bindData()
         animate()
    }


    private fun animate() {
        CoroutineScope(Dispatchers.Main).launch {
            delay(100)
            (mainLayout as MotionLayout).transitionToEnd()
        }
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
     * Go to TutorProfileActivity
     */
    private fun navigateToProfileScreen() {
        Intent(this, TutorProfileActivity::class.java)
            .apply {
                startActivity(this)
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