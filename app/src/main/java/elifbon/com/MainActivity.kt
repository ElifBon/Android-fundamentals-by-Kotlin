package elifbon.com

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val LOG_TAG = MainActivity::class.java.simpleName


    companion object {
        val EXTRA_MESSAGE = "elifbon.com.extra.MESSAGE"

        val TEXT_REQUEST = 1
    }

    lateinit var mMessageEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");

        setContentView(R.layout.activity_main)

        mMessageEditText = findViewById(R.id.editText_main);

        if(savedInstanceState != null){
            var visibility:Boolean = savedInstanceState.getBoolean("reply_visible")
            if(visibility){
                text_header_reply.visibility = View.VISIBLE
                text_message_reply.visibility = View.VISIBLE
                var message:String = savedInstanceState.getString("reply_text")
                text_message_reply.setText(message)
            }
        }
    }

    public override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "onStart")
    }


    public override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onStart")
    }


    fun launchSecondActivity(view:View){
        Log.d(LOG_TAG, "Button clicked!");

        val intent = Intent(this, SecondActivity::class.java)
        val message = mMessageEditText.text.toString()
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            TEXT_REQUEST -> getResult(resultCode, data)
        }
    }

    private fun getResult(resultCode: Int, data: Intent?) {
        if(resultCode == Activity.RESULT_OK ){
            val reply = data?.getStringExtra(SecondActivity.EXTRA_MESSAGE)
            if(!reply.isNullOrBlank()) {
                text_header_reply.setVisibility(View.VISIBLE)
                text_message_reply.setText(reply)
                text_message_reply.setVisibility(View.VISIBLE)
            }else{
                text_message_reply.setText("")
                text_header_reply.setVisibility(View.INVISIBLE)
                text_message_reply.setVisibility(View.INVISIBLE)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        if (text_header_reply.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible", true)
            outState.putString("reply_text",text_message_reply.getText().toString())

        }
    }
}
