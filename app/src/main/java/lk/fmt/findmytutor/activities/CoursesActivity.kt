package lk.fmt.findmytutor.activities

import android.content.Intent
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_courses.*
import kotlinx.android.synthetic.main.layout_toolbar_with_back.*
import lk.fmt.findmytutor.R
import lk.fmt.findmytutor.adapters.CoursesAdapter
import lk.fmt.findmytutor.helpers.mappers.Mapper
import lk.fmt.findmytutor.listeners.APIServiceListener
import lk.fmt.findmytutor.listeners.RecyclerViewItemListener
import lk.fmt.findmytutor.models.Course
import lk.fmt.findmytutor.services.api.responsemodels.CoursesResponse
import lk.fmt.findmytutor.services.api.service.CourseServiceImpl

class CoursesActivity : AppCompatActivity(), RecyclerViewItemListener, APIServiceListener {

    private var courseList: MutableList<Course> = mutableListOf()
    private lateinit var adapter: CoursesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)

        initActivity()
    }

    private fun initActivity() {
        recyclerView?.let {
            adapter = CoursesAdapter(courseList, this)
            it.adapter = this.adapter
            it.layoutManager = LinearLayoutManager(this)
            it.addItemDecoration(DividerItemDecoration())
        }

        fetchCourses()

        btnBack?.setOnClickListener { super.onBackPressed() }
        toolbarTitle?.text = resources.getText(R.string.tution)
    }

    private fun fetchCourses() {
        CourseServiceImpl(this).getCourses(10, 0)
    }

    class DividerItemDecoration : RecyclerView.ItemDecoration() {
        private var verticalSpace = 40

        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            super.getItemOffsets(outRect, view, parent, state)

            if (parent.getChildAdapterPosition(view) == 0) {
                outRect.top = verticalSpace
            }

            outRect.bottom = verticalSpace
        }
    }

    /**
     * Open the CourseDetailsActivity and pass the course details for the selected course
     * @param position index of the selected course from the course list
     */
    override fun onItemClicked(position: Int) {
        Intent(this, CourseDetailsActivity::class.java).apply {
            // putExtra("course", courseList[position])
            startActivity(this)
        }
    }

    override fun <T> onSuccess(data: T?) {
        data?.let {
            val res = data as List<CoursesResponse>

            for (item in res) {
                courseList.add(Mapper.map(item))
            }

            adapter.notifyItemRangeInserted(courseList.size - res.size, res.size)
        }
    }

    override fun onFailure(message: String) {

    }

    override fun onError(message: String) {

    }

}