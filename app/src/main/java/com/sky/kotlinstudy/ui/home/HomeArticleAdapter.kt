package com.sky.kotlinstudy.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sky.kotlinstudy.databinding.HomeArticleItemBinding
import com.sky.kotlinstudy.model.Article

/**
 *
 * @Description:    []
 * @Author:         skyHuang
 * @CreateDate:     2021/8/13 16:24
 */
class HomeArticleAdapter(private val clickListener: ArticleItemClickListener) :
    ListAdapter<Article, HomeArticleAdapter.ViewHolder>(ArticleDiff()) {

    class ViewHolder(private val bind: HomeArticleItemBinding) :
        RecyclerView.ViewHolder(bind.root) {
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val bind = HomeArticleItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return ViewHolder(bind)
            }
        }

        fun bind(article: Article, clickListener: ArticleItemClickListener) {
            bind.article = article
            bind.clickListener = clickListener
            bind.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), clickListener)
    }

}

class ArticleItemClickListener(
    val item: (a: Article) -> Unit,
    val collectViewOnClick: (a: Article) -> Unit
) {

    fun itemOnClick(a: Article) = item(a)

    fun collectOnClick(a: Article) = collectViewOnClick(a)

}

class ArticleDiff : DiffUtil.ItemCallback<Article>() {
    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem == newItem
    }
}