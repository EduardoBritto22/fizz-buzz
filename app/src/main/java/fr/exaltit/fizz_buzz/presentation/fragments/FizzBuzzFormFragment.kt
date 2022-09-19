package fr.exaltit.fizz_buzz.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import fr.exaltit.fizz_buzz.databinding.FragmentFizzbuzzFormBinding


/**
 * The [Fragment] with teh form to get the parameters.
 */
class FizzBuzzFormFragment : Fragment() {

	
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
			binding.textInputFirstWord
			binding.textInputSecondWord
			binding.textInputFirstMultiple
			binding.textInputSecondMultiple
			binding.textInputLimit
		}
	}
	
	
	override fun onDestroy() {
		super.onDestroy()
		_binding = null
		
	}
}