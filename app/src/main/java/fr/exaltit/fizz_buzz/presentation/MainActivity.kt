package fr.exaltit.fizz_buzz.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import dagger.hilt.android.AndroidEntryPoint
import fr.exaltit.fizz_buzz.R
import fr.exaltit.fizz_buzz.presentation.fragments.FizzBuzzFormFragment

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    
    private val viewModel: FizzBuzzViewModel by viewModels()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showFragment()
    }
    
    private fun showFragment() {
        // Begin the transaction
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        // Replace the contents of the container with the new fragment
        ft.replace(R.id.fragment_main, FizzBuzzFormFragment())
        ft.commit()
    }
    
}