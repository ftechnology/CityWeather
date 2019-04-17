package com.farukhossain.tokyoweather.appfrm

import android.content.Context
import android.os.Handler
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import java.util.ArrayList

/**
 * Created by farukhossain on 2019/04/16.
 */
abstract class AbsRecycleViewBaseAdapter : RecyclerView.Adapter<ViewHolder>() {

    // Instance of this class.
    protected var mInstance: AbsRecycleViewBaseAdapter? = null
    // Unique name of the adapter/model
    protected var mName = "AbsRecycleViewBaseAdapter"
    protected var mContext: Context ? = null
    // The resulting values of this adapter
    protected var mListItem: ArrayList<DataObject>? = ArrayList()
    // This is for invalid item id
    protected var INVALID_ITEM_ID = java.lang.Long.MIN_VALUE
    // When we do call executeAsyn() we must have to pass to get the result by this observer
    protected var mNotifyObserver: NotifyObserver? = null
    //
    protected var mCancel: Boolean = false
    // The operation needs to be cancelled, so what we need just to store the controller.
    // We must have to release this controller after the result.
    internal var mHandler = Handler()
    //
    protected var mCurrentSelection: DataObject ? = null

    /**
     * @return the mCurrentSelection
     */
    fun getmCurrentSelection(): DataObject ? {
        return mCurrentSelection
    }


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int{
        return if (this.mListItem == null) 0 else this.mListItem!!.size
    }

    /**
     * @param mCurrentSelection the mCurrentSelection to set
     */
    fun setmCurrentSelection(mCurrentSelection: DataObject) {
        this.mCurrentSelection = mCurrentSelection
    }

    /**
     * Constructor function that takes the name of the adapter/model
     * @param uniqueName
     */
    fun AbsRecycleViewBaseAdapter(uniqueName: String){
        this.mName = uniqueName
        mInstance = this
        mCancel = false
    }

    fun AbsRecycleViewBaseAdapter(){
        mInstance = this
        mCancel = false
    }

    fun AbsRecycleViewBaseAdapter(context: Context) {
        mInstance = this
        mCancel = false
        mContext = context
    }


    /**
     * @return the mNotifyObserver
     */
    fun getNotifyObserver(): NotifyObserver ? {
        return mNotifyObserver
    }


    /**
     * @param mNotifyObserver the mNotifyObserver to set
     */
    fun setNotifyObserver(mNotifyObserver: NotifyObserver) {
        this.mNotifyObserver = mNotifyObserver
    }

    /**
     * Notify the observer using a handler.
     * @param response
     */
    @Synchronized
    fun notifyObserver(response: ResponseObject) {

        mHandler.post {
            if (mNotifyObserver != null) {
                mNotifyObserver?.update(response)
            }
        }
    }

    /**
     * Cancel the operation, that is executed in different thread.
     */
    fun cancel() {
        mCancel = true
    }

    /**
     * @return the mContext
     */
    fun getContext(): Context ? {
        return mContext
    }

    /**
     * @param context the context to set
     */
    fun setContext(context: Context) {
        this.mContext = context
    }

    /**
     * @return the mName
     */
    fun getName(): String {
        return mName
    }

    /**
     * @param mName the mName to set
     */
    fun setName(mName: String) {
        this.mName = mName
    }

    /**
     * Execute the operation after setting the Parameter. Never call this before calling setParameter().
     * If this is AbsWsAdapter must call the executeAsyn().
     * @return
     */
    abstract fun loadData(): ResponseObject

    /**
     * The operation will be performed in different thread. The result will be passed in the observer
     * @param observer
     */
    @Synchronized
    fun loadData(observer: NotifyObserver) {
        // We have to execute the request using a thread
        this.setNotifyObserver(observer)
        Thread(Runnable {
            val resObj = ResponseObject(0,"", null)

            try {
                loadData()
                mInstance?.notifyObserver(resObj)

            } catch (e: Exception) {
                // Error: Need to handle
                resObj.setResponseMsg(e.message.toString())
                LogUtil.e(e.message.toString())
            }
        }).start()
    }

    /**
     * Add an item to the model/adapter
     * @param item
     */
    fun add(item: DataObject?) {
        if (item != null) {
            this.mListItem?.add(item)
        }
    }

    /**
     * Removes the object at the specified location from this list.
     * @param position
     * @return
     */
    fun remove(position: Int): DataObject? {
        return this.mListItem?.removeAt(position)
    }

    /**
     * Removes one instance of the specified object from this Collection if one is contained (optional).
     * @param object
     */
    fun remove(obj: DataObject) {
        this.mListItem?.remove(obj)
    }

    /**
     * Remove all items from the adapter, For Garbage collector if you have some bitmap then those needs to be
     * recycle first, and also put null to the objects. like Bitmap b; b.recyle(); b = null;
     * @param callGarbageCollector Whether system garbage collector will be called
     */
    fun clear(callGarbageCollector: Boolean) {
        mListItem?.clear()
        mCancel = false
        if (callGarbageCollector) {
            System.gc()
        }
    }
}