package me.mytry.calculator

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.PorterDuff
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatDelegate
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal


class MainActivity : AppCompatActivity() {

    var context : Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this
        nightLight.setOnClickListener {
            changeTheme(nightLight.isChecked)
        }
    }

    private fun changeTheme(checked: Boolean) {

        if(checked){
            layout.setBackgroundColor(ContextCompat.getColor(this, R.color.BackGround_Dark))
            layout.setBackgroundColor(ContextCompat.getColor(this, R.color.BackGround_Dark))


            pointButton.setBackgroundResource(R.drawable.button_dark_prop)
            pointButton.setTextColor(ContextCompat.getColor(this, R.color.white))
            zeroButton.setBackgroundResource(R.drawable.button_dark_prop)
            zeroButton.setTextColor(ContextCompat.getColor(this, R.color.white))
            deleteButton.setBackgroundResource(R.drawable.button_dark_prop)
            oneButton.setBackgroundResource(R.drawable.button_dark_prop)
            oneButton.setTextColor(ContextCompat.getColor(this, R.color.white))
            twoButton.setBackgroundResource(R.drawable.button_dark_prop)
            twoButton.setTextColor(ContextCompat.getColor(this, R.color.white))
            threeButton.setBackgroundResource(R.drawable.button_dark_prop)
            threeButton.setTextColor(ContextCompat.getColor(this, R.color.white))
            fourButton.setBackgroundResource(R.drawable.button_dark_prop)
            fourButton.setTextColor(ContextCompat.getColor(this, R.color.white))
            fiveButton.setBackgroundResource(R.drawable.button_dark_prop)
            fiveButton.setTextColor(ContextCompat.getColor(this, R.color.white))
            sexButton.setBackgroundResource(R.drawable.button_dark_prop)
            sexButton.setTextColor(ContextCompat.getColor(this, R.color.white))
            sevenButton.setBackgroundResource(R.drawable.button_dark_prop)
            sevenButton.setTextColor(ContextCompat.getColor(this, R.color.white))
            eightButton.setBackgroundResource(R.drawable.button_dark_prop)
            eightButton.setTextColor(ContextCompat.getColor(this, R.color.white))
            nineButton.setBackgroundResource(R.drawable.button_dark_prop)
            nineButton.setTextColor(ContextCompat.getColor(this, R.color.white))

            resultText.setTextColor(ContextCompat.getColor(this, R.color.white))
            operationText.setTextColor(ContextCompat.getColor(this, R.color.white))

            moduloButton.setBackgroundResource(R.drawable.button_top_prop)
            moduloButton.setTextColor(ContextCompat.getColor(this, R.color.white))
            nigativeButton.setBackgroundResource(R.drawable.button_top_prop)
            nigativeButton.setTextColor(ContextCompat.getColor(this, R.color.white))
            clearButton.setBackgroundResource(R.drawable.button_top_prop)
            clearButton.setTextColor(ContextCompat.getColor(this, R.color.white))
        }
        else{
            layout.setBackgroundColor(ContextCompat.getColor(this, R.color.BackGround))
            layout.setBackgroundColor(ContextCompat.getColor(this, R.color.BackGround))


            pointButton.setBackgroundResource(R.drawable.button_default_prop)
            pointButton.setTextColor(ContextCompat.getColor(this, R.color.black))
            zeroButton.setBackgroundResource(R.drawable.button_default_prop)
            zeroButton.setTextColor(ContextCompat.getColor(this, R.color.black))
            deleteButton.setBackgroundResource(R.drawable.button_default_prop)
            oneButton.setBackgroundResource(R.drawable.button_default_prop)
            oneButton.setTextColor(ContextCompat.getColor(this, R.color.black))
            twoButton.setBackgroundResource(R.drawable.button_default_prop)
            twoButton.setTextColor(ContextCompat.getColor(this, R.color.black))
            threeButton.setBackgroundResource(R.drawable.button_default_prop)
            threeButton.setTextColor(ContextCompat.getColor(this, R.color.black))
            fourButton.setBackgroundResource(R.drawable.button_default_prop)
            fourButton.setTextColor(ContextCompat.getColor(this, R.color.black))
            fiveButton.setBackgroundResource(R.drawable.button_default_prop)
            fiveButton.setTextColor(ContextCompat.getColor(this, R.color.black))
            sexButton.setBackgroundResource(R.drawable.button_default_prop)
            sexButton.setTextColor(ContextCompat.getColor(this, R.color.black))
            sevenButton.setBackgroundResource(R.drawable.button_default_prop)
            sevenButton.setTextColor(ContextCompat.getColor(this, R.color.black))
            eightButton.setBackgroundResource(R.drawable.button_default_prop)
            eightButton.setTextColor(ContextCompat.getColor(this, R.color.black))
            nineButton.setBackgroundResource(R.drawable.button_default_prop)
            nineButton.setTextColor(ContextCompat.getColor(this, R.color.black))


            resultText.setTextColor(ContextCompat.getColor(this, R.color.black))
            operationText.setTextColor(ContextCompat.getColor(this, R.color.black))

            moduloButton.setBackgroundResource(R.drawable.button_top_dark_prop)
            moduloButton.setTextColor(ContextCompat.getColor(this, R.color.black))
            nigativeButton.setBackgroundResource(R.drawable.button_top_dark_prop)
            nigativeButton.setTextColor(ContextCompat.getColor(this, R.color.black))
            clearButton.setBackgroundResource(R.drawable.button_top_dark_prop)
            clearButton.setTextColor(ContextCompat.getColor(this, R.color.black))
        }

    }


    /*Helpful Booleans to control the App */
    var isCleared: Boolean = true
    var isInt: Boolean = true
    var isDevide: Boolean = false
    /**/

    /*Var to calculate the result*/
    private val numberList : ArrayList<String> = ArrayList()
    private val operandList : ArrayList<String> = ArrayList()
    /**/




    /*onClick Functions*/

    /*For Digits [0->9]*/
    fun onDigit(view: View) {
        if (isDevide)
            if ((view as Button).text[0] == '0')
                Toast.makeText(context, "Cannot devide by zero", Toast.LENGTH_SHORT).show()
        if(operationText.text.isEmpty() || operationText.text.last() != '=') {
            if (isCleared) {

                if ((view as Button).text != "0")
                    isCleared = false

                resultText.text = (view as Button).text
            } else {
                resultText.append((view as Button).text)
            }
        }else{
            operationText.text = ""
            if((view as Button).text == "."){
                resultText.text = "0."
            }else{
                resultText.text = (view as Button).text
            }
        }


    }
    /**/

    /*onClick for clearing the text*/
    fun onClear(view: View) {
        isCleared = true
        isInt = true
        resultText.text = "0"
        operationText.text = ""
        numberList.clear()
        operandList.clear()
        operationText.textSize = 25F
    }
    /**/

    /*onClick for adding a negative value*/
    fun onNegative(view: View) {
        if(resultText.text.contains("-")) {
            var splited = resultText.text.split("-")
            resultText.text = splited[1]
        }else {
            resultText.text = "-" + resultText.text
        }
    }
    /**/

    /*DonClick for deleting one number*/
    fun onDelete(view: View) {
        if(resultText.text.length == 1){
            isCleared = true
            resultText.text = "0"
        }else {
            if (resultText.text[resultText.text.length - 1] == '.') {
                isInt = true
            }
            var x = ""
            for (i in 0 until resultText.text.length - 1) {
                x += resultText.text[i]
            }
            resultText.text = x
        }
    }
    /**/

    /*onClick for adding the dicimal point*/
    fun onDecimal(view: View) {
        if (isInt)
            resultText.append(".")
        isInt = false
        isCleared = false
    }
    /**/

    /*onClick for taking multiNumbers and make operations between them*/
    fun onOperation(view: View) {
        if(operationText.text.isEmpty() || operationText.text.last() != '=') {
            if (resultText.text[0] == '-') {
                operationText.append("(")
                operationText.append(resultText.text)
                operationText.append(")")
            } else
                operationText.append(resultText.text)
            operationText.append((view as Button).text)
            if((view as Button).text[0] == '÷')
                isDevide = true
            numberList.add((resultText.text).toString())
            operandList.add((view as Button).text.toString())
            resultText.text = "0"
            isCleared = true
            isInt = true
        }else {
            operationText.text = resultText.text
            operationText.append((view as Button).text)
            numberList.clear()
            operandList.clear()
            numberList.add((resultText.text).toString())
            operandList.add((view as Button).text.toString())
            resultText.text = "0"
            isCleared = true
            isInt = true
        }



        if(operationText.text.length >= 27){
            operationText.textSize = 20F
        }else if(operationText.text.length >= 30){
            operationText.textSize = 15F
        }

    }
    /**/

    /*For Calculating the result*/
    fun onEqual(view: View) {
        if(operationText.text.isNotEmpty() && operationText.text.last() != '=') {
            if (resultText.text[0] == '-') {
                operationText.append("(")
                operationText.append(resultText.text)
                operationText.append(")")
            } else
                operationText.append(resultText.text)
            operationText.append((view as Button).text)
            numberList.add(resultText.text.toString())
            resultText.text = calculate(numberList,operandList).toString()
        }
        else
            Toast.makeText(this,"Already Calculated",Toast.LENGTH_SHORT).show()

        if(resultText.text.contains("."))
            isInt = false
        else if(resultText.text == "0")
            isCleared = true

    }


    /**/


}

private fun calculate(A : ArrayList<String>, B : ArrayList<String>) : Number {

    var index = 0
    var cal: BigDecimal

    if(B.contains("×") || B.contains("÷") || B.contains("%")){
        while(index != B.size){
            if( B[index] == "×" ){
                cal = A[index].toBigDecimal() * A[index + 1].toBigDecimal()
            }else if(B[index] == "÷"){
                cal = A[index].toBigDecimal() / A[index + 1].toBigDecimal()
            }else if(B[index] == "%"){
                cal = A[index].toBigDecimal() % A[index + 1].toBigDecimal()
            }else{
                index += 1
                continue
            }
            B.removeAt(index)
            A.removeAt(index+1)
            A[index] = cal.toString()
        }
    }
    while(B.size != 0){
        cal = if(B[0] == "+")
            A[0].toBigDecimal() + A[1].toBigDecimal()
        else
            A[0].toBigDecimal() - A[1].toBigDecimal()


        B.removeAt(0)
        A.removeAt(1)
        A[0] = cal.toString()

    }


    return if((A[0] as CharSequence).contains(".0") )
        A[0].substring(0,A[0].length-2).toInt()
    else if (!(A[0] as CharSequence).contains("."))
        A[0].toInt()
    else
        A[0].toDouble()

}

