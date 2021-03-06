package cn.wearbbs.music.api;

import android.content.Context;

import com.alibaba.fastjson.JSON;

import java.util.Map;

import cn.wearbbs.music.util.NetWorkUtil;

public class MVApi {
    private String result;
    public Map getMVUrl(String mvid) throws InterruptedException {
        Thread tmp = new Thread(() -> {
            result = NetWorkUtil.sendByGetUrl("https://music.wearbbs.cn/mv/url?id=" + mvid + "&&r=480");
        });
        tmp.start();
        tmp.join();
        return (Map)JSON.parse(result);
    }
    public Map getMVDetail(String mvid) throws  InterruptedException{
        Thread tmp = new Thread(() -> {
            result = NetWorkUtil.sendByGetUrl("https://music.wearbbs.cn/mv/detail?mvid=" + mvid);
        });
        tmp.start();
        tmp.join();
        return (Map)JSON.parse(result);
    }

}
