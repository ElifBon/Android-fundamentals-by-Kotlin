package elifbon.com

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.EditText



class MainActivity : AppCompatActivity() {

    private val LOG_TAG = MainActivity::class.java.simpleName


    companion object {
        val EXTRA_MESSAGE = "elifbon.com.extra.MESSAGE"
    }

    lateinit var mMessageEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mMessageEditText = findViewById(R.id.editText_main);
    }

    fun launchSecondActivity(view:View){
        Log.d(LOG_TAG, "Button clicked!");

        val intent = Intent(this, SecondActivity::class.java)
        val message = mMessageEditText.text.toString()
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent)
    }
}
