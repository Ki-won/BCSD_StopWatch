package com.example.calculator

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import java.text.FieldPosition

class ListFragment : Fragment() {
    private lateinit var listAdapter: RecyclerViewListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, null)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listAdapter = RecyclerViewListAdapter()
        val getDlg: AlertDialog.Builder = AlertDialog.Builder(
            requireContext(),
            android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar_MinWidth
        )

        listAdapter.setRecyclerViewClickListener(object : RecyclerViewItemClickListener {
            override fun onRecyclerViewItemClicked(view: View, position: Int) {
                val getDig: AlertDialog.Builder = AlertDialog.Builder(
                    requireContext(),
                    android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar_MinWidth
                )
                getDlg.setTitle("다이얼로그활성화")
                getDlg.setMessage("리스트 삭제")
                getDlg.setPositiveButton("삭제", DialogInterface.OnClickListener { dialog, which ->
                    listAdapter.deleteListItem(position)
                })

                getDlg.setNegativeButton("취소", DialogInterface.OnClickListener { dialog, which ->
                    Toast.makeText(
                        requireContext().applicationContext,
                        "취소되었습니다.",
                        Toast.LENGTH_SHORT
                    ).show()
                })
                getDlg.show()
            }


            override fun onRecyclerViewItemLongClicked(view: View, position: Int) {
                val makeDig: AlertDialog.Builder = AlertDialog.Builder(
                    requireContext(),
                    android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar_MinWidth
                )
                val view = LayoutInflater.from(requireContext()).inflate(R.layout.custom_dialog_gettext, null)
                makeDig.setView(view)
                makeDig.setTitle("Input Text")
                makeDig.setMessage("입력받을 텍스트를 적으시요")

                makeDig.setPositiveButton("확인", DialogInterface.OnClickListener { dialog, which ->
                    val getText = view.findViewById<EditText>(R.id.editText)
                    listAdapter.addListItem(position,getText.toString())
                })

                makeDig.setNegativeButton("취소", DialogInterface.OnClickListener { dialog, which ->
                    val nothing = null
                })
                makeDig.show()

            }
        })


    }
}