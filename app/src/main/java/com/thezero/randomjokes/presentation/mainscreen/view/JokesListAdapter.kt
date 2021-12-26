package com.thezero.randomjokes.presentation.mainscreen.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thezero.randomjokes.core.constants.JokeTypes
import com.thezero.randomjokes.data.models.Joke
import com.thezero.randomjokes.databinding.ItemJokeBinding

class JokesListAdapter(private val jokesArrayList: ArrayList<Joke>) :
    RecyclerView.Adapter<JokesListAdapter.JokeItemViewHolder>() {

    var onItemClick: ((Joke) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeItemViewHolder {
        val itemJokeBinding =
            ItemJokeBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return JokeItemViewHolder(itemJokeBinding)
    }


    override fun onBindViewHolder(holder: JokeItemViewHolder, position: Int) {
        holder.bind(jokesArrayList[position])
    }

    override fun getItemCount(): Int = jokesArrayList.size

    inner class JokeItemViewHolder(private val binding: ItemJokeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.textViewJoke.setOnClickListener {
                onItemClick?.invoke(jokesArrayList[adapterPosition])
            }
        }

        fun bind(joke: Joke) {
            binding.textViewJoke.text =
                if (joke.type == JokeTypes.SINGLE) joke.joke else joke.setup
        }
    }

    fun refreshJokesList(jokesList: List<Joke>) {
        jokesArrayList.clear()
        jokesArrayList.addAll(jokesList)
        notifyDataSetChanged()
    }
}
