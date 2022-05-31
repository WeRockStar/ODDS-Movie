package com.odds.movie.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.odds.movie.movie.MovieActivity
import com.odds.movie.databinding.ActivityLoginBinding
import com.odds.movie.delay

class LoginActivity : AppCompatActivity() {

    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonSubmit.setOnClickListener {
            val user = createUser()
            delay(
                beforeDelay = { binding.progressBar.isVisible = true },
                afterDelay = {
                    binding.progressBar.isVisible = false
                    login(user)
                })
        }
    }


    private fun login(user: User) {
        if (user.username == "admin" && user.password == "admin") {
            val intent = Intent(this, MovieActivity::class.java)
            intent.putExtra(MovieActivity.EXTRA_USER, user)
            startActivity(intent)
        } else {
            Toast.makeText(
                this,
                "I think your username and password is admin",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun createUser(): User {
        val username = binding.editTextUsername.text.toString()
        val password = binding.editTextPassword.text.toString()
        return User(username, password)
    }

}
