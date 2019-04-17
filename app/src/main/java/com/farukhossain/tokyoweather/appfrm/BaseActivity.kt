package com.farukhossain.tokyoweather.appfrm

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.TextView

/**
 * Created by farukhossain on 2019/04/16.
 */
abstract class BaseActivity : AppCompatActivity(), NotifyObserver {

    protected var mInstance: BaseActivity ? = this

    public fun BaseActivity() {
        this.mInstance = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // DONOT change this order may creates the problems
        createAdapter()
        createView(savedInstanceState)
        loadData()
    }


    /** Views should be created here, set the listeners, observer etc..  */
    protected abstract fun createView(savedInstanceState: Bundle?)

    /** Actions should be created here  */
    protected abstract fun createAdapter()

    /** Concrete class should know how to load the data by adapters  */
    protected abstract fun loadData()

    /** Get the data from response, no need to create runOnUiThread its all ready maintained  */
    abstract fun doUpdateRequest(response: ResponseObject)

    @Synchronized override fun update(response: ResponseObject) {
        runOnUiThread {
            this.mInstance?.doUpdateRequest(response)
        }
    }

    /**
     * Gets the class name
     * @param cls
     * @return
     * Class name
     */
    fun getClassName(cls: Class<*>): String {
        var fullName = cls.name
        val pos = fullName.lastIndexOf('.') + 1
        if (pos > 0) {
            fullName = fullName.substring(pos)
        }
        return fullName
    }

    /**
     * Gets view from resource
     * @param rViewId
     * @return
     */
    protected fun getView(rViewId: Int): View? {
        return findViewById(rViewId)
    }

    /**
     * Hide the requested view.
     * @param rViewId
     */
    protected fun hideView(rViewId: Int) {
        val view = findViewById<View>(rViewId)
        if (view != null) {
            view.visibility = View.GONE
        }
    }

    /**
     * Show the requested view.
     * @param rViewId
     */
    protected fun showView(rViewId: Int) {
        val view = findViewById<View>(rViewId)
        if (view != null) {
            view.visibility = View.VISIBLE
        }
    }

    /**
     * Sets text from resource into view
     * @param rViewId
     * @param rTextId
     */
    protected fun setText(rViewId: Int, rTextId: Int) {
        val view = getView(rViewId)
        (view as? TextView)?.setText(rTextId)
    }

    /**
     * Sets text from resource into view but from different thread/Cross Thread
     * @param rIdText
     * Resource id of text
     */
    protected fun setTextCT(rViewId: Int, rIdText: Int) {
        runOnUiThread { mInstance?.setText(rViewId, rIdText) }
    }

    /**
     * Sets text into view
     * @param rViewId
     * @param text
     */
    protected fun setText(rViewId: Int, text: String) {
        val view = getView(rViewId)
        if (view is TextView) {
            view.text = text
        }
    }

    /**
     * Get EditText text value.
     * @param rViewId
     * @return
     */
    protected fun getTextEditText(rViewId: Int): String {
        val view = getView(rViewId)

        return if (view is EditText) {
            (findViewById<View>(rViewId) as EditText).text.toString().trim { it <= ' ' }
        } else ""

    }

    /**
     * Sets background from resource
     * @param rViewId
     * @param rBackgroundId
     */
    protected fun setBackGround(rViewId: Int, rBackgroundId: Int) {
        val view = getView(rViewId)
        view?.setBackgroundResource(rBackgroundId)
    }

    fun startActivity(name: Class<*>) {

        val intent = Intent(this, name)
        startActivity(intent)
    }

    fun startActivityForResult(name: Class<*>, ResultCode: Int) {
        val intent = Intent(this, name)
        startActivityForResult(intent, ResultCode)
    }
}