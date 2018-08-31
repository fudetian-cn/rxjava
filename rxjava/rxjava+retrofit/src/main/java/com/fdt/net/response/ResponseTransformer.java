package com.fdt.net.response;

import com.fdt.net.common.BaseBean;
import com.fdt.net.common.Head;
import com.fdt.net.common.NetConfig;
import com.fdt.net.exception.NetExceptionPrevider;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * 对返回的数据进行处理，区分异常的情况。
 */

public class ResponseTransformer {

    public static <T extends BaseBean> ObservableTransformer<Response<T>, T> handleResult() {
        return upstream -> upstream
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new ErrorResumeFunction<>())
                .flatMap(new ResponseFunction<>());
    }


    /**
     * 非服务器产生的异常，比如本地无无网络请求，Json数据解析错误等等。
     */
    private static class ErrorResumeFunction<T extends BaseBean> implements Function<Throwable, ObservableSource<? extends Response<T>>> {
        @Override
        public ObservableSource<? extends Response<T>> apply(Throwable throwable) throws Exception {
            return Observable.error(NetExceptionPrevider.handleException(throwable));
        }
    }

    /**
     * 服务其返回的数据解析
     * 正常服务器返回数据和服务器可能返回的exception
     */
    private static class ResponseFunction<T extends BaseBean> implements Function<Response<T>, ObservableSource<T>> {
        @Override
        public ObservableSource<T> apply(Response<T> response) throws Exception {
            Head head = response.getHead();
            if (NetConfig.SERVICE_CODE_SUCCESS.equals(head.getErrCode())) {
                return Observable.just(response.getBody());
            } else {
                return Observable.error(NetExceptionPrevider.handleException(head.getErrCode(), response.getBody().getErrMsg()));
            }
        }
    }
}
