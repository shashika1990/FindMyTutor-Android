package lk.fmt.findmytutor.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import lk.fmt.findmytutor.R
import lk.fmt.findmytutor.listeners.RecyclerViewItemListener
import lk.fmt.findmytutor.models.Course

class CoursesAdapter(private val courseList: List<Course>, private val listener: RecyclerViewItemListener) :
    RecyclerView.Adapter<CoursesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.widget_course_card, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return courseList.size
//        return 10
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(position, courseList[position], listener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var courseTitle: TextView = itemView.findViewById(R.id.txtTitle)
        var subject: TextView = itemView.findViewById(R.id.txtSubject)
        var tutorName: TextView = itemView.findViewById(R.id.txtTutorName)
        var medium: TextView = itemView.findViewById(R.id.txtLanguage)
        var venue: TextView = itemView.findViewById(R.id.txtVenue)
        var location: TextView = itemView.findViewById(R.id.txtLocation)

        fun bindData(position: Int, course: Course, listener: RecyclerViewItemListener) {
            itemView.setOnClickListener { listener.onItemClicked(position) }
        }

    }

}