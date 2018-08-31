package com.fdt.net.response;


import com.fdt.net.common.BaseBean;
import com.fdt.net.common.Head;

import java.io.Serializable;

/**
 * Created by fudetian on 2018/8/28.
 */

public class Response<T extends BaseBean> implements Serializable {
    private Head head;
    private T body;

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
