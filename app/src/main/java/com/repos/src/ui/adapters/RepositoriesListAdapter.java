package com.repos.src.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.repos.src.R;
import com.repos.src.models.Repository;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Ayman Mahgoub on 2/20/16.
 */
public class RepositoriesListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final LayoutInflater mInflater;
    private List<Repository> mItems;

    public RepositoriesListAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
        mItems = new ArrayList<>();
    }

    public void setData(List<Repository> data) {
        mItems.clear();
        mItems.addAll(data);

        notifyDataSetChanged();
    }

    public Repository getItem(int position) {

        if (mItems == null)
            return null;
        return mItems.get(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_item_repository, parent, false);
        RepoListItemViewHolder repoListItemViewHolder = new RepoListItemViewHolder(view);
        return repoListItemViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RepoListItemViewHolder repoListItemViewHolder = (RepoListItemViewHolder) holder;
        Repository repository = getItem(position);
        repoListItemViewHolder.bind(repository);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    static final class RepoListItemViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.repo_name)
        TextView repoName;

        @Bind(R.id.repo_description)
        TextView repoDescription;

        public RepoListItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(Repository repository) {
            String name = repository.getName();
            String description = repository.getDescription();
            repoName.setText(name);
            repoDescription.setText(description);
        }
    }
}