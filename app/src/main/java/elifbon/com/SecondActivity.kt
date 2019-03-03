package elifbon.com

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_second.*




class SecondActivity : AppCompatActivity() {

    private val LOG_TAG = SecondActivity::class.java.simpleName

    companion object {
        val EXTRA_MESSAGE = "elifbon.com.extra.REPLY"

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");

        setContentView(R.layout.activity_second)

        val intent = intent
        val message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)

        text_message.setText(message);

    }

    public override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "onStart")
    }


    public override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onStart")
    }


    fun returnReply(view:View){
        val reply = reply_text.getText().toString()
        val intent:Intent = Intent()
        intent.putExtra(EXTRA_MESSAGE, reply)
        setResult(RESULT_OK,intent);
        Log.d(LOG_TAG, "End SecondActivity");
        finish()
    }
}
