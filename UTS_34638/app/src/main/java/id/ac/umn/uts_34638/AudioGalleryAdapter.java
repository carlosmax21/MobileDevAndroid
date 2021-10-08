package id.ac.umn.uts_34638;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class AudioGalleryAdapter extends RecyclerView.Adapter<AudioGalleryAdapter.ItemAudioViewHolder> {
    private LinkedList<AudioItem> mAudioGallery;
    private LayoutInflater mInflater;
    private Context mContext;

    public AudioGalleryAdapter(Context context, LinkedList<AudioItem> audioItems){
        this.mContext = context;
        this.mAudioGallery = audioItems;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public AudioGalleryAdapter.ItemAudioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.activity_audio_item, parent, false);
        return new ItemAudioViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull AudioGalleryAdapter.ItemAudioViewHolder holder, int position) {
        AudioItem mAudioItem = mAudioGallery.get(position);

        holder.tvAudioTitle.setText(mAudioItem.getTitle());
        holder.tvAudioCategory.setText(mAudioItem.getCategory());
    }

    @Override
    public int getItemCount(){ return mAudioGallery.size();}

    class ItemAudioViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tvAudioTitle;
        private TextView tvAudioCategory;
        private ImageButton btnAudioDelete;
        private AudioGalleryAdapter mAdapter;
        private int mPosition;
        private AudioItem mAudioItem;

        public ItemAudioViewHolder(View view, AudioGalleryAdapter adapter) {
            super(view);
            mAdapter = adapter;
            tvAudioTitle = view.findViewById(R.id.tv_audio_title);
            tvAudioCategory = view.findViewById(R.id.tv_audio_category);
            btnAudioDelete = view.findViewById(R.id.btn_audio_delete);
            view.setOnClickListener(this);

            btnAudioDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    removeAt(getAdapterPosition());
                }
            });

        }

        @Override
        public void onClick(View v){
            mPosition = getLayoutPosition();
            mAudioItem = mAudioGallery.get(mPosition);

            Intent audioPlayer = new Intent(mContext, AudioDetail.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("detilAudio", mAudioItem);
            audioPlayer.putExtras(bundle);
            mContext.startActivity(audioPlayer);
        }
    }

    public void removeAt(int position){
        mAudioGallery.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mAudioGallery.size());
    }
}

