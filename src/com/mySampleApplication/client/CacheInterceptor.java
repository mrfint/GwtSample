package com.mySampleApplication.client;


import com.google.gwt.http.client.Response;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.storage.client.StorageMap;
import org.jboss.errai.common.client.api.RemoteCallback;
import org.jboss.errai.enterprise.client.jaxrs.MarshallingWrapper;
import org.jboss.errai.enterprise.client.jaxrs.api.ResponseCallback;
import org.jboss.errai.enterprise.client.jaxrs.api.interceptor.RestCallContext;
import org.jboss.errai.enterprise.client.jaxrs.api.interceptor.RestClientInterceptor;

public class CacheInterceptor implements RestClientInterceptor {

    @Override
    public void aroundInvoke(final RestCallContext restCallContext) {

        final String key = restCallContext.getRequestBuilder().getUrl();

        Storage storage = Storage.getLocalStorageIfSupported();

        final StorageMap storageMap = new StorageMap(storage);
        final String fromCache = storageMap.get(key);

        if(fromCache != null){
            restCallContext.setResult(MarshallingWrapper.fromJSON(fromCache, restCallContext.getReturnType()));
        } else{
            restCallContext.proceed(new ResponseCallback() {
                @Override
                public void callback(Response response) {
                    String result = response.getText();
                    storageMap.put(key, result);
                    restCallContext.setResult(MarshallingWrapper.fromJSON(result, restCallContext.getReturnType()));
                }
            });
        }

    }
}
