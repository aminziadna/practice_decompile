package ru.gg.scooby.ui.address;

import android.content.Context;
import android.location.Address;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;
import ru.skooby.R;

public class AddressesAdapter extends ArrayAdapter<Address> {
    private int resource;

    /* renamed from: ru.gg.scooby.ui.address.AddressesAdapter$a */
    private static class C2673a {
        /* renamed from: a */
        public TextView f8291a;
        /* renamed from: b */
        public TextView f8292b;

        private C2673a() {
        }
    }

    public AddressesAdapter(Context context, int i, List<Address> list) {
        super(context, i, list);
        this.resource = i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(this.resource, viewGroup, false);
            viewGroup = new C2673a();
            viewGroup.f8291a = (TextView) view.findViewById(R.id.text_address_title);
            viewGroup.f8292b = (TextView) view.findViewById(R.id.text_address_subtitle);
            view.setTag(viewGroup);
        } else {
            viewGroup = (C2673a) view.getTag();
        }
        Address address = (Address) getItem(i);
        if (address != null) {
            viewGroup.f8291a.setText(address.getAddressLine(0));
            viewGroup.f8292b.setText(address.getLocality());
        }
        return view;
    }
}
