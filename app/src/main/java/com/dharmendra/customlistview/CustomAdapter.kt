package com.dharmendra.customlistview

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by root on 3/18/18.
 */

/*We Have Created Constructor of Custom Adapter and Pass
                context
                ArrayList<Int> which Contain images
                ArrayList<HashMap<String,String>> which contain name and version*/

//Here We extend over Adapter With BaseAdapter()

class CustomAdapter(context: Context, image: ArrayList<Int>, arrayList: ArrayList<HashMap<String, String>>) : BaseAdapter() {

    //Passing Values to Local Variables
    var image = image
    var arrayList = arrayList
    var context = context


    //Auto Generated Method
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var myview = convertView
        val holder: ViewHolder



        if (convertView == null) {

            //If Over View is Null than we Inflater view using Layout Inflater
            val mInflater = (context as Activity).layoutInflater

            //Inflating our list_row.
            myview = mInflater!!.inflate(R.layout.list_row, parent, false)

            //Create Object of ViewHolder Class and set our View to it
            holder = ViewHolder()

            //Find view By Id For all our Widget taken in list_row.

            /*Here !! are use for non-null asserted two prevent From null.
             you can also use Only Safe (?.)

            */
            holder.mImageView = myview!!.findViewById<ImageView>(R.id.imageview) as ImageView
            holder.mHeader = myview!!.findViewById<TextView>(R.id.header) as TextView
            holder.mSubHeader = myview!!.findViewById<TextView>(R.id.subHeader) as TextView

            //Set A Tag to Identify our view.
            myview.setTag(holder)
        } else {

            //If Ouer View in not Null than Just get View using Tag and pass to holder Object.
            holder = myview!!.getTag() as ViewHolder
        }

        //Getting HasaMap At Perticular Position
        val map = arrayList.get(position)

        //Setting Image to ImageView by position
        holder.mImageView!!.setImageResource(image[position])

        //Setting name to TextView it's Key from HashMap At Position
        holder.mHeader!!.setText(map.get("name"))

        //Setting version to TextView it's Key from HashMap At Position
        holder.mSubHeader!!.setText(map.get("version"))


        return myview

    }

    //Auto Generated Method
    override fun getItem(p0: Int): Any {

        //Return the Current Position of ArrayList.
        return arrayList.get(p0)

    }

    //Auto Generated Method
    override fun getItemId(p0: Int): Long {
        return 0
    }

    //Auto Generated Method

    override fun getCount(): Int {

        //Return Size Of ArrayList
        return arrayList.size
    }


    //Create A class To hold over View like we taken in list_row.xml
    class ViewHolder {

        var mImageView: ImageView? = null
        var mHeader: TextView? = null
        var mSubHeader: TextView? = null
    }
}