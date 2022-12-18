package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.viewbinding.ViewBinding
import com.example.mycalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityMainBinding
    var a: Double?=null
    var b:Double?=null
    var c:String?=null
    var typeNewLine=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.bC.setOnClickListener(View.OnClickListener { reset() })
        viewBinding.b0.setOnClickListener(View.OnClickListener { funcDisplay(viewBinding.b0.text.toString()) })
        viewBinding.b1.setOnClickListener(View.OnClickListener { funcDisplay(viewBinding.b1.text.toString()) })
        viewBinding.b2.setOnClickListener(View.OnClickListener { funcDisplay(viewBinding.b2.text.toString()) })
        viewBinding.b3.setOnClickListener(View.OnClickListener { funcDisplay(viewBinding.b3.text.toString()) })
        viewBinding.b4.setOnClickListener(View.OnClickListener { funcDisplay(viewBinding.b4.text.toString()) })
        viewBinding.b5.setOnClickListener(View.OnClickListener { funcDisplay(viewBinding.b5.text.toString()) })
        viewBinding.b6.setOnClickListener(View.OnClickListener { funcDisplay(viewBinding.b6.text.toString()) })
        viewBinding.b7.setOnClickListener(View.OnClickListener { funcDisplay(viewBinding.b7.text.toString()) })
        viewBinding.b8.setOnClickListener(View.OnClickListener { funcDisplay(viewBinding.b8.text.toString()) })
        viewBinding.b9.setOnClickListener(View.OnClickListener { funcDisplay(viewBinding.b9.text.toString()) })
        viewBinding.bminus.setOnClickListener(View.OnClickListener { funcSubs() })
        viewBinding.bequals.setOnClickListener(View.OnClickListener { funcResult() })
        viewBinding.bplus.setOnClickListener(View.OnClickListener { funcAddi()})
        viewBinding.bdevide.setOnClickListener(View.OnClickListener { funcDev() })
        viewBinding.bX.setOnClickListener(View.OnClickListener { funcMulti() })
        viewBinding.bdot.setOnClickListener(View.OnClickListener { funcDisplay(viewBinding.bdot.text.toString()) })
        viewBinding.bpercent.setOnClickListener(View.OnClickListener { funcPercent() })
        viewBinding.bplusminus.setOnClickListener(View.OnClickListener { funcPlusMinus() })

    }
    fun funcDisplay(s:String){
        if(typeNewLine==true){
            viewBinding.textview.text=""
        }
        var t1=viewBinding.textview.text.toString()
        var t2=""
        if(s==".") {
            t2=t1+s
        }else if(t1=="0"){
            t2=s
        }else{
            t2=t1+s
        }
        viewBinding.textview.text=t2
        typeNewLine=false
    }
    fun funcMulti(){
        var t1=viewBinding.textview.text.toString()
        if(!t1.isNullOrBlank()){
            a=t1.toDouble()
            c="*"
            typeNewLine=true
        }
    }
    fun funcDev(){
        var t1=viewBinding.textview.text.toString()
        if(!t1.isNullOrBlank()){
            a=t1.toDouble()
            c="/"
            typeNewLine=true
        }
    }
    fun funcAddi(){
        var t1=viewBinding.textview.text.toString()
        if(!t1.isNullOrBlank()){
            a=t1.toDouble()
            c="+"
            typeNewLine=true
        }
    }
    fun funcSubs(){
        var t1=viewBinding.textview.text.toString()
        if(!t1.isNullOrBlank()){
            a=t1.toDouble()
            c="-"
            typeNewLine=true
        }
    }
    fun funcResult(){
        if(a!=null && c!=null && b==null){
            b=viewBinding.textview.text.toString().toDouble()
            var result=0.0
            when(c){
                "*" -> {
                    result= a!! * b!!
                }
                "-" -> {
                    result= a!! - b!!
                }
                "+" -> {
                    result= a!! + b!!
                }
                "/" -> {
                    result= a!! / b!!
                }
            }
            reset()
            viewBinding.textview.text=result.toString()
        }

    }
    fun reset(){
        a=null ; b=null; c=null ; typeNewLine=false
        viewBinding.textview.text="0"
    }
    fun funcPercent(){
        var t1=viewBinding.textview.text.toString()
        var s=""
        if(!t1.isNullOrBlank()){
            if(t1=="100"){ s="1" }
            else{ s="0."+t1}
            viewBinding.textview.text=s
        }
    }
    fun funcPlusMinus(){
        var t1=viewBinding.textview.text.toString()
        if(!t1.isNullOrBlank()){
            viewBinding.textview.text="-"+t1
        }
    }


}