package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalculate.setOnClickListener() {
            try {
                val weight: Double = editWeight.text.toString().toDouble()
                val height: Double = editHeight.text.toString().toDouble()

                val bmi: Double = weight / (height * height)
                val result: String

                if (bmi <= 18.5) {
                    result = "UNDER"
                    imgResult.setImageResource(R.drawable.under)
                } else if (bmi <= 24.9) {
                    result = "NORMAL"
                    imgResult.setImageResource(R.drawable.normal)
                } else {
                    result = "OVER"
                    imgResult.setImageResource(R.drawable.over)
                }


               bmi_result.text = "BMI: %.2f (%s)".format(bmi, result)


            }catch (e:Exception){
                val toast: Toast = Toast.makeText(this, "Invalid Input" ,Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER,0,0)
                toast.show()
            }
        }

        btnReset.setOnClickListener(){
            editWeight.setText("")
            editHeight.setText("")
            bmi_result.setText("")
//
            imgResult.setImageResource(R.drawable.empty)
        }
    }
}
