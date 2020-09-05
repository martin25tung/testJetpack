package com.example.testjetpack.viewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.testjetpack.R
import com.example.testjetpack.model.Person
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_first.*


/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return super.onCreateView(inflater, container, savedInstanceState)
        val view = layoutInflater.inflate(R.layout.fragment_first, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        button1.setOnClickListener {
            // 無參數單存轉換畫面
//            findNavController().navigate(R.id.action_firstFragment_to_blankFragment2)


            // 新的參數型態model 需要打包(Parcelable)或序列化(Seralizable)
            val person = Person(input_name.text.toString(), input_age.text.toString().toIntOrNull()?:0)
            // 包含參數的目的地傳遞
            val action =
                FirstFragmentDirections.actionFirstFragmentToBlankFragment2(person)
            findNavController().navigate(action)


        }

    }
}