package mx.juanma.multitask.modules.Categories.CategoryItem

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.item_category.view.*


/**
 * Created by Juancho on 09/10/17.
 * Nakva
 * linanjm90@gmail.com
 */
class CategoryViewHolder(var view: View): RecyclerView.ViewHolder(view) {

    var labelCategory: TextView? = null
    var labelDefaultTime: TextView? = null
    var labelDefaultTimeValue: TextView? = null
    var imageViewExpand: ImageView? = null
    var imageViewEdit: ImageView? = null
    var imageViewDelete: ImageView? = null
    var optionsContainer: LinearLayout? = null

    init {
        this.labelCategory = view.labelCategory
        this.labelDefaultTime = view.labelDefaultTime
        this.labelDefaultTimeValue = view.labelDefaultTimeValue
        this.imageViewExpand = view.imageExpand
        this.imageViewEdit = view.imageEdit
        this.imageViewDelete = view.imageDelete
        this.optionsContainer = view.optionsContainer
    }
}