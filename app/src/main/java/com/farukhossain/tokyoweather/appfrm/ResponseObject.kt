package com.farukhossain.tokyoweather.appfrm

import com.farukhossain.tokyoweather.model.ResponseData
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by farukhossain on 2019/04/16.
 */
class ResponseObject(code: Int, msg: String, obj: ArrayList<ResponseData>?) {

    companion object {
        var mContinue = "mContinue"
        var mComplete = "mComplete"
        var mFailed = "mFailed"
        var mStatus = "mStatus"
        var mSuccess = "mSuccess"
        var mCancel = "mCancel"
        var mItemPosition = "mItemPosition"
    }

    // The response code
    private var mResponseCode = code//INVALID CODE
    // The response message
    private var mResponseMsg = msg
    // The resulting object
    private var mDataObject: ArrayList<ResponseData>? = obj
    // The converted data string
    private var mDataString: String? = null
    // The model/adapter that creates this response
    private var mDataModel: Any? = null
    // Server content before download.
    private var mContentMain: Long = -1
    // Server content after download.
    private var mContentDownloaded: Long = -1


    /**
     * @return the mContentMain
     */
    fun getContentMain(): Long {
        return mContentMain
    }

    /**
     * @param mContentMain the mContentMain to set
     */
    fun setContentMain(mContentMain: Long) {
        this.mContentMain = mContentMain
    }

    /**
     * @return the mContentDownloaded
     */
    fun getContentDownloaded(): Long {
        return mContentDownloaded
    }

    /**
     * @param mContentDownloaded the mContentDownloaded to set
     */
    fun setContentDownloaded(mContentDownloaded: Long) {
        this.mContentDownloaded = mContentDownloaded
    }


    /**
     * @return the mDataModel
     */
    fun getDataModel(): Any? {
        return mDataModel
    }

    /**
     * @param mDataModel the mDataModel to set
     */
    fun setDataModel(mDataModel: Any) {
        this.mDataModel = mDataModel
    }

    /**
     * @return the mDataString
     */
    fun getDataString(): String? {
        return mDataString
    }

    /**
     * @param mDataString the mDataString to set
     */
    fun setDataString(mDataString: String) {
        this.mDataString = mDataString
    }

    /**
     *
     */
    fun ResponseObject() {
        this.setValues(Integer.MIN_VALUE, "Failed", null)
    }

    /**
     * Set the values for response object
     * @param code
     * @param msg
     * @param obj
     */
    fun setValues(code: Int, msg: String, obj: ArrayList<ResponseData>?) {
        this.mResponseCode = code
        this.mDataObject = obj
        this.mResponseMsg = msg
    }

    /**
     * @return the mResponseCode
     */
    fun getResponseCode(): Int {
        return mResponseCode
    }

    /**
     * Set the response code
     * @param code
     */
    fun setResponseCode(code: Int) {
        mResponseCode = code
    }

    /**
     * @return the mResponseMsg
     */
    fun getResponseMsg(): String {
        return mResponseMsg
    }

    /**
     * Set the response message
     * @param msg
     */
    fun setResponseMsg(msg: String) {
        mResponseMsg = msg
    }

    /**
     * @return the mDataObject
     */
    fun getDataObject(): ArrayList<ResponseData>? {
        return mDataObject
    }

    /**
     * Set the result object
     * @param obj
     */
    fun setDataObject(obj: ArrayList<ResponseData>) {
        mDataObject = obj
    }
}