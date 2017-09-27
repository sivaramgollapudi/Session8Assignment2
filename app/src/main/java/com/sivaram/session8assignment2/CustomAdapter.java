package com.sivaram.session8assignment2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by User on 20/09/2017.
 */

// Custom Class which extends from BaseAdapter class
// OVerride the required methods
public class CustomAdapter extends BaseAdapter {

    // Private Variables.
    private Context context;
    private List<Person> personList;

    //Constructor
    public CustomAdapter(Context context, List<Person> personList) {
        this.context = context;
        this.personList = personList;
    }

    @Override
    public int getCount() {
        return personList.size();
    }

    @Override
    public Object getItem(int position) {
        return personList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        // Create View Object with Inflating the Layout
        View customListView = View.inflate(context,R.layout.custom_listview_two_rows, null);

        // Find Name, Phone Number Text View From Inflated Layout
        TextView nameTextView = (TextView)customListView.findViewById(R.id.txtUserName);
        TextView phoneNumberTextView = (TextView)customListView.findViewById(R.id.txtPhoneNumber);

        // Set Text To Name And Phone Number TextView based on Contacts List Object and the Position where the
        // View Called from.
        nameTextView.setText(personList.get(position).getPersonName());
        phoneNumberTextView.setText(personList.get(position).getContactNumber());

        // Return Custom List View
        return customListView;
    }
}
