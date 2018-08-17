package be.evoliris.formation.demo_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import be.evoliris.formation.demo_fragment.models.Product;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductListFragment extends Fragment {

    private ListView lvProduct;
    private TextView tvNbElement;

    private ArrayList<Product> products;

    public ProductListFragment() {
        // Required empty public constructor
        products = new ArrayList<>();
    }


    //region Singleton
    private static ProductListFragment instance;

    public static ProductListFragment getInstance() {

        if(instance == null) {
            instance = new ProductListFragment();
        }

        return instance;
    }
    //endregion


    //region Callback (Systeme d'event)
    public interface MyEventFrag {
        void onInteraction(Product product);
    }

    private MyEventFrag callback;

    public void setCallback(MyEventFrag callback) {
        this.callback = callback;
    }
    //endregion


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewFrag = inflater.inflate(R.layout.fragment_product_list, container, false);

        tvNbElement = viewFrag.findViewById(R.id.tv_frag_list_number);
        tvNbElement.setText(String.format("%d", products.size()));

        lvProduct = viewFrag.findViewById(R.id.lv_frag_list_products);
        ArrayAdapter<Product> adapter = new ArrayAdapter<>(
                getContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                products
        );

        lvProduct.setAdapter(adapter);
        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product product = (Product) parent.getItemAtPosition(position);

                //Transmettre l'objet a l'activité => Utilisation le Callback
                if (callback != null) {
                    callback.onInteraction(product);
                }
            }
        });

        return viewFrag;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = (ArrayList<Product>) products.clone();
    }



}
