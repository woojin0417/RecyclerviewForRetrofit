package com.woojin0417.retrofit.controller;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.woojin0417.retrofit.adapter.ItemAdapter;
import com.woojin0417.retrofit.R;
import com.woojin0417.retrofit.api.Client;
import com.woojin0417.retrofit.api.Service;
import com.woojin0417.retrofit.model.Item;
import com.woojin0417.retrofit.model.ItemResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Item item;
    //private ItemResponse itemResponse;
   // private ItemAdapter mAdapter;
    ProgressDialog pd;
    private SwipeRefreshLayout swipeContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("Error","why?11234");
        initViews();
        swipeContainer=(SwipeRefreshLayout)findViewById(R.id.swipeContainer);
        swipeContainer.setColorSchemeResources(android.R.color.holo_orange_dark);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh() {
                loadJSON();
                Toast.makeText(MainActivity.this,"가져오는 중 ",Toast.LENGTH_SHORT).show();

            }
        });

    }
    private void initViews(){
        pd= new ProgressDialog(this);
        pd.setMessage("읽어 오는중 ...");
        pd.setCancelable(false);
        pd.show();
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
       // mAdapter=new ItemAdapter(this, new ArrayList<Appcase>(0));
        //RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        //recyclerView.setLayoutManager(layoutManager);
        //recyclerView.setAdapter(mAdapter);
        recyclerView.smoothScrollToPosition(0);
        loadJSON();
        Log.v("Error","why?2468");
    }
    private void loadJSON(){
        try{
            Client Client=new Client();
            Service apiService= Client.getClient().create(Service.class);
            Call<ItemResponse> call=apiService.getItems();
            call.enqueue(new Callback<ItemResponse>() {
                @Override
                public void onResponse(Call<ItemResponse> call, Response<ItemResponse> response) {
//                    List<Appcase> items= response.body().getItems();
                    Log.v("Error","why?379");
                    List<Item> items=response.body().getItems();
                    recyclerView.setAdapter(new ItemAdapter(getApplicationContext(),items));
                  /*  if(response.isSuccessful()) {
                        Log.v("Error","why?");
                        mAdapter.updateAnswers(response.body().getAppcases());
                        Log.v("Error","why?11");
*/
                        recyclerView.smoothScrollToPosition(0);
                        swipeContainer.setRefreshing(false);
                        pd.hide();
                    //Log.v("Error","why?cival");

                }

                @Override
                public void onFailure(Call<ItemResponse> call, Throwable t) {
                    Log.d("Error",t.getMessage());
                    Toast.makeText(MainActivity.this,"Error Fetching Data",Toast.LENGTH_SHORT).show();
                    pd.hide();
                }
            });
        }catch (Exception e){
            Log.d("Eroor",e.getMessage());
            Toast.makeText(this,e.toString(),Toast.LENGTH_SHORT).show();
        }

    }
}
