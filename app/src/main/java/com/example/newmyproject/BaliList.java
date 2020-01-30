package com.example.newmyproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class BaliList extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AreaAdapter areaAdapter;
    private List<Area> areaList;
    private GridLayoutManager gridLayoutManager;
    private TextView txtName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bali_list);

        recyclerView = (RecyclerView) findViewById(R.id.bali_recycler);
        areaList= new ArrayList<>();
        load_data_from_server(0);

        gridLayoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(gridLayoutManager);

        areaAdapter = new AreaAdapter(this,areaList);
        recyclerView.setAdapter(areaAdapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

                if(gridLayoutManager.findLastCompletelyVisibleItemPosition() == areaList.size()-1){
                    load_data_from_server(areaList.get(areaList.size()-1).getId());
                }

            }
        });

        Bundle extras = getIntent().getExtras();
        String Value = extras.getSerializable("id").toString();

    }

    private void load_data_from_server(final int id) {
        AsyncTask<Integer, Void, Void> task = new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... integers) {

                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("http://192.168.1.123/MobileAppTes3/bali.php?id=" + id)
                        .build();
                try {
                    Response response = client.newCall(request).execute();

                    JSONArray array = new JSONArray(response.body().string());

                    for (int i = 0; i < array.length(); i++) {

                        JSONObject object = array.getJSONObject(i);

                        Area data = new Area(object.getInt("id"), object.getString("bali_kota_name"),
                                object.getString("bali_kota_info"),
                                object.getString("bali_kota_image"));

                        areaList.add(data);
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    System.out.println("End of content");
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid)

            {
                areaAdapter.notifyDataSetChanged();
            }
        };

        task.execute(id);
    }
}
