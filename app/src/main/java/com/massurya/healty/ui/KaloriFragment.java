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

public class KaloriFragment extends buildup.ui.DetailFragment<Item>
{
    private EditText berat;
    private Button btnHitung;
    private Datasource<Item> datasource;
    private RadioButton female;
    private TextView hasil;
    private RadioButton male;
    private SearchOptions searchOptions;
    private EditText tinggi;
    private EditText umur;

    public static KaloriFragment newInstance(Bundle args)
    {
        KaloriFragment card = new KaloriFragment();
        card.setArguments(args);
        return card;
    }

    public KaloriFragment   (){
        super();
    }

    @SuppressLint({"WrongViewCast"})
    public void bindView(final Item item, View view) {

    }

    protected int getLayout()
    {
        return R.layout.kalori_custom;

    }

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.searchOptions = SearchOptions.Builder.searchOptions().build();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.kalori_custom, container, false);
        btnHitung = (Button) view.findViewById(R.id.hitungkalori);
        berat = (EditText) view.findViewById(R.id.berat);
        tinggi = (EditText) view.findViewById(R.id.tinggi);
        umur = (EditText) view.findViewById(R.id.umur);
        hasil = (TextView) view.findViewById(R.id.hasil);
        male = (RadioButton) view.findViewById(R.id.male);
        female = (RadioButton) view.findViewById(R.id.female);
        btnHitung.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                {
                    try
                    {
                        int Tinggi = Integer.valueOf(tinggi.getText().toString());
                        int Umur = Integer.valueOf(umur.getText().toString());
                        double Berat = Double.valueOf(berat.getText().toString());
                        if ((!male.isChecked()) && (!female.isChecked())) {
                            Toast.makeText(KaloriFragment.this.getActivity(), "Harus diisi semua", Toast.LENGTH_SHORT).show();
                        }
                        if (male.isChecked())
                        {
                            double kalori = 88.362 + (13.397 * Berat) + (4.799 * Tinggi) - (5.677 * Umur);
                            hasil.setText(String.format("%.2f", kalori ));
                            return;

                        }else if(female.isChecked())
                        {
                            double kalori = 447.593 + (9.247 * Berat) + (3.098 * Tinggi) - (4.33 * Umur);
                            hasil.setText(String.format("%.2f", kalori ));
                        }
                    }
                    catch (NumberFormatException e)
                    {
                        Toast.makeText(KaloriFragment.this.getActivity(), "Periksa kembali inputan", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        this.male.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton RadioButton, boolean isChecked)
            {
                female.setChecked(false);
            }
        });
        this.female.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton RadioButton, boolean isChecked)
            {
                male.setChecked(false);
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
    protected void onShow(Item item)
    {
        getActivity().setTitle("Kalori");
    }
}