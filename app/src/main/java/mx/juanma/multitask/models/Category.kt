package mx.juanma.multitask.models

import com.google.firebase.database.Exclude


/**
 * Created by Juancho on 12/09/17.
 * Nakva
 * linanjm90@gmail.com
 */
class Category(var name: String? = null,
               var seconds: Int? = null,
               var id: String = "",
               @get:Exclude var optionsVisible: Boolean = false) {
}