package elifbon.com

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    private val mColorArray = arrayOf(
        "red",
        "pink",
        "purple",
        "deep_purple",
        "indigo",
        "blue",
        "light_blue",
        "cyan",
        "teal",
        "green",
        "light_green",
        "lime",
        "yellow",
        "amber",
        "orange",
        "deep_orange",
        "brown",
        "grey",
        "blue_grey",
        "black"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // restore saved instance state (the text color)
        if (savedInstanceState != null) {
            hello_textview.setTextColor(savedInstanceState.getInt("color"));
        }
    }

    fun changeColor(view: View){
        val random = Random()

        val colorName = mColorArray[random.nextInt(20)]
        val colorResourceName = resources.getIdentifier(
            colorName,
            "color", applicationContext.packageName
        )

        val colorRes = ContextCompat.getColor(this, colorResourceName)

        hello_textview.setTextColor(colorRes)

    }

    public override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // save the current text color
        outState.putInt("color", hello_textview.getCurrentTextColor())
    }
}
