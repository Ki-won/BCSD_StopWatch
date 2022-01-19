package com.example.calculator

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import org.w3c.dom.Text

class CalculatorFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        return inflater.inflate(R.layout.fragment_calculator, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val expressionTextView: TextView by lazy {
            view.findViewById<TextView>(R.id.txt_expression)
        }
        val resultTextView: TextView by lazy {
            view.findViewById<TextView>(R.id.txt_result)
        }
        var isOperator = false
        var hasOperator = false


        fun buttonClicked(v: View) {

            fun calculateExpression(): String {
                val expressionTexts = expressionTextView.text.split(" ")

                if (hasOperator.not() || expressionTexts.size != 3) {
                    return ""
                } else if (expressionTexts[0].isNumber().not() || expressionTexts[2].isNumber()
                        .not()
                ) {
                    return ""
                }
                val exp1 = expressionTexts[0].toBigInteger()
                val exp2 = expressionTexts[2].toBigInteger()

                return when (expressionTexts[1]) {
                    "+" -> (exp1 + exp2).toString()
                    "-" -> (exp1 - exp2).toString()
                    "X" -> (exp1 * exp2).toString()
                    "%" -> (exp1 % exp2).toString()
                    "/" -> (exp1 / exp2).toString()
                    else -> ""
                }
            }


            fun numberButtonClicked(
                if (isOperator) {
                expressionTextView.append(" ")
            }
            isOperator = false

            val expressionText = expressionTextView.text.split(" ")
            if (expressionText.isNotEmpty() && expressionText.last().length >= 15) {
                Toast.makeText(this, "15자리 까지만 사용할수 있습니다.", Toast.LENGTH_SHORT).show()
                return
            } else if (expressionText.last().isEmpty() && number == "0") {
                Toast.makeText(this, "0은 제일앞에 올 수 없습니다.", Toast.LENGTH_SHORT).show()
                return
            }
            expressionTextView.append(number)
            resultTextView.text = calculateExpression()
        }


        fun operatorButtonClicked(operator: String) {//연산기호 받는 식
            if (expressionTextView.text.isEmpty()) {
                return
            }

            when {
                isOperator -> {
                    val text = expressionTextView.text.toString()
                    expressionTextView.text = text.dropLast(1) + operator
                }
                hasOperator -> {
                    Toast.makeText(this, "연산자는 한번만 사용할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    return
                }
                else -> {
                    expressionTextView.append(" $operator")
                }
            }
            val ssb = SpannableStringBuilder(expressionTextView.text) // 글자색 변경
            ssb.setSpan(
                ForegroundColorSpan(getColor(R.color.green)),
                expressionTextView.text.length - 1, expressionTextView.text.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            expressionTextView.text = ssb
            isOperator = true
            hasOperator = true
        }


        fun resultButtonClicked(v: View) {
            val expressionTexts = expressionTextView.text.split(" ")
            if (expressionTextView.text.isEmpty() || expressionTexts.size == 1) {
                return
            }
            if (expressionTexts.size != 3 && hasOperator) {
                Toast.makeText(this, "수식을 완성해주세요", Toast.LENGTH_SHORT).show()
                return
            }
            if (expressionTexts[0].isNumber().not() || expressionTexts[2].isNumber().not()) {
                Toast.makeText(this, "오류가 발생했습니다.", Toast.LENGTH_SHORT).show()

                return
            }
            val expressionText = expressionTextView.text.toString()
            val resultText = calculateExpression()

            resultTextView.text = ""
            expressionTextView.text = resultText

            isOperator = false
            hasOperator = false

        }


        when (v.id) {
            R.id.pad_zero -> numberButtonClicked()
            R.id.pad_one -> numberButtonClicked("1")
            R.id.pad_two -> numberButtonClicked("2")
            R.id.pad_three -> numberButtonClicked("3")
            R.id.pad_four -> numberButtonClicked("4")
            R.id.pad_five -> numberButtonClicked("5")
            R.id.pad_six -> numberButtonClicked("6")
            R.id.pad_seven -> numberButtonClicked("7")
            R.id.pad_eight -> numberButtonClicked("8")
            R.id.pad_nine -> numberButtonClicked("9")

            R.id.pad_plus -> operatorButtonClicked("+")
            R.id.pad_subtraction -> operatorButtonClicked("-")
            R.id.pad_multiply -> operatorButtonClicked("X")
            R.id.pad_slash -> operatorButtonClicked("/")
            R.id.pad_percent -> operatorButtonClicked("%")
        }
    }

    fun clearButtonClicked(v: View) { //초기화 함수
        expressionTextView.text = ""
        resultTextView.text = ""
        isOperator = false
        hasOperator = false
    }

    fun historyButtonClicked(v: View) {
    }
}

private fun String.isNumber(): Boolean {
    return try {
        this.toBigInteger()
        true
    } catch (e: NumberFormatException) {
        false
    }


}
}
