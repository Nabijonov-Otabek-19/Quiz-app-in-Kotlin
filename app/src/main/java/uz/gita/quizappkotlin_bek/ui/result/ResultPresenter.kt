package uz.gita.quizappkotlin_bek.ui.result

class ResultPresenter(private val view: ResultContract.View) : ResultContract.Presenter {

    override fun showAllAnswers() {
        view.showAllAnswers()
    }

    override fun clickBtnBackMenu() {
        view.backMenu()
    }

    override fun setAnswers() {
        view.setAnswers()
    }
}