package fr.exaltit.fizz_buzz.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
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
		binding.buttonValidate.setOnClickListener {
			
			viewModel.firstMultiple = Integer.getInteger(binding.textInputFirstMultiple.text.toString()) as Int
			viewModel.secondMultiple = Integer.getInteger(binding.textInputSecondMultiple.text.toString()) as Int
			viewModel.limit = Integer.getInteger(binding.textInputLimit.text.toString()) as Int
			
			viewModel.firstWord =  binding.textInputFirstWord.text.toString()
			viewModel.secondWord =  binding.textInputSecondWord.text.toString()
			viewModel.firstWord =  binding.textInputFirstWord.text.toString()
		}
	}
	
	
	override fun onDestroy() {
		super.onDestroy()
		_binding = null
		
	}
}