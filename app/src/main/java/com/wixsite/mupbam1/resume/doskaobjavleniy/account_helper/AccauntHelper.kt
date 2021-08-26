package com.wixsite.mupbam1.resume.doskaobjavleniy.account_helper

import android.provider.ContactsContract
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.auth.FirebaseUser
import com.wixsite.mupbam1.resume.doskaobjavleniy.MainActivity
import com.wixsite.mupbam1.resume.doskaobjavleniy.R

class AccauntHelper(act:MainActivity) {
    private val act = act
        fun signUpWithEmail(email: String, password: String){
        if (email.isNotEmpty()&&password.isNotEmpty()){
            act.mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {task->
                if (task.isSuccessful){
                    sendEmailVerification(task.result?.user!!)
                    act.uiUpdate(task.result?.user)
                }else{
                    Toast.makeText(act,act.resources.getString(R.string.di_regUnSuccessfull), Toast.LENGTH_LONG).show()
                }
            }
        }
    }
    private fun sendEmailVerification(user: FirebaseUser){
        user.sendEmailVerification().addOnCompleteListener { task->
            if (task.isSuccessful){
                Toast.makeText(act,act.resources.getString(R.string.di_regVerification), Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(act,act.resources.getString(R.string.di_regUnVerification), Toast.LENGTH_LONG).show()
            }
        }
    }
}