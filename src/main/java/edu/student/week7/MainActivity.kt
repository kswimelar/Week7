package edu.student.week7

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //bind objects
        var txtMessage = findViewById<EditText>(R.id.txtMessage)
        var btnSubmit = findViewById<Button>(R.id.btnSubmit)
        //get focus on txtMessage at runtime
        txtMessage.requestFocus()
        //Submit Button Action
        btnSubmit.setOnClickListener{
            //Showing message by concatenating string and ${variable}
            //adding Toast message. DO NOT TYPE IN GREYSCALE TEXT context: and text:
            Toast.makeText(this,"The Message is: ${txtMessage.text.toString()}",Toast.LENGTH_LONG) .show()
            //Hide Keyboard
            hideKeyboard()
            //clear txtMessage
            txtMessage.setText("")
            //Set focus back on txtMessage
            txtMessage.requestFocus()
        }

        //Fire hidekeyboard when user taps outside any text object
//Place below code right before last right bracket in function onCreate
        findViewById<View>(android.R.id.content).setOnTouchListener { _, event ->
            hideKeyboard()
            false
        }
    }
    fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            // TODO: handle exception
        }

    }
}