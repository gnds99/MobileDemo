package com.example.mobiledemo.ui

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.example.mobiledemo.core.Options
import com.example.mobiledemo.core.RetrofitHelper.getRetrofi
import com.example.mobiledemo.databinding.FragmentLoginBinding
import com.example.mobiledemo.databinding.NewPostDialogBinding
import com.example.mobiledemo.ui.viewModel.AppViewModel

class NewPostDialogFragment(): DialogFragment() {

    //private var _binding: NewPostDialogBinding? = null
    //private val binding get() = _binding!!
    private val sharedVieModel: AppViewModel by activityViewModels()

    private lateinit var  binding: NewPostDialogBinding
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = NewPostDialogBinding.inflate(LayoutInflater.from(context))
        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(binding.root)

        binding.btnPost.setOnClickListener {
           //Toast.makeText(context, "Haz hecho click", Toast.LENGTH_SHORT).show()
            sharedVieModel.StarNewPost(binding.serverTittle.editText?.text.toString(), binding.serverInfo.editText?.text.toString())
            this.showMessage("PUBLICADO")
            dismiss()
        }

        val dialog = builder.create()
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return dialog
    }

    // METODO QUE MUESTRA UN MENSAJE POR PANTALLA
    private fun showMessage(mensaje: String)
    {
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show()
    }

}


/*override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
    binding = NewPostDialogBinding.inflate(LayoutInflater.from(context))
    val builder = AlertDialog.Builder(requireActivity())
    builder.setView(binding.root)

    binding.btnPost.setOnClickListener {
        Toast.makeText(context, "Haz hecho click", Toast.LENGTH_LONG)
        dismiss()
    }

    val dialog = builder.create()
    dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    return dialog
}*/

/*
*
*     override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = NewPostDialogBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        binding.btnPost.setOnClickListener{
            Toast.makeText(context, "Haz hecho click", Toast.LENGTH_LONG).show()
            dismiss()
        }
        return binding.root
    }
*
* */