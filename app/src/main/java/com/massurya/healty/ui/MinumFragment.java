package com.massurya.healty.ui;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
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

import static android.content.Context.ALARM_SERVICE;

public class MinumFragment extends buildup.ui.DetailFragment<Item>
{
    View _fragment;
    private EditText berat;
    private Button btnHitung;
    private Button btnIngat;
    private TextView hasil;
    private RadioButton one;
    PendingIntent pendingIntent;
    private RadioButton three;
    private RadioButton two;
    private Datasource<Item> datasource;
    private SearchOptions searchOptions;

    public static MinumFragment newInstance(Bundle args)
    {
        MinumFragment card = new MinumFragment();
        card.setArguments(args);
        return card;
    }

    public MinumFragment(){
        super();
    }

    public void SetupView(View fragment)
    {
        btnHitung = (Button) _fragment.findViewById(R.id.hitungminum);
        btnIngat = (Button) _fragment.findViewById(R.id.btnIngat);
        berat = (EditText) _fragment.findViewById(R.id.berat);
        hasil = (TextView) _fragment.findViewById(R.id.hasil);
        one = (RadioButton) _fragment.findViewById(R.id.one);
        two = (RadioButton) _fragment.findViewById(R.id.two);
        three = (RadioButton) _fragment.findViewById(R.id.three);
        Intent alarmintent = new Intent(getActivity().getApplicationContext(), AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(getActivity(), 0, alarmintent, 0);
        btnHitung.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                try
                {
                    int i = Integer.valueOf(berat.getText().toString());
                    hasil.setText(i * 30 + " ml");
                }
                catch (NumberFormatException e)
                {
                        Toast.makeText(MinumFragment.this.getActivity(), "Periksa kembali inputan", Toast.LENGTH_LONG).show();
                }
            }
        });
        this.btnIngat.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                try
                {
                    if (one.isChecked()) {
                        startAlert(3600000);
                        Toast.makeText(MinumFragment.this.getActivity(), "Set pengingat dalam waktu 1 jam diaktifkan", Toast.LENGTH_LONG).show();
                    }else if (two.isChecked()) {
                        startAlert(7200000);
                        Toast.makeText(MinumFragment.this.getActivity(), "Set pengingat dalam waktu 2 jam diaktifkan", Toast.LENGTH_LONG).show();
                    }else if (three.isChecked())
                    {
                        startAlert(10900000);
                        Toast.makeText(MinumFragment.this.getActivity(), "Set pengingat dalam waktu 3 jam diaktifkan", Toast.LENGTH_LONG).show();
                    }
                }
                catch (NumberFormatException e)
                    {
                        Toast.makeText(MinumFragment.this.getActivity(), "Periksa kembali inputan", Toast.LENGTH_LONG).show();

                    }
                }
        });
        this.one.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton RadioButton, boolean isChecked)
            {
                    two.setChecked(false);
                    three.setChecked(false);
            }
        });
        this.two.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton RadioButton, boolean isChecked)
            {
                one.setChecked(false);
                three.setChecked(false);
            }
        });
        this.three.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton RadioButton, boolean isChecked)
            {
                two.setChecked(false);
                one.setChecked(false);
            }
        });
    }

    @SuppressLint({"WrongViewCast"})
    public void bindView(final Item item, View view) {}

    protected int getLayout()
    {
        return R.layout.minum_custom;
    }

    @Override
    public Datasource getDatasource() {
        if (datasource != null) {
            return datasource;
        }
        datasource = EmptyDatasource.getInstance(searchOptions);
        return datasource;
    }

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        searchOptions = SearchOptions.Builder.searchOptions().build();
    }

    public View onCreateView(LayoutInflater Inflater, ViewGroup container, Bundle savedInstanceState)
    {
        _fragment = Inflater.inflate(R.layout.minum_custom, container, false);
        SetupView(_fragment);
        return _fragment;
    }

    protected void onShow(Item item)
    {
        getActivity().setTitle("Minum");
    }

    public void startAlert(int i)
    {
        Intent intent = new Intent(MinumFragment.this.getActivity(), AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this.getContext(), 234324243, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                + i, pendingIntent);
    }
}