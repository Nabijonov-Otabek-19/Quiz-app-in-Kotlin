package uz.gita.quizappkotlin_bek.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import uz.gita.quizappkotlin_bek.R
import uz.gita.quizappkotlin_bek.repository.AppRepository
import uz.gita.quizappkotlin_bek.ui.game.GameActivity

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var presenter: MainPresenter
    private lateinit var repository: AppRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)
        repository = AppRepository.getInstance()
        loadViews()

    }

    private fun loadViews() {
        repository.clearAllAnswers()
        findViewById<CardView>(R.id.card_flags).setOnClickListener {
            presenter.clickCategoryButton(1)
        }

        findViewById<CardView>(R.id.card_logos).setOnClickListener {
            presenter.clickCategoryButton(2)
        }

        findViewById<CardView>(R.id.card_animals).setOnClickListener {
            presenter.clickCategoryButton(3)
        }

        findViewById<CardView>(R.id.card_foods).setOnClickListener {
            presenter.clickCategoryButton(4)
        }

        findViewById<CardView>(R.id.card_fruits).setOnClickListener {
            presenter.clickCategoryButton(5)
        }

        findViewById<CardView>(R.id.card_vegetables).setOnClickListener {
            presenter.clickCategoryButton(6)
        }
    }

    override fun openGameActivity(category: Int) {
        val intent = Intent(this, GameActivity::class.java)
        intent.putExtra("number", category)
        startActivity(intent)
    }
}