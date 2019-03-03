package elifbon.com

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openWebsite(view:View){

        var url:String = website_edittext.text.toString()

        var webpage: Uri = Uri.parse(url)

        val intent = Intent(Intent.ACTION_VIEW, webpage)

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent)
        }else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }

    }

    fun openLocation(view:View){

    }

    fun shareText(view:View){

    }
}
