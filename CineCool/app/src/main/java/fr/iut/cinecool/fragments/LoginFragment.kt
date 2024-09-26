package fr.iut.cinecool.fragments

import android.content.Context.LOCATION_SERVICE
import android.location.LocationManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.core.content.ContextCompat.getSystemService
import androidx.navigation.fragment.findNavController
import fr.iut.cinecool.R
import fr.iut.cinecool.databinding.FragmentLoginBinding
import fr.iut.cinecool.databinding.FragmentMoviesBinding

class LoginFragment : Fragment() {
    private var locationManager : LocationManager? = null
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //locationManager = this.context?.let { getSystemService(it,LOCATION_SERVICE) } as LocationManager?

        super.onViewCreated(view, savedInstanceState)
        val loginButton = view.findViewById<ImageView>(R.id.loginButton)
        loginButton.setOnClickListener(){
            login()
        }
    }
    fun login(){
        val name = view?.findViewById<EditText>(R.id.name)?.text
        if (name != null) {
            findNavController().navigate(R.id.login_to_movies)
        }
    }
}