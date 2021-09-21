package jp.techacademy.rie.okano.aisatsuapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.TimePickerDialog
import android.util.Log  // ← ここを追加
import android.view.View
import kotlinx.android.synthetic.main.activity_main.* // ← ここを追加

class MainActivity : AppCompatActivity(), View.OnClickListener  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
            showTimePickerDialog()
            Log.d("UI_PARTS", "ボタンをタップしました")
        }

        button1.text = "あいさつ"  // ← ここを追加
    }

    override fun onClick(v: View) {
            showTimePickerDialog()
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                if (hour < 2||hour >= 18) {
                    textView.text = "こんばんは"
                } else if  (hour < 10) {
                    textView.text = "おはよう"
                } else {
                    textView.text = "こんにちは"
                }

                Log.d("UI_PARTS", "$hour:$minute")
            },
            13, 0, true)

        timePickerDialog.show()

    }
}