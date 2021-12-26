package com.thezero.randomjokes.presentation.mainscreen.view

import android.app.Dialog
import android.content.Context
import android.view.View
import android.view.Window
import com.thezero.randomjokes.R
import com.thezero.randomjokes.core.constants.JokeTypes
import com.thezero.randomjokes.data.models.Joke
import com.thezero.randomjokes.databinding.DialogJokeDetailBinding

object JokesDetail {



    fun show(joke: Joke, context: Context) {
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        val binding = DialogJokeDetailBinding.inflate(dialog.layoutInflater)
        dialog.setContentView(binding.root)

        binding.textViewJokeType.text = context.getString(R.string.hash_joke_id_type, joke.id.toString(), joke.type?.uppercase())
        binding.textViewJoke.text = if (joke.type == JokeTypes.SINGLE) joke.joke else joke.setup
        if (joke.type == JokeTypes.TWO_PARTS) {
            binding.textViewPunchLine.text = joke.delivery
        } else {
            binding.cardViewPunchLine.visibility = View.GONE
        }

        dialog.show()
    }
}