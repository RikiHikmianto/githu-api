package co.id.rikihikmianto.usergithub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import co.id.rikihikmianto.usergithub.main.MainActivity

class SplashScreen : AppCompatActivity() {
    val SPLASH_SCREEN = 2000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar?.hide()
        Handler().postDelayed({
            Intent(this, MainActivity::class.java).also{
                startActivity(it)
                finish()
            }
        }, SPLASH_SCREEN.toLong())

    }
}