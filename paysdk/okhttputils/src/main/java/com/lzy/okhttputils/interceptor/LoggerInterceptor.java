package com.lzy.okhttputils.interceptor;

import android.text.TextUtils;
import android.util.Log;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

public class LoggerInterceptor implements Interceptor {
    public static final String TAG = "OkHttpUtils";
    private String tag;
    private boolean showResponse;

    public LoggerInterceptor(String tag) {
        this(tag, false);
    }

    public LoggerInterceptor(String tag, boolean showResponse) {
        if (TextUtils.isEmpty(tag)) {
            tag = TAG;
        }
        this.showResponse = showResponse;
        this.tag = tag;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        logForRequest(request);
        Response response = chain.proceed(request);

        return logForResponse(response);
    }

    private void logForRequest(Request request) {
        try {
            String url = request.url().toString();
            Headers headers = request.headers();

            Log.d(tag, "---------------------request log start---------------------");
            Log.d(tag, "method : " + request.method());
            Log.d(tag, "url : " + url);

            RequestBody requestBody = request.body();
            if (requestBody != null) {
                MediaType mediaType = requestBody.contentType();
                if (mediaType != null) {
                    if (isText(mediaType)) {
                        Log.d(tag, "params : " + bodyToString(request));
                    } else {
                        Log.d(tag, "params : " + " maybe [file part] , too large too print , ignored!");
                    }
                    Log.d(tag, "contentType : " + mediaType.toString());
                }
            }
            if (headers != null && headers.size() > 0) {
                Log.d(tag, "headers : \n");
                Log.d(tag, headers.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Log.d(tag, "---------------------request log end-----------------------");
        }
    }

    private Response logForResponse(Response response) {
        try {
            Log.d(tag, "---------------------response log start---------------------");
            Response.Builder builder = response.newBuilder();
            Response clone = builder.build();
            Log.d(tag, "url : " + clone.request().url());
            RequestBody requestBody = clone.request().body();
            if (requestBody != null) {
                MediaType mediaType = requestBody.contentType();
                if (mediaType != null) {
                    if (isText(mediaType)) {
                        Log.d(tag, "params : " + bodyToString(clone.request()));
                    } else {
                        Log.d(tag, "params : " + " maybe [file part] , too large too print , ignored!");
                    }
                }
            }
            Log.d(tag, "code : " + clone.code() + "，protocol : " + clone.protocol() + "，message : " + clone.message());

            if (showResponse) {
                ResponseBody body = clone.body();
                if (body != null) {
                    MediaType mediaType = body.contentType();
                    if (mediaType != null) {
                        Log.d(tag, "contentType : " + mediaType.toString());
                        if (isText(mediaType)) {
                            String resp = body.string();
                            Log.d(tag, "content : " + resp);
                            body = ResponseBody.create(mediaType, resp);
                            return response.newBuilder().body(body).build();
                        } else {
                            Log.d(tag, "content : " + " maybe [file part] , too large too print , ignored!");
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Log.d(tag, "---------------------response log end-----------------------");
        }

        return response;
    }

    private boolean isText(MediaType mediaType) {
        if (mediaType.type() != null && mediaType.type().equals("text")) {
            return true;
        }
        if (mediaType.type() != null && mediaType.subtype().equals("x-www-form-urlencoded")) {
            return true;
        }
        if (mediaType.subtype() != null) {
            if (mediaType.subtype().equals("json") ||
                    mediaType.subtype().equals("xml") ||
                    mediaType.subtype().equals("html") ||
                    mediaType.subtype().equals("webviewhtml"))
                return true;
        }
        return false;
    }

    private String bodyToString(final Request request) {
        try {
            final Request copy = request.newBuilder().build();
            final Buffer buffer = new Buffer();
            copy.body().writeTo(buffer);
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "something error when show requestBody.";
        }
    }
}
