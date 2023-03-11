package uz.gita.quizappkotlin.ui.result

interface ResultContract {

    interface View {
        fun backMenu()
        fun setAnswers()
        fun showAllAnswers()
    }

    interface Presenter {
        fun showAllAnswers()
        fun clickBtnBackMenu()
        fun setAnswers()
    }
}