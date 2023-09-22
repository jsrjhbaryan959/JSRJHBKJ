import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.example.jsrjhbkj.Question
import com.example.jsrjhbkj.R

class fragment3 : Fragment() {

    private lateinit var questionTextView: TextView
    private lateinit var optionsRadioGroup: RadioGroup
    private lateinit var submitButton: Button

    private val questions = listOf(
        Question("1. Which of the following blood cells play an important role in blood clotting?", listOf("Thrombocytes", "Neutrophils","Leucocytes" , "Erythrocytes"), 0),
        Question("2. Serum differs from blood as it lacks", listOf("antibodies", "clotting factors", "albumins", "globulins"), 1),
        Question("3. Which of the following is correct?", listOf("Serum contains blood and fibrinogen", "Plasma is blood without lymphocytes", " Blood comprises plasma, RBC, WBC and platelets", "Lymph is plasma with RBC and WBC"), 2)
        // Add more questions and options here
    )

    private var currentQuestionIndex = 0
    private var correctAnswers = 0 // Track the number of correct answers

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fragment3, container, false)

        questionTextView = view.findViewById(R.id.questionTextView)
        optionsRadioGroup = view.findViewById(R.id.optionsRadioGroup)
        submitButton = view.findViewById(R.id.submitButton)

        submitButton.setOnClickListener {
            checkAnswer()
        }

        showQuestion(0) // Display the first question

        return view
    }

    private fun showQuestion(index: Int) {
        val question = questions[index]
        questionTextView.text = question.question

        // Clear existing RadioButtons and add new ones for answer options
        optionsRadioGroup.removeAllViews()
        for ((i, option) in question.options.withIndex()) {
            val radioButton = RadioButton(requireContext())
            radioButton.text = option
            radioButton.id = i
            optionsRadioGroup.addView(radioButton)
        }

        currentQuestionIndex = index
    }

    private fun checkAnswer() {
        val selectedRadioButtonId = optionsRadioGroup.checkedRadioButtonId
        if (selectedRadioButtonId != -1) {
            val selectedOptionIndex = optionsRadioGroup.indexOfChild(optionsRadioGroup.findViewById(selectedRadioButtonId))
            val correctAnswerIndex = questions[currentQuestionIndex].correctAnswerIndex

            if (selectedOptionIndex == correctAnswerIndex) {
                // Correct answer
                correctAnswers++ // Increment correct answer count
            } else {
                // Incorrect answer
                // Handle incorrect answer action (e.g., show a message or provide correct answer)
            }

            // Move to the next question (if available)
            if (currentQuestionIndex < questions.size - 1) {
                showQuestion(currentQuestionIndex + 1)
            } else {
                // End of quiz, display results
                showResults()
            }

            // Clear selection
            optionsRadioGroup.clearCheck()
        }
    }

    private fun showResults() {
        // Display the number of correct answers
        val resultText = "You have answered $correctAnswers out of ${questions.size} questions correctly."
        questionTextView.text = resultText
        optionsRadioGroup.visibility = View.GONE // Hide RadioGroup
        submitButton.visibility = View.GONE // Hide Submit Button
    }
}
