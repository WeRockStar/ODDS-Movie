package com.odds.movie.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.odds.movie.data.SharePreferenceLocalStorage
import com.odds.movie.databinding.ActivityLoginBinding
import com.odds.movie.movie.MovieActivity
import kotlinx.coroutines.Dispatchers

class LoginActivity : AppCompatActivity(), LoginPresenter.LoginView {

    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }
    private val presenter by lazy {
        LoginPresenter(
            Dispatchers.Main, 2000,
            SharePreferenceLocalStorage(this)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        presenter.attachView(this)
        presenter.askUsername()

        binding.buttonSubmit.setOnClickListener {
            val username = binding.editTextUsername.text
                .toString()
            val password = binding.editTextPassword.text
                .toString()
            presenter.login(username, password)
        }
    }

    override fun goToMovieScreen(user: User) {
        val intent = Intent(this, MovieActivity::class.java)
        intent.putExtra(MovieActivity.EXTRA_USER, user)
        startActivity(intent)
    }

    override fun showToastMessage() {
        Toast.makeText(
            this,
            "I think your username and password is admin",
            Toast.LENGTH_LONG
        ).show()
    }

    override fun showProgressBar() {
        binding.progressBar.isVisible = true
    }

    override fun hideProgressBar() {
        binding.progressBar.isVisible = false
    }

    override fun onUsernameSaved(username: String) {
        binding.editTextUsername.setText(username)
    }

}
