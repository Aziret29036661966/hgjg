package com.example.orozbek.data.network.repos;

import com.example.orozbek.domain.entity.Info;

public interface CallBackResult {
    void onSuccess(Info info);
    void onFail(String error);
}
