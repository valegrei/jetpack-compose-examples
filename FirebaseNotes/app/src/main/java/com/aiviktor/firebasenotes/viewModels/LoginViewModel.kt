package com.aiviktor.firebasenotes.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {

    private val auth: FirebaseAuth = Firebase.auth
    fun login(email: String, password: String, onSuccess: () -> Unit){
        viewModelScope.launch {
            try{
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener{task ->
                        if(task.isSuccessful){
                            onSuccess()
                        }else{
                            Log.d("ERROR EN FIREBASE","Usuario y contraseña incorrectas")
                        }
                    }
            }catch (e: Exception){
                Log.d("Error en Jetpack","Error: ${e.localizedMessage}")
            }
        }
    }
}