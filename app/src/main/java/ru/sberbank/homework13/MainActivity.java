package ru.sberbank.homework13;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ru.sberbank.homework13.entity.Photo;
import ru.sberbank.homework13.net.ApiMapper;
import ru.sberbank.homework13.net.RetrofitHelper;
import ru.sberbank.homework13.recycler.ImageAdapter;

public class MainActivity extends AppCompatActivity {

    private ApiMapper apiMapper = new ApiMapper(new RetrofitHelper());
    private RecyclerView mRecyclerView;
    private ImageAdapter mImageAdapter;
    private LinearLayoutManager mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);
        initView();
        initRecyclerView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getRandomPhotos();
    }

    private void initRecyclerView() {
        mImageAdapter = new ImageAdapter();
        mRecyclerView.setAdapter(mImageAdapter);
        mManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mManager);
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recyclerView);

    }

    @SuppressLint("StaticFieldLeak")
    private void getRandomPhotos() {
        new AsyncTask<Void, List<Photo>, List<Photo>>() {

            @Override
            protected void onProgressUpdate(List<Photo>... values) {
                super.onProgressUpdate(values);
                mImageAdapter.setData(values[0]);
            }

            @Override
            protected List<Photo> doInBackground(Void... voids) {
                ArrayList<Photo> arrayList = new ArrayList<>();
                try {
                    Random random = new Random();
                    for (int i = 0; i < 15; i++) {
                        arrayList.add(new Photo(apiMapper.getPhotoUrl(), random.nextInt(3)));//грузим картинку одним из 4 способов
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return arrayList;
            }

            @Override
            protected void onPostExecute(List<Photo> photos) {
                super.onPostExecute(photos);
                mImageAdapter.setData(photos);
            }
        }.execute();
    }

}
