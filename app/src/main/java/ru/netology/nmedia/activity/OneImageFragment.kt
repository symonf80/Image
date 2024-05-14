package ru.netology.nmedia.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import ru.netology.nmedia.BuildConfig
import ru.netology.nmedia.databinding.FragmentOneImageBinding
import ru.netology.nmedia.util.StringArg
import ru.netology.nmedia.view.load
import ru.netology.nmedia.viewmodel.PostViewModel

class OneImageFragment : Fragment() {

    companion object {
        var Bundle.urlArg: String? by StringArg
    }
    private val viewModel: PostViewModel by viewModels(
        ownerProducer = ::requireParentFragment,
    )
    private var fragmentBinding: FragmentOneImageBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        val binding = FragmentOneImageBinding.inflate(
            inflater,
            container,
            false
        )
        fragmentBinding = binding
        arguments?.urlArg?.let { url->
            with(binding){
                oneImage.load("${BuildConfig.BASE_URL}/media/${url}")
            }
        }

        return binding.root
    }

}