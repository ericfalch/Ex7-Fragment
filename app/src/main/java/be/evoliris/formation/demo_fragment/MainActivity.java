package be.evoliris.formation.demo_fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

import java.util.ArrayList;

import be.evoliris.formation.demo_fragment.models.Product;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Fake load database
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Pomme", "Fruit", R.drawable.img_pomme));
        products.add(new Product(2, "Poire", "Fruit", R.drawable.img_poire));
        products.add(new Product(3, "Dragon", "Animal", R.drawable.img_dragon));
        products.add(new Product(4, "Couscous", "Repas", R.drawable.img_couscous));
        products.add(new Product(5, "Lama", "Animal", R.drawable.img_lama));
        products.add(new Product(6, "Marsupilami", "Animal", R.drawable.img_marsupilami));
        products.add(new Product(7, "Messi", "Humain", R.drawable.img_messi));
        products.add(new Product(8, "Picsou", "Canard", R.drawable.img_picsou));
        products.add(new Product(9, "Risitas", "Humain", R.drawable.img_risitas));


        //Ajouter le fragment

        // - Creation du fragement (Utilisation Singleton)
        ProductListFragment fragment = ProductListFragment.getInstance();
        fragment.setProducts(products);
        fragment.setCallback(new ProductListFragment.MyEventFrag() {
            @Override
            public void onInteraction(Product product) {
                onClickElement(product);
            }
        });

        // - Recup le gestionnaire de Fragement
        FragmentManager fm = getSupportFragmentManager();

        // - Debut un serie d'operation (Transaction)
        FragmentTransaction transaction = fm.beginTransaction();

        // - Action d'ajout de Fragment
        transaction.add(R.id.zone_frag, fragment);
        transaction.commit();
    }


    private void onClickElement(Product product) {
        //Creation Fragment
        ProductInfoFragment fragInfo = ProductInfoFragment.getInstance();
        fragInfo.setProduct(product);

        //Recup le manager
        FragmentManager fragmentManager = getSupportFragmentManager();

        //Creer les operations a faire => transaction
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        //On remplace le frag actuel par un nouveau
        transaction.replace(R.id.zone_frag, fragInfo);

        //On ajoute à la pile d'action "retour" d'android
        transaction.addToBackStack(null);

        //on valide la transaction
        transaction.commit();
    }

}
