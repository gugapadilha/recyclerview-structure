package com

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.recyclerviewstructure.R
import com.model.Live
import kotlinx.android.synthetic.main.res_item_live.view.*

class LiveAdapter(private val onItemClicked : (Live) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items : List<Live> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return LiveViewHolder( //definimos o layout do nosso viewHolder
            LayoutInflater.from(parent.context).inflate(R.layout.res_item_live, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(holder){

            is LiveViewHolder -> {
                holder.bind(items[position], onItemClicked)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setDataSet(lives : List<Live>){
        this.items = lives
    }

    class LiveViewHolder constructor(
        itemView : View //preciso passar essa implementaçao do ViewHolder nessa classe tbm.
    ) : RecyclerView.ViewHolder(itemView){

        private val liveTitle = itemView.title
        private val liveAuthor = itemView.author
        private val liveThumbnail = itemView.thumbnail

        //a funcao bind pega as informacoes da model que vou passar pra ele e coloca no layout do item do RecyclerView
        fun bind(live : Live, onItemClicked: (Live) -> Unit) {

            liveTitle.text = live.title
            liveAuthor.text = live.author

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(live.thumbanilUrl)
                .into(liveThumbnail)

            itemView.setOnClickListener {
                onItemClicked(live)
            }

        }

    }
}