package com.ottogroup.nhcc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentB.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentB : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, null).apply {
            findViewById<ComposeView>(R.id.compose_view).apply {
                setContent {
                    Button(
                        onClick = {
                            val args = SomeSealedInterface.A("Hello World", 42)
                            findNavController().navigate(R.id.fragmentA, args.toBundle())
                        }
                    ) {
                        Text("Click to navigate")
                    }
                }
            }
        }
    }
}
