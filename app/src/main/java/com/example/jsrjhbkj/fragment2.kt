import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.jsrjhbkj.R

class fragment2 : Fragment() {

    private lateinit var notesTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fragment2, container, false)

        notesTextView = view.findViewById(R.id.notesTextView)

        // Load existing notes (if any) and display them in the TextView
        // For example, you can load notes from SharedPreferences or a database
        val notesText = "Blood is a specialized body fluid. It has four main components: plasma, red blood cells, white blood cells, and platelets. Blood has many different functions, including:\n" +
                "\n" +
                "1. transporting oxygen and nutrients to the lungs and tissues\n" +
                "2. forming blood clots to prevent excess blood loss\n" +
                "3. carrying cells and antibodies that fight infection\n" +
                "4. bringing waste products to the kidneys and liver, which filter and clean the blood\n" +
                "5. regulating body temperature"
        notesTextView.text = notesText

        return view
    }
}
