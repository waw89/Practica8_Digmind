package luis.contreras.example.practica8_contreras.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import luis.contreras.example.practica8_contreras.R
import luis.contreras.example.practica8_contreras.databinding.FragmentDashboardBinding
import luis.contreras.example.practica8_contreras.ui.Task
import luis.contreras.example.practica8_contreras.ui.home.HomeFragment

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val btn_save: Button = root.findViewById(R.id.done)
        val et_title: EditText = root.findViewById(R.id.name)
        val et_time: EditText = root.findViewById(R.id.time)
        val checkMonday: CheckBox = root.findViewById(R.id.mondayCheck)
        val checkTuesday: CheckBox = root.findViewById(R.id.tuesdayCheck)
        val checkWednesday: CheckBox = root.findViewById(R.id.wednesdayCheck)
        val checkThursday: CheckBox = root.findViewById(R.id.thursdayCheck)
        val checkFriday: CheckBox = root.findViewById(R.id.fridayCheck)
        val checkSaturday: CheckBox = root.findViewById(R.id.saturdayCheck)
        val checkSunday: CheckBox = root.findViewById(R.id.sundayCheck)

        btn_save.setOnClickListener {
            var days = ArrayList<String>()
            var title = et_title.text.toString()
            var time = et_time.text.toString()

            if (checkMonday.isChecked){
                days.add("Monday")
            }
            if (checkTuesday.isChecked){
                days.add("Tuesday")
            }
            if (checkWednesday.isChecked){
                days.add("Wednesday")
            }
            if (checkThursday.isChecked){
                days.add("Thursday")
            }
            if (checkFriday.isChecked){
                days.add("Friday")
            }
            if (checkSaturday.isChecked){
                days.add("Saturday")
            }
            if (checkSunday.isChecked){
                days.add("Sunday")
            }
            var task = Task(title, days, time)

            HomeFragment.tasks.add(task)

            Toast.makeText(root.context, "New task added!", Toast.LENGTH_SHORT).show()


        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}