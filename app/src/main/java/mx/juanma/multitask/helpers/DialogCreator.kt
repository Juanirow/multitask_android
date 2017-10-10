package mx.juanma.multitask.helpers

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.content.DialogInterface
import android.widget.EditText
import android.widget.LinearLayout
import mx.juanma.multitask.R


/**
 * Created by Juancho on 30/07/17.
 * Nakva
 * linanjm90@gmail.com
 */
object DialogCreator {
    /**
     * Display an alert in the current context
     * @param context           current context to show the alert
     * @param titleId             title of the alert
     * @param iconId            id of the drawable to show as icon
     * @param messageId           message to show in the alert
     * @param onCLickListener   listener to detect the clicks in the buttons
     * @param onDismissListener listener to detect the dismiss action of the alert
     */
    fun showDialogMessage(context: Context, titleId: Int,
                          iconId: Int, messageId: Int,
                          onCLickListener: DialogInterface.OnClickListener? = null,
                          onDismissListener: DialogInterface.OnDismissListener? = null) {
        val builder = AlertDialog.Builder(context)
        builder.setIcon(iconId)
        builder.setTitle(titleId)
        builder.setPositiveButton(R.string.ok, onCLickListener)
        builder.setMessage(messageId)
        val alert = builder.create()
        alert.setOnDismissListener(onDismissListener)
        alert.show()
    }


    /**
     * Display an alert in the current context
     * @param context           current context to show the alert
     * @param titleId             title of the alert
     * @param messageId           message to show in the alert
     * @param onCLickListener   listener to detect the clicks in the buttons
     * @param onDismissListener listener to detect the dismiss action of the alert
     */
    fun showDialogMessageNoIcon(context: Context, titleId: Int,
                                messageId: Int,
                                onCLickListener: DialogInterface.OnClickListener? = null,
                                onDismissListener: DialogInterface.OnDismissListener? = null) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(titleId)
        builder.setPositiveButton(R.string.ok, onCLickListener)
        builder.setMessage(messageId)
        val alert = builder.create()
        alert.setOnDismissListener(onDismissListener)
        alert.show()
    }

    /**

     * @param context           current context to show the alert
     * @param titleId             title of the alert
     * @param message           message to show in the alert
     * @param onClickListener   listener to detect the clicks in the buttons
     * @param onDismissListener listener to detect the dismiss action of the alert
     */
    fun showDialogDynamicMessage(context: Context, titleId: Int, message: String,
                                 onClickListener: DialogInterface.OnClickListener? = null,
                                 onDismissListener: DialogInterface.OnDismissListener? = null) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(titleId)
        builder.setPositiveButton(R.string.ok, onClickListener)
        builder.setMessage(message)
        builder.setCancelable(false)
        val alert = builder.create()
        alert.show()
    }

    /**
     * Show and error alert with the ok button
     * @param context           current context to show the alert
     * @param messageId         id of the message to show in the alert
     * @param onCLickListener   listener to detect the clicks in the buttons
     * @param onDismissListener listener to detect the dismiss action of the alert
     */
    fun showError(context: Context, messageId: Int,
                  onCLickListener: DialogInterface.OnClickListener? = null,
                  onDismissListener: DialogInterface.OnDismissListener? = null) {
        showDialogMessageNoIcon(context, R.string.error,
                messageId, onCLickListener, onDismissListener)
    }

    /**
     * Show and warning alert with the ok button
     * @param context           current context to show the alert
     * @param messageId         id of the message to show in the alert
     * @param onCLickListener   listener to detect the clicks in the buttons
     * @param onDismissListener listener to detect the dismiss action of the alert
     */
    fun showWarning(context: Context, messageId: Int,
                    onCLickListener: DialogInterface.OnClickListener?,
                    onDismissListener: DialogInterface.OnDismissListener?) {
        showDialogMessageNoIcon(context, R.string.warning,
                messageId, onCLickListener, onDismissListener)
    }

    /**
     * Create a Progress dialog with the title and message with the
     * cancelable attr as false
     * @param context current context to show the dialog
     * @param title   title to display in the progress dialog
     * @param message message to display in the progress dialog
     * @return ProgressDialog instance
     */
    fun createProgressDialog(context: Context,
                             title: String,
                             message: String): ProgressDialog {
        val mProgressDialog = ProgressDialog(context)
        mProgressDialog.setTitle(title)
        mProgressDialog.setMessage(message)
        mProgressDialog.setCancelable(false)
        return mProgressDialog
    }


    /**
     * Create a Progress dialog with the title and message with the
     * cancelable attr as false
     * @param context current context to show the dialog
     * @param titleId  id of the  title to display in the progress dialog
     * @param messageId id of the message to display in the progress dialog
     * @return ProgressDialog instance
     */
    fun createProgressDialog(context: Context,
                             titleId: Int,
                             messageId: Int): ProgressDialog {
        var title = context.resources.getString(messageId)
        var message = context.resources.getString(messageId)
        return createProgressDialog(context, title, message)
    }

    /**
     * create an alert dialog with an input to ask information to the user
     * @param context   current context of the app
     * @param titleId   id of the title resource to put in the alert dialog
     * @param descId    id of the resource to show as message in the dialog
     * @param inputText text to put in the edit text selected
     * @param hintInput hint of the edit text
     * @return alert dialog
     */
    fun createInputDialog(context: Context, titleId: Int, descId: Int,
                          editText: EditText, inputType: Int,
                          inputText: String?, hintInput: Int): AlertDialog {
        val layout = LinearLayout(context)
        val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        )
        layout.setPadding(16, 0, 16, 0)
        layout.layoutParams = params

        editText.setHint(hintInput)
        editText.setSingleLine(true)
        editText.inputType = inputType
        editText.layoutParams = params
        if (inputText != null) {
            editText.setText(inputText)
            editText.setSelection(0, inputText.length)
        }
        layout.addView(editText)

        val builder = AlertDialog.Builder(context)
                .setMessage(descId)
                .setTitle(titleId)
                .setView(layout)
                .setPositiveButton(R.string.ok, null)
                .setNegativeButton(R.string.cancel, null)

        return builder.create()
    }

    fun showConfirmDialog(context: Context, titleId: Int, messageId: Int,
                          onCLickListener: DialogInterface.OnClickListener?,
                          onDismissListener: DialogInterface.OnDismissListener?) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(titleId)
        builder.setPositiveButton(R.string.ok, onCLickListener)
        builder.setMessage(messageId)

        val alert = builder.create()
        alert.setOnDismissListener(onDismissListener)
        alert.show()
    }

    fun showConfirmDialog(context: Context, titleId: Int, message: String,
                          onCLickListener: DialogInterface.OnClickListener?,
                          onDismissListener: DialogInterface.OnDismissListener?) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(titleId)
        builder.setPositiveButton(R.string.ok, onCLickListener)
        builder.setMessage(message)

        val alert = builder.create()
        alert.setOnDismissListener(onDismissListener)
        alert.show()
    }
}