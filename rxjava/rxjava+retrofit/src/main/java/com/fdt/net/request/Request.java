package com.fdt.net.request;


import com.fdt.net.response.Response;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by fudetian on 2018/8/27.
 */

public interface Request {
    @POST("clerk/loginAccount/login")
    Observable<Response<com.fdt.net.User>> doLogin(@Body RequestBody route);

}
