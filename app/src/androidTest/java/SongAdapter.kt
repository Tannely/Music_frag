import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item.view.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_item.view.*

class SongAdapter(private val songs: List<Song>, private val onItemClick: (Song) -> Unit) :
    RecyclerView.Adapter<SongAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val song = songs[position]

        // Завантаження зображення за допомогою Glide
        Glide.with(holder.itemView.context)
            .load(song.imageUrl)
            .into(holder.itemView.imageView)

        holder.itemView.titleTextView.text = song.title
        holder.itemView.artistTextView.text = song.artist

        holder.itemView.setOnClickListener { onItemClick(song) }
    }

    override fun getItemCount(): Int = songs.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}

