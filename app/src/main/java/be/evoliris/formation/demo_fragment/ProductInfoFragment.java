package be.evoliris.formation.demo_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import be.evoliris.formation.demo_fragment.models.Product;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductInfoFragment extends Fragment {

    private TextView tvTitle, tvCategorie;
    private ImageView imgPicture;

    private Product product;

    public ProductInfoFragment() {
        // Required empty public constructor
    }


    //region Singleton
     private static ProductInfoFragment instance;

    public static ProductInfoFragment getInstance() {
        if(instance == null) {
            instance = new ProductInfoFragment();
        }

        return instance;
    }
    //endregion


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewFragment = inflater.inflate(R.layout.fragment_product_info, container, false);

        tvTitle = viewFragment.findViewById(R.id.tv_frag_info_title);
        tvCategorie = viewFragment.findViewById(R.id.tv_frag_info_categorie);
        imgPicture = viewFragment.findViewById(R.id.img_frag_info_picture);

        tvTitle.setText(product.getName());
        tvCategorie.setText(product.getCategory());
        imgPicture.setImageResource(product.getResImage());

        return  viewFragment;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
