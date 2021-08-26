package com.wixsite.mupbam1.resume.doskaobjavleniy.dialogHelper

import android.app.AlertDialog
import com.wixsite.mupbam1.resume.doskaobjavleniy.MainActivity
import com.wixsite.mupbam1.resume.doskaobjavleniy.R
import com.wixsite.mupbam1.resume.doskaobjavleniy.account_helper.AccauntHelper
import com.wixsite.mupbam1.resume.doskaobjavleniy.databinding.SignDialogBinding

class DialogHelper(act:MainActivity) {
    val act1 = act
    private val accountHelper= AccauntHelper(act)
    fun createSignDialog(index:Int){
        val builder = AlertDialog.Builder(act1)
        val rootDialogElement = SignDialogBinding.inflate(act1.layoutInflater)
        val view = rootDialogElement.root
        if (index == DialogConst.SIGN_UP_STATE){
            rootDialogElement.tvTitle.text = act1.resources.getString(R.string.ad_signUp)
            rootDialogElement.btSignUpIn.text = act1.resources.getString(R.string.di_reg)
        }else{
            rootDialogElement.tvTitle.text = act1.resources.getString(R.string.ad_signIn)
            rootDialogElement.btSignUpIn.text = act1.resources.getString(R.string.di_signIn)
        }
        rootDialogElement.btSignUpIn.setOnClickListener {
            if (index == DialogConst.SIGN_UP_STATE){
                accountHelper.signUpWithEmail(rootDialogElement.edSignEmail.text.toString(),
                    rootDialogElement.edPassword.text.toString())
            }else{

            }
        }
        builder.setView(view)
        builder.show()
    }
}