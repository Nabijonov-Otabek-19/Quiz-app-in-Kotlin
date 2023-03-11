package uz.gita.quizappkotlin.ui.main

class MainPresenter(private val view: MainContract.View) : MainContract.Presenter {

    override fun clickCategoryButton(category: Int) {
        view.openGameActivity(category)
    }
}