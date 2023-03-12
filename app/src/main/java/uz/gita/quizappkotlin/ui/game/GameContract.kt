package uz.gita.quizappkotlin.ui.game

import uz.gita.quizappkotlin.model.TestData

interface GameContract {

    interface Model {
        fun check(userAnswer: String)
        fun getNextTest(): TestData
        fun isLastQuestion(): Boolean
        fun getCurrentPos(): Int
        fun getCorrectAns(): Int
        fun getWrongAns(): Int
        fun getSkippedAns(): Int
        fun getTotalCount(): Int
    }

    interface View {
        fun clearOldAnswer()
        fun closeScreen()
        fun describeTest(testData: TestData, currentPos: Int, totalCount: Int)
        fun stateNextButton(bool: Boolean)
        fun openResultActivity()
    }

    interface Presenter {
        fun showCustomDialog()
        fun getCorrectAns(): Int
        fun getWrongAns(): Int
        fun getSkippedAns(): Int
        fun clickSkipButton()
        fun clickNextButton()
        fun clickBackButton()
        fun selectUserAnswer(userAns: String)
    }
}