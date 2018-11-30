package com.lingtao.myretrofit;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;

public class InterceptorFactory {
    /**
     * 拦截器Interceptors * 使用addHeader()不会覆盖之前设置的header,若使用header()则会覆盖之前的header * * @return
     */
    public static Interceptor getRequestHeader() {
        Interceptor headerInterceptor = new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request.Builder builder = originalRequest.newBuilder();
                builder.addHeader("version", "1");
                builder.addHeader("time", System.currentTimeMillis() + "");
                Request.Builder requestBuilder = builder.method(originalRequest.method(), originalRequest.body());
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        };
        return headerInterceptor;
    }

    /**
     * 拦截器Interceptors * 统一的请求参数
     */
    private Interceptor commonParamsInterceptor() {
        Interceptor commonParams = new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request originRequest = chain.request();
                Request request;
                HttpUrl httpUrl = originRequest.url().newBuilder().addQueryParameter("paltform", "android").addQueryParameter("version", "1.0.0").build();
                request = originRequest.newBuilder().url(httpUrl).build();
                return chain.proceed(request);
            }
        };
        return commonParams;
    }

    /**
     * 拦截器Interceptors * 通过响应拦截器实现了从响应中获取服务器返回的time * * @return
     */
    public static Interceptor getResponseHeader() {
        Interceptor interceptor = new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                okhttp3.Response response = chain.proceed(chain.request());
                String timestamp = response.header("time");
                if (timestamp != null) {
                    //获取到响应header中的time
                }
                return response;
            }
        };
        return interceptor;
    }
}



