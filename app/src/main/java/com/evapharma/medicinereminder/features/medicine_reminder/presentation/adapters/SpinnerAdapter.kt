package com.evapharma.medicinereminder.features.medicine_reminder.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.evapharma.medicinereminder.R
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.SpinnerItem

class SpinnerAdapter(context: Context, spinnerItems: ArrayList<SpinnerItem>) :
    ArrayAdapter<SpinnerItem>(context, R.layout.spinner_item, spinnerItems) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    private fun initView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.spinner_item, parent, false)
        }

        val currentItem = getItem(position)

        val textView: TextView = view?.findViewById(R.id.item_name) ?: TextView(context)
        val imgView: ImageView = view?.findViewById(R.id.item_image) ?: ImageView(context)


        if (view != null) {
            textView.text = currentItem?.status?.apiName
            imgView.setImageResource(currentItem?.imgID ?: 0)

        }

        return view ?: TextView(context)
    }
}
