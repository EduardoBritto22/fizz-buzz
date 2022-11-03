package fr.exaltit.fizz_buzz.presentation.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import fr.exaltit.fizz_buzz.R
import fr.exaltit.fizz_buzz.databinding.FragmentFizzbuzzFormBinding
import fr.exaltit.fizz_buzz.presentation.FizzBuzzViewModel


/**
 * The [Fragment] with teh form to get the parameters.
 */
@AndroidEntryPoint
class FizzBuzzFormFragment : Fragment() {
	
	private val viewModel by activityViewModels<FizzBuzzViewModel>()
	
	private var _binding: FragmentFizzbuzzFormBinding? = null
	// This property is only valid between onCreateView and
	// onDestroyView.
	private val binding get() = _binding!!
	
	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		// Inflate the layout for this fragment
		_binding = FragmentFizzbuzzFormBinding.inflate(inflater, container, false)
		val view = binding.root
		return view
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		viewModel.showNextFragment(false)
		setUi()
	}
	
	override fun onDestroy() {
		super.onDestroy()
		_binding = null
	}
	
	private fun setUi() {
		val textWatcher = object : TextWatcher {
			override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
			
			override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
			
			override fun afterTextChanged(s: Editable?) = checkValidation()
		}
		
		setTextWatchers(textWatcher)
		
		preFillFizzBuzzForm()
		
		setUpButton()
	}
	
	private fun setUpButton() {
		checkValidation()
		binding.buttonValidate.setOnClickListener {
			
			val firstMultiple = (binding.textInputFirstMultiple.text.toString().toLong())
			val secondMultiple = binding.textInputSecondMultiple.text.toString().toLong()
			val limit = binding.textInputLimit.text.toString().toLong()
			
			val firstWord = binding.textInputFirstWord.text.toString()
			val secondWord = binding.textInputSecondWord.text.toString()
			
			viewModel.setFizzBuzzData(firstWord, secondWord, firstMultiple, secondMultiple, limit)
			viewModel.showNextFragment(true)
		}
	}
	
	private fun setTextWatchers(textWatcher: TextWatcher) {
		//Add listeners to verify if any field is empty
		binding.textInputFirstWord.addTextChangedListener(textWatcher)
		binding.textInputSecondWord.addTextChangedListener(textWatcher)
		binding.textInputFirstMultiple.addTextChangedListener(textWatcher)
		binding.textInputSecondMultiple.addTextChangedListener(textWatcher)
		binding.textInputLimit.addTextChangedListener(textWatcher)
	}
	
	private fun checkValidation() {
		binding.buttonValidate.isEnabled = !(binding.textInputFirstMultiple.text.isNullOrEmpty()
				|| binding.textInputSecondMultiple.text.isNullOrEmpty()
				|| binding.textInputLimit.text.isNullOrEmpty()
				|| binding.textInputFirstWord.text.isNullOrEmpty()
				|| binding.textInputSecondWord.text.isNullOrEmpty())
				
				&& (binding.textInputFirstMultiple.error.isNullOrEmpty()
					&& binding.textInputSecondMultiple.error.isNullOrEmpty()
					&& binding.textInputLimit.error.isNullOrEmpty()
					&& binding.textInputFirstWord.error.isNullOrEmpty()
					&& binding.textInputSecondWord.error.isNullOrEmpty())
		
		checkNumberEquals0()
		
	}
	
	private fun preFillFizzBuzzForm() {
		val buzzData = viewModel.getFizzBuzzData()
		
		buzzData?.run {
			binding.textInputFirstWord.setText(firstWord)
			binding.textInputSecondWord.setText(secondWord)
			binding.textInputFirstMultiple.setText(firstMultiple.toString())
			binding.textInputSecondMultiple.setText(secondMultiple.toString())
			binding.textInputLimit.setText(limit.toString())
		}
	}
	
	
	private fun checkNumberEquals0() {
		if (binding.textInputFirstMultiple.text.toString() == "0") {
			binding.textInputFirstMultiple.error = getString(R.string.message_error_fill_multiple)
		} else {
			binding.textInputFirstMultiple.error = null
		}
		
		if (binding.textInputSecondMultiple.text.toString() ==  "0") {
			binding.textInputSecondMultiple.error = getString(R.string.message_error_fill_multiple)
		} else {
			binding.textInputSecondMultiple.error = null
		}
		
		if (binding.textInputLimit.text.toString() == "0") {
			binding.textInputLimit.error = getString(R.string.message_error_fill_limit)
		} else {
			binding.textInputLimit.error = null
		}
	}
}