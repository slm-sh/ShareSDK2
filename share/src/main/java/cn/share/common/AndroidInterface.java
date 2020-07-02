package cn.share.common;

import android.util.Log;
import android.webkit.JavascriptInterface;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.annotation.Target;

public class AndroidInterface {
    private String TAG = "AndroidInterface";
    private String mProductUrl;
    private JSONObject mProductJaon;

    /*商品的URL*/
    public AndroidInterface(String mProductUrl) {
        this.mProductUrl = mProductUrl;
    }
    /*商品的具体参数*/
    public AndroidInterface(JSONObject mProductJaon) {
        this.mProductJaon = mProductJaon;
    }
    /*获取商品URL*/
    @JavascriptInterface
    public String getProductUrl(){
        Log.i(TAG,"JS调用Android获取商品链接："+mProductUrl);
        try {
            JSONObject json = new JSONObject();
            if (mProductUrl!=null) {
                json.put("url",mProductUrl);
                json.put("Code","200");
                json.put("msg","Success");
            }else{
                json.put("Code","300");
                json.put("msg","商品链接为空");
            }
            return json.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*调用分享*/
    @JavascriptInterface
    public void toShare(JSONObject json){
        Log.i(TAG,"JS调用Android传递分享信息");
        Log.i(TAG,json.toString());
    }
    /*Test*/
    @JavascriptInterface
    public void callAndroid(String msg){
        Log.i(TAG,"JS调用Android传递分享信息");
        Log.i(TAG,msg);
    }
}
