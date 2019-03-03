package elifbon.com

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = intent
        val uri = intent.data
        if (uri != null) {
            val uri_string =  uri.toString()
            text_uri_message.setText(uri_string)
        }
    }
}
