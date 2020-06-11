package com.yuan.fest.latte.net.interceptors;

import java.util.LinkedHashMap;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;

public abstract class BaseInterceptor implements Interceptor {

    protected Map<String,String> getUrlParameters(Chain chain){
        final HttpUrl url = chain.request().url();
        int size = url.querySize();
        final Map<String,String> params = new LinkedHashMap<>();
        for (int i = 0; i < size; i++) {
            params.put(url.queryParameterName(i),url.queryParameterValue(i));
        }
        return params;
    }

    protected String getUrlParameters(Chain chain,String key){
        return chain.request().url().queryParameter(key);
    }

    protected Map<String,String> getBodyParameters(Chain chain) {
        final FormBody formBody = (FormBody) chain.request().body();
        final Map<String,String> params = new LinkedHashMap<>();
        int size = formBody.size();
        for (int i = 0; i < size; i++) {
            params.put(formBody.name(i),formBody.value(i));
        }
        return params;
    }

    protected String getBodyParameters(Chain chain,String key) {
        return getBodyParameters(chain).get(key);
    }

}
