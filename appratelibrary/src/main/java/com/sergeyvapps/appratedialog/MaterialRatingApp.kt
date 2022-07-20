package com.sergeyvapps.appratedialog

import android.app.Dialog
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.RatingBar.*
import android.widget.TextView
import androidx.annotation.Keep
import androidx.core.content.ContextCompat
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MaterialRatingApp :
    BottomSheetDialogFragment {

    private var defaultStars: Boolean = true
    private var sharedPreferencesString: String? = null

    constructor(defaultStars: Boolean, sharedPreferencesString: String?) {
        this.defaultStars = defaultStars
        this.sharedPreferencesString = sharedPreferencesString
    }

    constructor(sharedPreferencesString: String?) {
        this.sharedPreferencesString = sharedPreferencesString
    }


    @Keep
    constructor() {
    }


    private var ratingBar: RatingBar? = null
    private var rate_emoji: ImageView? = null
    private var star_plus_sparkles: ImageView? = null
    private var star_plus_arrow: ImageView? = null
    private var rate_result_title: TextView? = null
    private var lib_rate_button: TextView? = null
    private var star_plus_text: TextView? = null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return super.onCreateDialog(savedInstanceState) as BottomSheetDialog
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.lib_rate_dialog_rating_app, container, false)
        rate_result_title = v.findViewById(R.id.rate_result_title)
        lib_rate_button = v.findViewById(R.id.lib_rate_button)

        ratingBar = v.findViewById(R.id.rtb)
        if (!defaultStars) {
            ratingBar?.visibility = INVISIBLE
            ratingBar = v.findViewById(R.id.rtb_with_bulb)
            ratingBar?.visibility = VISIBLE

        }

        rate_emoji = v.findViewById(R.id.rate_emoji)
        star_plus_sparkles = v.findViewById(R.id.star_plus_sparkles)
        star_plus_arrow = v.findViewById(R.id.star_plus_arrow)
        star_plus_text = v.findViewById(R.id.star_plus_text)
        star_plus_text?.text = getString(R.string.lib_rate_five_stars_tip, ":)")
        changeRating()
        onclick()
        return v
    }

    private fun changeRating() {
        ratingBar!!.onRatingBarChangeListener =
            OnRatingBarChangeListener { ratingBar: RatingBar, rating: Float, fromUser: Boolean ->
                when (ratingBar.rating.toString()) {
                    "1.0" -> {
                        lib_rate_button!!.text = getString(R.string.lib_rate_btn_go_market)
                        rate_emoji!!.setImageResource(R.drawable.face_1)
                        rate_result_title!!.text =
                            getString(R.string.lib_rate_five_stars_confirm_tip)
                        star_plus_sparkles!!.setImageResource(R.drawable.lib_rate_star_plus)
                        star_plus_arrow!!.setImageResource(R.drawable.lib_rate_star_here)

                        star_plus_text!!.setTextColor(
                            ContextCompat.getColor(
                                requireActivity(),
                                R.color.lib_rate_dialog_five_star_tip_color
                            )
                        )
                    }
                    "2.0" -> {
                        lib_rate_button!!.text = getString(R.string.lib_rate_btn_go_market)
                        rate_emoji!!.setImageResource(R.drawable.face_2)
                        rate_result_title!!.text =
                            getString(R.string.lib_rate_five_stars_confirm_tip)
                        star_plus_sparkles!!.setImageResource(R.drawable.lib_rate_star_plus)
                        star_plus_arrow!!.setImageResource(R.drawable.lib_rate_star_here)
                        star_plus_text!!.setTextColor(
                            ContextCompat.getColor(
                                requireActivity(),
                                R.color.lib_rate_dialog_five_star_tip_color
                            )
                        )
                    }
                    "3.0" -> {
                        lib_rate_button!!.text = getString(R.string.lib_rate_btn_go_market)
                        rate_emoji!!.setImageResource(R.drawable.face_3)
                        rate_result_title!!.text =
                            getString(R.string.lib_rate_five_stars_confirm_tip)
                        star_plus_sparkles!!.setImageResource(R.drawable.lib_rate_star_plus)
                        star_plus_arrow!!.setImageResource(R.drawable.lib_rate_star_here)
                        star_plus_text!!.setTextColor(
                            ContextCompat.getColor(
                                requireActivity(),
                                R.color.lib_rate_dialog_five_star_tip_color
                            )
                        )
                    }
                    "4.0" -> {
                        lib_rate_button!!.text = getString(R.string.lib_rate_btn_go_market)
                        rate_emoji!!.setImageResource(R.drawable.face_4)
                        rate_result_title!!.text = getString(R.string.lib_rate_like_you)
                        star_plus_sparkles!!.setImageResource(R.drawable.lib_rate_star_plus)
                        star_plus_arrow!!.setImageResource(R.drawable.lib_rate_star_here)
                        star_plus_text!!.setTextColor(
                            ContextCompat.getColor(
                                requireActivity(),
                                R.color.lib_rate_dialog_five_star_tip_color
                            )
                        )
                    }
                    "5.0" -> {
                        lib_rate_button!!.text = getString(R.string.lib_rate_btn_go_market)
                        rate_emoji!!.setImageResource(R.drawable.face_5)
                        rate_result_title!!.text = getString(R.string.lib_rate_like_you)
                        star_plus_sparkles!!.setImageResource(R.drawable.lib_rate_star_plus_orange)
                        star_plus_arrow!!.setImageResource(R.drawable.lib_rate_star_here_orange)
                        star_plus_text!!.setTextColor(
                            ContextCompat.getColor(
                                requireActivity(),
                                R.color.orange_plus_star
                            )
                        )
                    }
                    else -> {
                        lib_rate_button!!.text = getString(R.string.lib_rate_btn_go_market)
                        rate_emoji!!.setImageResource(R.drawable.face_0)
                        rate_result_title!!.text =
                            getString(R.string.lib_rate_five_stars_confirm_tip)
                        star_plus_sparkles!!.setImageResource(R.drawable.lib_rate_star_plus)
                        star_plus_arrow!!.setImageResource(R.drawable.lib_rate_star_here)
                        star_plus_text!!.setTextColor(
                            ContextCompat.getColor(
                                requireActivity(),
                                R.color.lib_rate_dialog_five_star_tip_color
                            )
                        )
                    }
                }
            }
    }

    private fun onclick() {
        lib_rate_button!!.setOnClickListener { view: View? ->
            val packageName = activity?.packageName
            val prefs = activity?.getSharedPreferences(sharedPreferencesString, Context.MODE_PRIVATE)
            val editor = prefs?.edit()
            editor?.putBoolean("is_rated", true)?.apply()
            var it: Intent
            try {
                it = Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName"))
                startActivity(it)
            } catch (anfe: ActivityNotFoundException) {
                it = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=$packageName")
                )
                startActivity(it)
            }
            dismiss()
        }
    }
}