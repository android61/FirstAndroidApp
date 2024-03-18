package ru.netology.nmedia.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContract
import ru.netology.nmedia.R
import ru.netology.nmedia.databinding.ActivityEditPost2Binding
import ru.netology.nmedia.databinding.ActivityNewPostBinding


class EditPostActivity : ActivityResultContract<String, String?>() {



    override fun createIntent(context: Context, input: String): Intent =
        Intent(context, NewPostActivity::class.java).apply {
            putExtra(Intent.EXTRA_TEXT, input)
        }

    override fun parseResult(resultCode: Int, intent: Intent?): String? =
        if (resultCode == Activity.RESULT_OK) {

            intent?.getStringExtra(Intent.EXTRA_TEXT)
        } else {

            null
        }

    
}




