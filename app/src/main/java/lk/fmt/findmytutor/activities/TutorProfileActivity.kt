package lk.fmt.findmytutor.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import kotlinx.android.synthetic.main.activity_tutor_profile.*
import lk.fmt.findmytutor.R
import lk.fmt.findmytutor.adapters.ExperiencesAdapter
import lk.fmt.findmytutor.adapters.QualificationsAdapter
import lk.fmt.findmytutor.models.Experience
import lk.fmt.findmytutor.models.Qualification

class TutorProfileActivity : AppCompatActivity() {

    private lateinit var qualificationsAdapter: QualificationsAdapter
    private lateinit var experiencesAdapter: ExperiencesAdapter

    private var qualifications: MutableList<Qualification> = mutableListOf()
    private var experiences: MutableList<Experience> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutor_profile)

        initActivity()
    }

    private fun initActivity() {

        for (i in 1..5) {
            qualifications.add(Qualification())
            experiences.add(Experience())
        }

        this.qualificationsAdapter = QualificationsAdapter(qualifications)
        recyclerViewQualifications.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewQualifications.adapter = qualificationsAdapter
        LinearSnapHelper().attachToRecyclerView(recyclerViewQualifications)

        this.experiencesAdapter = ExperiencesAdapter((experiences))
        recyclerViewExperiences.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewExperiences.adapter = experiencesAdapter
        LinearSnapHelper().attachToRecyclerView(recyclerViewExperiences)
    }
}
