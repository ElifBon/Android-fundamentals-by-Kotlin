package elifbon.com

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var mCount:Int = 0
    private lateinit var mShowCount:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mShowCount = findViewById(R.id.show_count) as TextView
    }

    fun showToast(view:View){
        Toast.makeText(this, resources.getString(R.string.toast_message), Toast.LENGTH_LONG).show()

    }

    fun countUp(view: View){
        mCount++
        mShowCount.setText(mCount.toString())
    }
}
