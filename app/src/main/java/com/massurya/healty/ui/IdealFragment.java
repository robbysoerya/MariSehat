package com.massurya.healty.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import buildup.ds.Datasource;
import buildup.ds.SearchOptions;
import buildup.ds.SearchOptions.Builder;
import buildup.ui.DetailFragment;

import com.massurya.healty.R;
import com.massurya.healty.ds.EmptyDatasource;
import com.massurya.healty.ds.Item;

public class IdealFragment
        extends DetailFragment<Item>
{
    private EditText berat;
    private Button btnHitung;
    private Datasource<Item> datasource;
    private RadioButton female;
    private ImageView happy;
    private TextView hasil;
    private RadioButton male;
    private ImageView sad;
    private SearchOptions searchOptions;
    private EditText tinggi;
    View _fragment;

    public static IdealFragment newInstance(Bundle paramBundle)
    {
        IdealFragment localIdealFragment = new IdealFragment();
        localIdealFragment.setArguments(paramBundle);
        return localIdealFragment;
    }

    @SuppressLint({"WrongViewCast"})
    public void bindView(Item paramItem, View paramView) {}

    protected int getLayout()
    {
        return R.layout.ideal_custom;


    }

    public void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        this.searchOptions = SearchOptions.Builder.searchOptions().build();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.ideal_custom, container, false);
        btnHitung = (Button) view.findViewById(R.id.hitungideal);
        berat = (EditText) view.findViewById(R.id.berat);
        tinggi = (EditText) view.findViewById(R.id.tinggi);
        hasil = (TextView) view.findViewById(R.id.hasil);
        happy = (ImageView) view.findViewById(R.id.smile);
        sad = (ImageView) view.findViewById(R.id.sad);
        male = (RadioButton) view.findViewById(R.id.male);
        female = (RadioButton) view.findViewById(R.id.female);
        btnHitung.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                    try {
                        int Berat = Integer.valueOf(berat.getText().toString());
                        double Tinggi = Double.valueOf(tinggi.getText().toString()) / 100;
                        double Ideal = Berat / (Tinggi * Tinggi);
                        if ((!male.isChecked()) && (!female.isChecked())) {
                            Toast.makeText(IdealFragment.this.getActivity(), "Harus diisi semua", Toast.LENGTH_SHORT).show();
                        }

                        if (male.isChecked()) {

                            if ((Ideal <= 17) || (Ideal >= 23)) {
                                hasil.setText("Tidak Ideal");
                                sad.setVisibility(View.VISIBLE);
                                happy.setVisibility(View.INVISIBLE);
                            } else if ((Ideal >= 17) || (Ideal <= 23)) {
                                hasil.setText("Ideal");
                                sad.setVisibility(View.INVISIBLE);
                                happy.setVisibility(View.VISIBLE);
                            }
                        } else if (female.isChecked()) {

                            if ((Ideal <= 18) || (Ideal >= 25)) {
                                hasil.setText("Tidak Ideal");
                                sad.setVisibility(View.VISIBLE);
                                happy.setVisibility(View.INVISIBLE);
                            }else if ((Ideal >= 18) || (Ideal <= 25)) {
                                hasil.setText("Ideal");
                                sad.setVisibility(View.INVISIBLE);
                                happy.setVisibility(View.VISIBLE);
                            }
                        }
                    }
                    catch (NumberFormatException e)
                    {

                        Toast.makeText(IdealFragment.this.getActivity(), "Periksa kembali inputan", Toast.LENGTH_SHORT).show();
                }
            }
        });
        this.male.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton RadioButton, boolean isChecked) {

                if (male.isChecked()) {

                    female.setChecked(false);
                }
            }
        });
        this.female.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton RadioButton, boolean isChecked) {
                if (female.isChecked()) {
                    male.setChecked(false);
                }
            }
        });
        return view;
    }

    @Override
    public Datasource getDatasource() {
        if (datasource != null) {
            return datasource;
        }
        datasource = EmptyDatasource.getInstance(searchOptions);
        return datasource;
    }

    protected void onShow(Item paramItem)
    {
        getActivity().setTitle("Ideal");
    }
}


/* Location:              /home/robbysoerya/Documents/dex2jar-2.1-SNAPSHOT/classes-dex2jar.jar!/com/massurya/healty/ui/IdealFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */