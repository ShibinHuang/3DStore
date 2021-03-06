package com.runmit.sweedee.datadao;

import java.util.ArrayList;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.runmit.sweedee.model.CmsVedioDetailInfo.SubTitleInfo;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table PLAY_RECORD.
 */
public class PlayRecord{

    private long key;
    private Long albumid;
    private Long uid;
    private Long orinCreateTime;
    private Integer vedioid;
    private Long createTime;
    private String name;
    private String picurl;
    private String subtilteStrInfo;
    private Integer playPos;
    private Integer duration;
    private Integer mode;

    /**外部非数据库字段*/
    public boolean isSelected = false;
    
    /**外部构造的函数*/
    //to-do orinCreateTime 赋值
    public PlayRecord(int mode,long albumid, long uid, int vedioid, String name, String picurl, Long createTime, Integer playPos, Integer duration, ArrayList<SubTitleInfo> subtilteInfo,long orinCreateTime) {    	
        this.mode = mode;
    	this.key = getHashKey(albumid, uid);        
        this.albumid = albumid;
        this.uid = uid;
        this.orinCreateTime = orinCreateTime;// 补充
        this.vedioid = vedioid;
        this.name = name;
        this.picurl = picurl;
        this.createTime = createTime;
        this.playPos = playPos;
        this.duration = duration;
        this.subtilteStrInfo = generateSubtitleStr(subtilteInfo);
    }
    
    public PlayRecord() {
    }

    public PlayRecord(long key) {
        this.key = key;
    }

    public PlayRecord(long key, Long albumid, Long uid, Long orinCreateTime, Integer vedioid, Long createTime, String name, String picurl, String subtilteStrInfo, Integer playPos, Integer duration, Integer mode) {
        this.key = key;
        this.albumid = albumid;
        this.uid = uid;
        this.orinCreateTime = orinCreateTime;
        this.vedioid = vedioid;
        this.createTime = createTime;
        this.name = name;
        this.picurl = picurl;
        this.subtilteStrInfo = subtilteStrInfo;
        this.playPos = playPos;
        this.duration = duration;
        this.mode = mode;
    }

    public long getKey() {
        return key;
    }

    public void setKey(long key) {
        this.key = key;
    }

    public long getAlbumid() {
        return albumid;
    }

    public void setAlbumid(Long albumid) {
        this.albumid = albumid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getOrinCreateTime() {
        return orinCreateTime;
    }

    public void setOrinCreateTime(Long orinCreateTime) {
        this.orinCreateTime = orinCreateTime;
    }

    public Integer getVedioid() {
        return vedioid;
    }

    public void setVedioid(Integer vedioid) {
        this.vedioid = vedioid;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String getSubtilteStrInfo() {
        return subtilteStrInfo;
    }

    public void setSubtilteStrInfo(String subtilteStrInfo) {
        this.subtilteStrInfo = subtilteStrInfo;
    }

    public Integer getPlayPos() {
        return playPos;
    }

    public void setPlayPos(Integer playPos) {
        this.playPos = playPos;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getMode() {
        return mode;
    }

    public void setMode(Integer mode) {
        this.mode = mode;
    }

    /**add by sven.zhan*/
    public String generateSubtitleStr(ArrayList<SubTitleInfo> subtilteInfo){
    	if(subtilteInfo != null){
    		String str = new Gson().toJson(subtilteInfo, new TypeToken<ArrayList<SubTitleInfo>>(){}.getType());
        	return str;
    	}else{
    		return null;
    	}
    }
    
    /**add by sven.zhan*/
    public ArrayList<SubTitleInfo> getSubTitleList(){
    	ArrayList<SubTitleInfo> list = null;
    	if(subtilteStrInfo != null){
    		try {
    			list = new Gson().fromJson(subtilteStrInfo, new TypeToken<ArrayList<SubTitleInfo>>(){}.getType());  
			} catch (Exception e) {
			}
    	}
    	return list;
    }
    
    /**由albumid和 uid生成主键*/
    public static long getHashKey(long albumid, long uid){
    	return (albumid+"_"+uid).hashCode(); 
    }
}
