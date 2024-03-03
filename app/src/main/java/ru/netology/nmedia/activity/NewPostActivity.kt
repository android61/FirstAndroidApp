package ru.netology.nmedia.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import ru.netology.nmedia.R
import ru.netology.nmedia.databinding.ActivityNewPostBinding
import ru.netology.nmedia.repository.empty

class NewPostActivity : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNewPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contents = intent.getStringExtra(Intent.EXTRA_TEXT)

        binding.edit.setText(contents)

        binding.ok.setOnClickListener {
            if (binding.edit.text.isNullOrBlank()) {
                Toast.makeText(
                    this,
                   intent.getStringExtra(Intent.EXTRA_TEXT),
                    Toast.LENGTH_SHORT
                ).show()
                setResult(RESULT_CANCELED)
            } else {
                val result = Intent().putExtra(Intent.EXTRA_TEXT, binding.edit.text.toString())
                setResult(RESULT_OK, result)
            }
            finish()
        }
    }
}

object NewPostContract: ActivityResultContract<Unit, String?>(){
    override fun createIntent(context: Context, input: Unit): Intent =
        Intent(context, NewPostActivity::class.java)

    override fun parseResult(resultCode: Int, intent: Intent?): String? =
        intent?.getStringExtra(Intent.EXTRA_TEXT)
}