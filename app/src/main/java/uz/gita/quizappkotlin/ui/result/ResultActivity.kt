package uz.gita.quizappkotlin.ui.result

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.LinearLayoutCompat
import uz.gita.quizappkotlin.R
import uz.gita.quizappkotlin.model.AnswerData
import uz.gita.quizappkotlin.repository.AppRepository

class ResultActivity : AppCompatActivity(), ResultContract.View {

    private lateinit var correctAns: TextView
    private lateinit var wrongAns: TextView
    private lateinit var skippedAns: TextView
    private lateinit var id: TextView
    private lateinit var userAns: TextView
    private lateinit var corrAns: TextView
    private lateinit var image: ImageView
    private lateinit var back2menu: AppCompatButton
    private lateinit var inflater: LayoutInflater
    private lateinit var list: List<AnswerData>
    private lateinit var container: LinearLayoutCompat
    private lateinit var presenter: ResultContract.Presenter
    private lateinit var repository: AppRepository
    private lateinit var obj: AnswerData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        presenter = ResultPresenter(this)
        repository = AppRepository.getInstance()

        loadViews()

    }

    private fun loadViews() {
        correctAns = findViewById(R.id.txt_correctAnswer)
        wrongAns = findViewById(R.id.txt_wrongAnswer)
        skippedAns = findViewById(R.id.txt_skippedAnswer)
        back2menu = findViewById(R.id.btn_back2menu)

        inflater = LayoutInflater.from(this)
        container = findViewById(R.id.container)

        presenter.setAnswers()
        presenter.showAllAnswers()
    }

    override fun backMenu() {
        finish()
    }

    override fun setAnswers() {
        correctAns.text = intent.getStringExtra("correct")
        wrongAns.text = intent.getStringExtra("wrong")
        skippedAns.text = intent.getStringExtra("skip")

        back2menu.setOnClickListener { presenter.clickBtnBackMenu() }
    }

    override fun showAllAnswers() {
        list = repository.getAnswerDataList()
        if (list.isNotEmpty()) {
            list.forEach { answerData ->
                obj = answerData
                val view = inflater.inflate(R.layout.item_answers, container, false)
                image = view.findViewById(R.id.img_Ans)
                userAns = view.findViewById(R.id.txt_userAns)
                corrAns = view.findViewById(R.id.txt_corrAns)
                id = view.findViewById(R.id.txt_id)

                image.setImageResource(answerData.image)
                corrAns.text = answerData.correctAns
                corrAns.setTextColor(getColor(R.color.green))
                id.text = answerData.id.toString()
                userAns.text = answerData.userAns

                if (answerData.correctAns == answerData.userAns) {
                    userAns.setTextColor(getColor(R.color.green))
                } else userAns.setTextColor(getColor(R.color.red))

                container.addView(view)
            }
        }
    }
}