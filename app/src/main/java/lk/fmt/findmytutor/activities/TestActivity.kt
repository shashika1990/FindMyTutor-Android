package lk.fmt.findmytutor.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.layout_filter_classes.*
import lk.fmt.findmytutor.R

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        toggleTutionType.addOnButtonCheckedListener { group, checkedId, isChecked ->
            Log.d("Toggle Button", checkedId.toString())

            when (checkedId) {
                R.id.individual -> {
                }
                R.id.group -> {
                }
                R.id.mass -> {
                }
            }
        }
    }
}
