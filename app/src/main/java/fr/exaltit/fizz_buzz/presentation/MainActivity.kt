package fr.exaltit.fizz_buzz.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import fr.exaltit.fizz_buzz.R
import fr.exaltit.fizz_buzz.presentation.fragments.FizzBuzzFormFragment
import fr.exaltit.fizz_buzz.presentation.fragments.FizzBuzzViewFragment

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    
    private val viewModel: FizzBuzzViewModel by viewModels()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showFragment()
        observeFizzBuzzData()
    }
    
    private fun observeFizzBuzzData() {
        
        val observer =  Observer<Boolean>{ gotToNextFragment ->
            // Begin the transaction
            // Replace the contents of the container with the new fragment
            if(gotToNextFragment){
                val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
                ft.replace(R.id.fragment_main, FizzBuzzViewFragment())
                ft.addToBackStack(null)
                ft.commit()
            }
        }
        
        viewModel.isLoading.observe(this,observer)
    }
    
    private fun showFragment() {
        // Begin the transaction
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        // Replace the contents of the container with the new fragment
        ft.replace(R.id.fragment_main, FizzBuzzFormFragment())
        ft.commit()
    }
    
}