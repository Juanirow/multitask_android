package mx.juanma.multitask.modules.Categories.CategoryItem

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mx.juanma.multitask.R
import mx.juanma.multitask.models.Category


/**
 * Created by Juancho on 09/10/17.
 * Nakva
 * linanjm90@gmail.com
 */
class CategoriesAdapter(var activity: Activity, var listener: ICategoryItemActionListener): RecyclerView.Adapter<CategoryViewHolder>() {

    var categories = ArrayList<Category>()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(activity).inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder?, position: Int) {
        val category = this.categories[position]
        holder?.labelCategory?.text = category.name
        holder?.labelDefaultTimeValue?.text = "${category.seconds}"
        this.setHolderOptions(holder, category)

        holder?.imageViewEdit?.setOnClickListener {
            this.listener.onClickEditItem(category.id, category.name!!)
        }
        holder?.imageViewDelete?.setOnClickListener {
            this.listener.onClickDeleteItem(category.id, category.name!!)
        }
        holder?.imageViewExpand?.setOnClickListener {
            category.optionsVisible = !category.optionsVisible
            this.setHolderOptions(holder, category)
        }
    }

    private fun setHolderOptions(holder: CategoryViewHolder?, category: Category) {
        if(category.optionsVisible) {
            holder?.optionsContainer?.visibility = View.VISIBLE
            holder?.imageViewExpand?.setImageResource(R.drawable.ic_action_expand_less_light)
        }
        else {
            holder?.optionsContainer?.visibility = View.GONE
            holder?.imageViewExpand?.setImageResource(R.drawable.ic_action_expand_more_light)
        }
    }

    override fun getItemCount(): Int = this.categories.size

    fun updateCategories(categories: ArrayList<Category>) {
        this.categories = categories
        this.notifyDataSetChanged()
    }
}