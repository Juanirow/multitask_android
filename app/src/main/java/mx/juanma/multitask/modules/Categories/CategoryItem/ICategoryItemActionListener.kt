package mx.juanma.multitask.modules.Categories.CategoryItem


/**
 * Created by Juancho on 09/10/17.
 * Nakva
 * linanjm90@gmail.com
 */
interface ICategoryItemActionListener {

    fun onClickEditItem(id: String, name: String, seconds: Int)
    fun onClickDeleteItem(id: String, name: String)
}