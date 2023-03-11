package uz.gita.quizappkotlin.ui.main

interface MainContract {

    interface View {
        fun openGameActivity(category: Int)
    }

    interface Presenter {
        fun clickCategoryButton(category: Int)
    }
}