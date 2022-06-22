package com.willweeverwin.mvp_training

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.willweeverwin.mvp_training.databinding.ActivityMainBinding
import com.willweeverwin.mvp_training.presenter.UserPresenter
import com.willweeverwin.mvp_training.view.UserRegisterActivity
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), UserRegisterActivity {

    private lateinit var binding: ActivityMainBinding

    private val presenter = UserPresenter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnRegister.setOnClickListener { registerUser() }
            btnClear.setOnClickListener { clearUsers() }
        }
    }


    private fun createTextView(text: String): TextView =
        (layoutInflater.inflate(R.layout.user_text_view, binding.userList, false) as TextView).apply { setText(text) }


    override fun registerUser() {
        val name = binding.nameInput.text.toString()
        val mail = binding.mailInput.text.toString()
        if (name.isEmpty()) {
            Toast.makeText(this, "name is empty", Toast.LENGTH_SHORT).show()
            return
        }
        if (mail.isEmpty()) {
            Toast.makeText(this, "mail is empty", Toast.LENGTH_SHORT).show()
            return
        }

        presenter.registerUser(name, mail) { text -> binding.userList.addTextView(text) }
    }


    override fun clearUsers() {
        presenter.clearUsers()
        binding.userList.removeAllViews()
    }


    private fun LinearLayout.addTextView(text: String) = this.addView(createTextView(text))
}