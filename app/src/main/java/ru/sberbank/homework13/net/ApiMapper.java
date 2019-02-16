package ru.sberbank.homework13.net;

import java.io.IOException;

public class ApiMapper {
    private RetrofitHelper mHelper;

    public ApiMapper(RetrofitHelper helper) {
        mHelper = helper;
    }

    public String getPhotoUrl() throws IOException {
        return mHelper.getService().getImage(800, 800, "").execute().raw().request().url().toString();//у последнего параметра пустой параметр при запросе
    }
}
