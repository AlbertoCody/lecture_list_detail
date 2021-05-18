package xyz.gonzapico.imaginaformacion_test

import android.content.Context
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat

class OddEvenEditText : AppCompatEditText {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) :
            super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) :
            super(context, attrs, defStyleAttr)

    init {
        // Soportará números
        inputType = InputType.TYPE_CLASS_NUMBER
        addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if(!p0.isNullOrEmpty()){
                    if(p0.toString().toDouble()%2 == 0.0){
                        background.colorFilter =
                            BlendModeColorFilterCompat.createBlendModeColorFilterCompat(
                                ContextCompat.getColor(context, android.R.color.holo_blue_light),
                                BlendModeCompat.SRC_IN
                            )
                    }else{
                        background.colorFilter =
                            BlendModeColorFilterCompat.createBlendModeColorFilterCompat(
                                ContextCompat.getColor(context, android.R.color.holo_red_dark),
                                BlendModeCompat.SRC_IN
                            )
                    }
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })
    }


}