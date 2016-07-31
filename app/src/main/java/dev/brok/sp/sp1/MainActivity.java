package dev.brok.sp.sp1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dev.brok.sp.sp1.adapter.TheraterAdapter;
import dev.brok.sp.sp1.model.TheraterModel;

public class MainActivity extends AppCompatActivity implements TheraterAdapter.TheraterItemClicketListenter {

    TheraterAdapter mAdapter;
    List<TheraterModel> theraterModelList=new ArrayList<>();
    RecyclerView mRecycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mRecycler=(RecyclerView)findViewById(R.id.recycler);
        LinearLayoutManager lm=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);;
        mRecycler.setLayoutManager(lm);
        mRecycler.setHasFixedSize(true);
        mAdapter=new TheraterAdapter(getApplicationContext(),theraterModelList,this);
        mRecycler.setAdapter(mAdapter);


        theraterModelList.clear();
        defaultData();


    }






    private void defaultData() {
        int[] defaultImg = new int[]{
                R.drawable.default1,
                R.drawable.default2,
                R.drawable.default3,
                R.drawable.default4,
                R.drawable.default5,
                R.drawable.default6,
                R.drawable.default7,
                R.drawable.default8,
                R.drawable.default9,
                R.drawable.default10
        };

        TheraterModel dummy1 = new TheraterModel(1,"AAA","Love is the game","09796621319",defaultImg[0]);
        theraterModelList.add(dummy1);

        TheraterModel dumm2=new TheraterModel(2,"MyaSanDar","Oak kyar myat aklfsdlkfjskik","09796621319",defaultImg[1]);
        theraterModelList.add(dumm2);

        TheraterModel dummy3 = new TheraterModel(3,"Shwe Nagar","Nagar Is a dragon ... balalala","09796621319",defaultImg[2]);
        theraterModelList.add(dummy3);

        TheraterModel dumm4=new TheraterModel(3,"MyaSanDar","Oak kyar myat aklfsdlkfjskik","09796621319",defaultImg[3]);
        theraterModelList.add(dumm4);

        TheraterModel dummy5 = new TheraterModel(1,"AAA","Love is the game","09796621319",defaultImg[4]);
        theraterModelList.add(dummy5);

        TheraterModel dumm6=new TheraterModel(2,"MyaSanDar","Oak kyar myat aklfsdlkfjskik","09796621319",defaultImg[5]);
        theraterModelList.add(dumm6);

        TheraterModel dummy7 = new TheraterModel(3,"Shwe Nagar","Nagar Is a dragon ... balalala","09796621319",defaultImg[6]);
        theraterModelList.add(dummy7);

        TheraterModel dumm8=new TheraterModel(3,"MyaSanDar","Oak kyar myat aklfsdlkfjskik","09796621319",defaultImg[7]);
        theraterModelList.add(dumm8);

        mAdapter.notifyDataSetChanged();


    }

    @Override
    public void OnItemClick(TheraterModel theraterModel) {
        Bundle args=new Bundle();
        args.putInt("id",theraterModel.getId());
        args.putString("name",theraterModel.getName());
        args.putString("phone",theraterModel.getPhone());
        args.putString("des",theraterModel.getDescription());
        args.putInt("img",theraterModel.getImg());

        Intent intent=new Intent(MainActivity.this,Detail.class);
        intent.putExtras(args);
        startActivity(intent);
    }
}
