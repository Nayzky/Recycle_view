package com.example.recycle_view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.recycle_view.databinding.DisasterDetailFragmentBinding

class DisasterDetailFragment : DialogFragment() {

    private lateinit var binding: DisasterDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DisasterDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val disaster = arguments?.getParcelable<Disaster>(ARG_DISASTER)

        if (disaster != null) {
            binding.imgDisaster.setImageResource(R.drawable.d)
            binding.txtdetail.text = "An anime that depicts the struggle and hope of someone who is belittled and underestimated, until the point where they start to rise and shine at the peak. Keep on fighting."
        }
    }

    companion object {
        const val TAG = "com.example.recycle_view.com.example.recycle_view.DisasterDetailFragment"
        private const val ARG_DISASTER = "arg_disaster"

        fun newInstance(disaster: Disaster): DisasterDetailFragment {
            val args = Bundle()
            args.putParcelable(ARG_DISASTER, disaster)
            val fragment = DisasterDetailFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
