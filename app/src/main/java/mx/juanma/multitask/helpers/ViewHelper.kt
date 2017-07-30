package mx.juanma.multitask.helpers

import android.content.Context
import android.support.design.widget.TextInputLayout


/**
 * Created by Juancho on 30/07/17.
 * Nakva
 * linanjm90@gmail.com
 */
object ViewHelper {

    /**
     * Set the error and the focus on the TextInputLayout
     * @param error error to set in the layout input
     * @param label input to set the error
     */
    fun setTextInputLayoutError(error: String,
                                label: TextInputLayout) {
        label.error = error
        label.isErrorEnabled = true
        label.error = error
        label.requestFocus()
    }

    /**
     * Set the error and the focus on the TextInputLayout
     * @param errorId string id of the error resource
     * @param label input to set the error
     * @param context current context of the app
     */
    fun setTextInputLayoutError(errorId: Int,
                                label: TextInputLayout,
                                context: Context) {
        val error = context.getString(errorId)
        setTextInputLayoutError(error, label)
    }
}