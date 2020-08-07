package lk.fmt.findmytutor.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import lk.fmt.findmytutor.R
import lk.fmt.findmytutor.models.Experience

class ExperiencesAdapter(private val experiences: List<Experience>) : RecyclerView.Adapter<ExperiencesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.widget_experience_card, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = experiences.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}