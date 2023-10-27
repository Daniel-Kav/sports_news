package tn.mpdam.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RecyclerviewAdapater extends RecyclerView.Adapter<RecyclerviewAdapater.RvViewHolder> {
    private List<NewsItem> newsItems;
    private Context mContext;

    public RecyclerviewAdapater(List<NewsItem> newsItems, Context mContext) {
        this.newsItems = newsItems;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.simple_item, parent, false);
        return new RvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvViewHolder holder, int position) {
        NewsItem newsItem = newsItems.get(position);
        holder.myText.setText(newsItem.getTitle());
        holder.myImg.setImageResource(newsItem.getImageResource());

        holder.myImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = newsItem.getTitle();
                String description = newsItem.getDescription();

                openEmailIntent(title, description);
            }
        });
    }


    @Override
    public int getItemCount() {
        return newsItems.size();
    }

    public class RvViewHolder extends RecyclerView.ViewHolder {
        public ImageView myImg;
        public TextView myText;

        public RvViewHolder(@NonNull View itemView) {
            super(itemView);
            myImg = itemView.findViewById(R.id.img);
            myText = itemView.findViewById(R.id.name);
        }
    }

    private void openEmailIntent(String title, String description) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, title);
        emailIntent.putExtra(Intent.EXTRA_TEXT, description);

        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"mostfasaidi56@gmail.com"});

        mContext.startActivity(Intent.createChooser(emailIntent, "Send Email"));
    }
}
