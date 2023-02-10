package fr.exaltit.fizz_buzz.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import fr.exaltit.fizz_buzz.databinding.FragmentFizzbuzzViewBinding
import fr.exaltit.fizz_buzz.presentation.FizzBuzzViewModel
import fr.exaltit.fizz_buzz.presentation.adapters.FizzBuzzAdapter


/**
 * The [Fragment] to show the text of the fizz buzz app.
 */
@AndroidEntryPoint
class FizzBuzzViewFragment : Fragment() {
	
	private val viewModel by activityViewModels<FizzBuzzViewModel>()
	
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
		return binding.root
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		
		val layoutManager = LinearLayoutManager(requireContext())
		binding.fizzbuzzRecyclerview.layoutManager = layoutManager
		binding.loadingFizzbuzzText.visibility = View.VISIBLE
		binding.fizzbuzzRecyclerview.visibility = View.GONE
		
		lifecycleScope.launchWhenResumed {
			
			viewModel.fizzBuzzStringList.observe(viewLifecycleOwner){loaded ->
				
				if(!loaded.isNullOrEmpty()){
					binding.fizzbuzzRecyclerview.adapter = FizzBuzzAdapter(loaded)
					binding.fizzbuzzRecyclerview.visibility = View.VISIBLE
					binding.loadingFizzbuzzText.visibility = View.GONE
				}

			}
		}
	}
	
	override fun onDestroy() {
		super.onDestroy()
		_binding = null
		
	}
}