package com.example.calculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val calculator = calculator()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)
            button0.setOnClickListener(::onClickButtonZeroAlon)
            button1.setOnClickListener {
                calculator.setValue("1", null)
                forEveryButton()
            }
            button2.setOnClickListener {
                calculator.setValue("2", null)
                forEveryButton()
            }
            button3.setOnClickListener {
                calculator.setValue("3", null)
                forEveryButton()
            }
            button4.setOnClickListener {
                calculator.setValue("4", null)
                forEveryButton()
            }
            button5.setOnClickListener {
                calculator.setValue("5", null)
                forEveryButton()
            }
            button6.setOnClickListener {
                calculator.setValue("6", null)
                forEveryButton()
            }
            button7.setOnClickListener {
                calculator.setValue("7", null)
                forEveryButton()
            }
            button8.setOnClickListener {
                calculator.setValue("8", null)
                forEveryButton()
            }
            button9.setOnClickListener {
                calculator.setValue("9", null)
                forEveryButton()
            }
            buttonStory?.setOnClickListener {
                val intent: Intent = Intent(this@MainActivity, MainActivity2::class.java)
                startActivity(intent)
            }
            buttonDeleteAll.setOnClickListener(::onDeleteClick)
            buttonDeleteAll.setOnLongClickListener(::onDeleteLongClick)
            buttonEqual.setOnClickListener(::onClickEqual)
            buttonDivision.setOnClickListener {
                if (calculator.operation1 == '\u0000') {
                    calculator.setValue("", '÷')
                    forEveryButton()
                } else {
                    calculator.equal('÷')
                    forEveryButton()
                }
            }
            buttonPlus.setOnClickListener {
                if (calculator.operation1 == '\u0000') {
                    calculator.setValue("", '+')
                    forEveryButton()
                } else {
                    calculator.equal('+')
                    forEveryButton()
                }
            }
            buttonMinus.setOnClickListener {
                if (calculator.operation1 == '\u0000') {
                    calculator.setValue("", '-')
                    forEveryButton()
                } else {
                    calculator.equal('-')
                    forEveryButton()
                }

            }
            buttonMultiplication.setOnClickListener {
                if (calculator.operation1 == '\u0000') {
                    calculator.setValue("", '×')
                    forEveryButton()
                } else {
                    calculator.equal('×')
                    forEveryButton()
                }
            }
            buttonExponentiation.setOnClickListener {
                if (calculator.operation1 == '\u0000') {
                    calculator.setValue("", '^')
                    forEveryButton()
                } else {
                    calculator.equal('^')
                    forEveryButton()
                }
            }
            buttonPercent.setOnClickListener {
                if (calculator.operation1 == '\u0000') {
                    calculator.setValue("", '%')
                    forEveryButton()
                } else {
                    calculator.equal('%')
                    forEveryButton()
                }
            }
            buttonPoint.setOnClickListener(::onClickButtonPoint)
        }
    }


    private fun onDeleteClick(view: View) {
        calculator.delete()
        val text: String = calculator.getDisplayText()
        if (text != "") binding.inputTextView?.text = text
    }

    private fun onDeleteLongClick(view: View): Boolean {
        calculator.deleteAll()
        binding.inputTextView?.text = ""
        return true
    }

    private fun onClickEqual(view: View) {
        calculator.equal()
        forEveryButton()
    }

    private fun forEveryButton() {
        val text: String = calculator.getDisplayText()
        binding.inputTextView?.text = text
    }

    private fun onClickButtonZeroAlon(view: View) {
        val zero: String = "0"
        val zeroAndPoint: String = "0."
        if (calculator.firstNumber == zero && calculator.firstNumber != zeroAndPoint ||
            calculator.secondNumber == zero && calculator.secondNumber != zeroAndPoint
        ) print("ok")
        else {
            calculator.setValue(zero, null)
            forEveryButton()
        }
    }

    private fun onClickButtonPoint(view: View) {
        val point: String = "."
        if (calculator.firstNumber == "" ||
            calculator.firstNumber.contains(point)
        ) {
            println("have not number");
        } else {
            calculator.setValue(point, null);
            forEveryButton()
        }
        if (calculator.secondNumber == "" || calculator.secondNumber
                .contains(point)
        ) {
            println("have not number");
        } else {
            calculator.setValue(point, null);
            forEveryButton()
        }
    }
}