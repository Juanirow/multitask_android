package mx.juanma.multitask.modules.Preloader

import android.app.Activity
import android.os.Bundle
import mx.juanma.multitask.R


/**
 * Created by Juancho on 03/08/17.
 * Nakva
 * linanjm90@gmail.com
 */
class PreloaderActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preloader)

        this.fragmentManager.beginTransaction()
                .add(R.id.content_preloader, PreloaderFragment.getInstance())
                .commit()
    }
}