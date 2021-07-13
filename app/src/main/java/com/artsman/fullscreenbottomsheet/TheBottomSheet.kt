package com.artsman.fullscreenbottomsheet

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.artsman.fullscreenbottomsheet.databinding.LayoutDialogBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class BottomSheet : BottomSheetDialogFragment() {
    lateinit var bottomSheetBehavior: BottomSheetBehavior<FrameLayout>
    lateinit var bi: LayoutDialogBinding



    private fun getWindowHeight() = resources.displayMetrics.heightPixels

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bi=LayoutDialogBinding.inflate(layoutInflater)
        bi.btnClose.setOnClickListener {
            dialog?.cancel()
        }
        return bi.root
    }

    override fun onStart() {
        super.onStart()
        //Get the bottom_sheet of the system
        val view: FrameLayout = dialog?.findViewById(R.id.design_bottom_sheet)!!
        //Set the view height
        view.layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
        //Get behavior
        val behavior = BottomSheetBehavior.from(view)
        //Set the pop-up height
        behavior.peekHeight = getWindowHeight()
        //Set the expanded state
        behavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

}