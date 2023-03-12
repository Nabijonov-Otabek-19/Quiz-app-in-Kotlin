package uz.gita.quizappkotlin.ui.game

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import uz.gita.quizappkotlin.R
import uz.gita.quizappkotlin.model.TestData
import uz.gita.quizappkotlin.ui.result.ResultActivity

class GameActivity : AppCompatActivity(), GameContract.View {

    private lateinit var radios: ArrayList<RadioButton>
    private lateinit var variants: ArrayList<AppCompatTextView>
    private lateinit var questionText: AppCompatTextView
    private lateinit var currentPosText: AppCompatTextView
    private lateinit var buttonSkip: AppCompatButton
    private lateinit var buttonNext: AppCompatButton
    private lateinit var buttonBack: AppCompatImageView
    private lateinit var image: ImageView

    private lateinit var presenter: GamePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        loadViews()
        attachClickListener()
        val number = intent.getIntExtra("number", 0)
        presenter = GamePresenter(this, number)

    }

    private fun loadViews() {
        radios = ArrayList(4)
        radios.add(findViewById(R.id.radio1))
        radios.add(findViewById(R.id.radio2))
        radios.add(findViewById(R.id.radio3))
        radios.add(findViewById(R.id.radio4))

        variants = ArrayList(4)
        variants.add(findViewById(R.id.text1))
        variants.add(findViewById(R.id.text2))
        variants.add(findViewById(R.id.text3))
        variants.add(findViewById(R.id.text4))

        questionText = findViewById(R.id.textQuestion)
        currentPosText = findViewById(R.id.textCurrentPos)
        buttonSkip = findViewById(R.id.buttonSkip)
        buttonNext = findViewById(R.id.buttonNext)
        buttonBack = findViewById(R.id.btn_back)

        image = findViewById(R.id.img_flag)
    }

    private fun attachClickListener() {
        buttonNext.setOnClickListener { presenter.clickNextButton() }

        buttonSkip.setOnClickListener { presenter.clickSkipButton() }

        buttonBack.setOnClickListener { presenter.showCustomDialog() }

        for (i in radios.indices) {
            radios[i].setOnClickListener {
                if (radios[i].isChecked) {
                    clearOldAnswer()
                    radios[i].isChecked = true
                    presenter.selectUserAnswer(variants[i].text.toString())
                }
            }
        }
    }

    override fun clearOldAnswer() {
        for (i in radios.indices) {
            if (radios[i].isChecked) radios[i].isChecked = false
        }
    }

    override fun closeScreen() {
        finish()
    }

    override fun describeTest(testData: TestData, currentPos: Int, totalCount: Int) {
        currentPosText.text = "$currentPos/$totalCount"
        questionText.text = testData.question
        image.setImageResource(testData.image)

        variants[0].text = testData.variant1
        variants[1].text = testData.variant2
        variants[2].text = testData.variant3
        variants[3].text = testData.variant4
    }

    override fun stateNextButton(bool: Boolean) {
        buttonNext.isEnabled = bool
    }

    override fun openResultActivity() {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("correct", presenter.getCorrectAns().toString())
        intent.putExtra("wrong", presenter.getWrongAns().toString())
        intent.putExtra("skip", presenter.getSkippedAns().toString())
        startActivity(intent)
        presenter.clickBackButton()
    }
}