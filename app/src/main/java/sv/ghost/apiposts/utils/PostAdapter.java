package sv.ghost.apiposts.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import sv.ghost.apiposts.R;
import sv.ghost.apiposts.model.GhostPost;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostView> {

    private ArrayList<GhostPost> items;
    private PostListener listener;

    public PostAdapter(ArrayList<GhostPost> items, PostListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PostView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_post, parent, false);
        return new PostView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostView holder, int position) {
        GhostPost post = items.get(position);
        Context context = holder.itemView.getContext();
        Glide.with(context).load(post.featureImage).into(holder.getImage());

        holder.getTag().setText(post.getTag());
        holder.getTag().setVisibility(post.getTag()==null?View.GONE:View.VISIBLE);
        holder.getTitle().setText(post.title);
        holder.getAgo().setText(TimeAgo.getTimeAgo(context, post.publishedAt));
        holder.getTime().setText(context.getString(R.string.post_time, post.readingTime));

        holder.itemView.setOnClickListener(v -> listener.onPostClicked(post));

    }

    @Override
    public int getItemCount() {
        return items!=null?items.size():0;
    }

    public static class PostView extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView tagView, titleView, agoView, timeView;

        public PostView(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_image);

            tagView = itemView.findViewById(R.id.item_tag);
            titleView = itemView.findViewById(R.id.item_title);
            agoView = itemView.findViewById(R.id.item_ago);
            timeView = itemView.findViewById(R.id.item_time);
        }

        public ImageView getImage() {
            return imageView;
        }

        public TextView getTag() {
            return tagView;
        }

        public TextView getTitle() {
            return titleView;
        }

        public TextView getAgo() {
            return agoView;
        }

        public TextView getTime() {
            return timeView;
        }
    }
}
