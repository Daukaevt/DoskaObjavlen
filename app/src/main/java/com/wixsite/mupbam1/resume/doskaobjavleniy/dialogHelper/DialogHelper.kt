package com.wixsite.mupbam1.resume.doskaobjavleniy.dialogHelper

import android.app.AlertDialog
import com.wixsite.mupbam1.resume.doskaobjavleniy.MainActivity
import com.wixsite.mupbam1.resume.doskaobjavleniy.databinding.SignDialogBinding

class DialogHelper(act:MainActivity) {
    val act1 = act
    fun createSignDialog(){
        val builder = AlertDialog.Builder(act1)
        val rootDialogElement = SignDialogBinding.inflate(act1.layoutInflater)
        val view = rootDialogElement.root
        builder.setView(view)
        builder.show()
    }
}