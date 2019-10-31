package com.example.execise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var locale= Locale.getDefault()
        var currency = Currency.getInstance(locale)
        var symbol = currency.getSymbol()

        buttonCalculate.setOnClickListener {
            var filled = true
            if(editTextCarPrice.text.length==0){
                editTextCarPrice.setError("Invalid")
                filled =false
            }
            if(editTextDownPayment.text.length==0){
                editTextDownPayment.setError("Invalid")
                filled =false
            }
            if(editTextInterestRate.text.length==0){
                editTextInterestRate.setError("Invalid")
                filled =false
            }
            if(editTextLoanPeriod.text.length==0){
                editTextLoanPeriod.setError("Invalid")
                filled =false
            }


            if(filled == true) {
                var car_price = editTextCarPrice.text.toString().toInt()
                var down_payment = editTextDownPayment.text.toString().toInt()
                var loan_period = editTextLoanPeriod.text.toString().toInt()
                var interest_rate = editTextInterestRate.text.toString().toFloat()
                //TODO : continue your calculation here :^)
                var car_loan = car_price - down_payment
                textViewLoan.text = getString(R.string.loan) +symbol.toString()+ " ${car_loan}"
                var interest = car_loan * interest_rate / 100 * loan_period
                textViewInterest.text = getString(R.string.interest) +symbol.toString()+ " ${interest}"
                var monthly_payment = (car_loan + interest) / loan_period / 12
                textViewMonthlyPayment.text =getString(R.string.monthly_payment) +symbol.toString()+ " ${monthly_payment}"
            }
        }

    }

    fun resetInputs(view: View) {
        //TODO : reset all inputs and outputs
        editTextCarPrice.setText("")
        editTextDownPayment.setText("")
        editTextInterestRate.setText("")
        editTextLoanPeriod.setText("")
        textViewLoan.setText("")
        textViewInterest.setText("")
        textViewMonthlyPayment.setText("")
    }


}
