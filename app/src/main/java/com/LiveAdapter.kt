package com

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewstructure.R
import com.model.Live
import kotlinx.android.synthetic.main.res_item_live.view.*

class LiveAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items : List<Live> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return LiveViewHolder( //definimos o layout do nosso viewHolder
            LayoutInflater.from(parent.context).inflate(R.layout.res_item_live, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(holder){

            is LiveViewHolder -> {
                holder.bind(items[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class LiveViewHolder constructor(
        itemView : View //preciso passar essa implementaçao do ViewHolder nessa classe tbm.
    ) : RecyclerView.ViewHolder(itemView){

        private val liveTitle = itemView.title
        private val liveAuthor = itemView.author
        private val liveThumbnail = itemView.thumbnail

        //a funcao bind pega as informacoes da model que vou passar pra ele e coloca no layout do item do RecyclerView
        fun bind(live : Live) {

            liveTitle.text = live.title
            liveAuthor.text = live.author

        }

    }
}