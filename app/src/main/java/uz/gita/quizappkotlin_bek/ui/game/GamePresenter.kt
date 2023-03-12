package uz.gita.quizappkotlin_bek.ui.game

import android.app.Dialog
import android.content.Context
import androidx.appcompat.widget.AppCompatButton
import uz.gita.quizappkotlin_bek.R

class GamePresenter(private val view: GameContract.View, category: Int) : GameContract.Presenter {

    private var model: GameModel
    private lateinit var userAnswer: String

    init {
        model = GameModel(category)
        loadNextTest()
    }

    private fun loadNextTest() {
        if (model.isLastQuestion()) {
            view.clearOldAnswer()
            view.describeTest(model.getNextTest(), model.getCurrentPos(), model.getTotalCount())
        } else view.openResultActivity()
    }

    override fun showCustomDialog() {
        val dialog = Dialog(view as Context)
        dialog.setContentView(R.layout.custom_exit_dialog)

        val btnNo: AppCompatButton = dialog.findViewById(R.id.textViewNo)
        val btnYes: AppCompatButton = dialog.findViewById(R.id.textViewYes)

        btnNo.setOnClickListener { dialog.dismiss() }

        btnYes.setOnClickListener {
            dialog.dismiss()
            this.view.closeScreen()
        }
        dialog.create()
        dialog.show()
    }

    override fun getCorrectAns(): Int {
        return model.getCorrectAns()
    }

    override fun getWrongAns(): Int {
        return model.getWrongAns()
    }

    override fun getSkippedAns(): Int {
        return model.getSkippedAns()
    }

    override fun clickSkipButton() {
        loadNextTest()
    }

    override fun clickNextButton() {
        model.check(userAnswer)
        loadNextTest()
        view.stateNextButton(false)
    }

    override fun clickBackButton() {
        view.closeScreen()
    }

    override fun selectUserAnswer(userAns: String) {
        this.userAnswer = userAns
        view.stateNextButton(true)
    }
}