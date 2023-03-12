package uz.gita.quizappkotlin_bek.ui.main

interface MainContract {

    interface View {
        fun openGameActivity(category: Int)
    }

    interface Presenter {
        fun clickCategoryButton(category: Int)
    }
}