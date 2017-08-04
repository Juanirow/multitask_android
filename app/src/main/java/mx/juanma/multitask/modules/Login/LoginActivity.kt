package mx.juanma.multitask.modules.Login

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

import mx.juanma.multitask.R
import mx.juanma.multitask.modules.Main.MainPresenter

class LoginActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        this.fragmentManager.beginTransaction()
                .add(R.id.content_login, LoginFragment.getInstance())
                .commit()
    }
}
