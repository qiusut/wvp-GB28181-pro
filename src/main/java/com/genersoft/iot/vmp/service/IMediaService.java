package com.genersoft.iot.vmp.service;

import com.genersoft.iot.vmp.common.StreamInfo;
import com.genersoft.iot.vmp.media.bean.MediaInfo;
import com.genersoft.iot.vmp.media.bean.ResultForOnPublish;
import com.genersoft.iot.vmp.media.zlm.dto.MediaServer;

/**
 * 媒体信息业务
 */
public interface IMediaService {

    /**
     * 根据应用名和流ID获取播放地址, 通过zlm接口检查是否存在
     * @param app
     * @param stream
     * @return
     */
    StreamInfo getStreamInfoByAppAndStreamWithCheck(String app, String stream, String mediaServerId,String addr, boolean authority);


    /**
     * 根据应用名和流ID获取播放地址, 通过zlm接口检查是否存在, 返回的ip使用远程访问ip，适用与zlm与wvp在一台主机的情况
     * @param app
     * @param stream
     * @return
     */
    StreamInfo getStreamInfoByAppAndStreamWithCheck(String app, String stream, String mediaServerId, boolean authority);

    /**
     * 根据应用名和流ID获取播放地址, 只是地址拼接
     * @param app
     * @param stream
     * @return
     */
    StreamInfo getStreamInfoByAppAndStream(MediaServer mediaServerItem, String app, String stream, MediaInfo mediaInfo, String callId);

    /**
     * 根据应用名和流ID获取播放地址, 只是地址拼接，返回的ip使用远程访问ip，适用与zlm与wvp在一台主机的情况
     * @param app
     * @param stream
     * @return
     */
    StreamInfo getStreamInfoByAppAndStream(MediaServer mediaServerItem, String app, String stream, MediaInfo mediaInfo, String addr, String callId, boolean isPlay);

    /**
     * 播放鉴权
     */
    boolean authenticatePlay(String app, String stream, String callId);

    ResultForOnPublish authenticatePublish(MediaServer mediaServer, String app, String stream, String params);

    boolean closeStreamOnNoneReader(String mediaServerId, String app, String stream, String schema);
}
