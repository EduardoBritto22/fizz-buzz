package fr.exaltit.fizz_buzz.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import fr.exaltit.fizz_buzz.databinding.FragmentFizzbuzzViewBinding

/**
 * The [Fragment] to show the text of the fizz buzz app.
 */
class FizzBuzzViewFragment : Fragment() {

	
	private var _binding: FragmentFizzbuzzViewBinding? = null
	// This property is only valid between onCreateView and
	// onDestroyView.
	private val binding get() = _binding!!
	
	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		// Inflate the layout for this fragment
		_binding = FragmentFizzbuzzViewBinding.inflate(inflater, container, false)
		val view = binding.root
		return view
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		binding.textViewShowText
	}
	
	
	override fun onDestroy() {
		super.onDestroy()
		_binding = null
		
	}
}