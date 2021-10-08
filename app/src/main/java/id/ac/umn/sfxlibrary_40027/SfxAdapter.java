package id.ac.umn.sfxlibrary_40027;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SfxAdapter extends RecyclerView.Adapter<SfxAdapter.ItemViewHolder> {
    private final ArrayList<SfxSource> mListSfx;
    private final LayoutInflater mInflater;
    private final Context mContext;

    public SfxAdapter(Context context, ArrayList<SfxSource> listSfx) {
        this.mContext = context;
        this.mListSfx = listSfx;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_library, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        SfxSource mSfxSource = mListSfx.get(position);
        holder.tvSfxTitle.setText(mSfxSource.getTitle());
        holder.tvSfxCategory.setText(mSfxSource.getCategory());
        holder.btnSfxDelete.setOnClickListener(v -> removeItem(holder.getAdapterPosition()));
    }

    @Override
    public int getItemCount() {
        return mListSfx.size();
    }

    private void removeItem(int position) {
        mListSfx.remove(position);
        notifyDataSetChanged();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView tvSfxTitle;
        private final TextView tvSfxCategory;
        private final ImageButton btnSfxDelete;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSfxTitle = itemView.findViewById(R.id.tv_item_title);
            tvSfxCategory = itemView.findViewById(R.id.tv_item_category);
            btnSfxDelete = itemView.findViewById(R.id.btn_item_delete);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int mPosition = getLayoutPosition();
            SfxSource mSfxSource = mListSfx.get(mPosition);
            Intent detailIntent = new Intent(mContext, DetailActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("DetailSFX", mSfxSource);
            detailIntent.putExtras(bundle);
            mContext.startActivity(detailIntent);
        }
    }
}
