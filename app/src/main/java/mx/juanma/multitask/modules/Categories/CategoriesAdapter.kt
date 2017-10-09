package mx.juanma.multitask.modules.Categories

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import mx.juanma.multitask.R
import mx.juanma.multitask.models.Category


/**
 * Created by Juancho on 09/10/17.
 * Nakva
 * linanjm90@gmail.com
 */
class CategoriesAdapter(var activity: Activity, listener: ICategoryItemActionListener): RecyclerView.Adapter<CategoryViewHolder>() {

    var categories: Array<Category> = emptyArray()
    var listener: ICategoryItemActionListener? = null

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(activity).inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder?, position: Int) {
        val category = this.categories[position]
        holder?.labelCategory?.text = category.name
        holder?.labelDefaultTimeValue?.text = "${category.seconds}"

        holder?.imageViewEdit?.setOnClickListener { this.listener?.onClickEditItem(category.id) }
        holder?.imageViewDelete?.setOnClickListener { this.listener?.onClickDeleteItem(category.id) }
    }

    override fun getItemCount(): Int = this.categories.size
}