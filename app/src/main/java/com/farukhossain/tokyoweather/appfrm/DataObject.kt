package com.farukhossain.tokyoweather.appfrm

import org.json.JSONException
import org.json.JSONObject

/**
 * Created by farukhossain on 2019/04/16.
 */
class DataObject : JSONObject() {

    private val ID = "ID"
    private val NAME = "NAME"

    /**
     * The id of this object
     *
     * @param id
     */
    fun DataObject(id: Long) {
        this.setValue(ID, id)
    }

    fun DataObject(name: String, key: String) {
        this.setValue(ID, key)
        this.setValue(NAME, name)
    }

    fun DataObject(name: String, key: Long) {
        this.setValue(ID, key)
        this.setValue(NAME, name)
    }

    /**
     * The value to be set for name.
     *
     * @param name the key.
     * @param id   the long value of the name.
     */
    fun setValue(name: String, id: Long) {
        try {
            this.put(name, id)
        } catch (e: JSONException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        }

    }

    /**
     * The value to be set for name.
     *
     * @param name  the key.
     * @param value the string value of the name.
     */
    fun setValue(name: String, value: String) {
        try {
            this.put(name, value)
        } catch (e: JSONException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        }

    }

    /**
     * The value to be set for name.
     *
     * @param name  the key.
     * @param value the string value of the name.
     */
    fun setValue(name: String, value: Any) {
        try {
            this.put(name, value)
        } catch (e: JSONException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        }

    }

    /**
     * Return the value for given name, return null if no key found.
     *
     * @param name
     * @return
     */
    fun getValue(name: String): Any? {
        try {
            return this.get(name)
        } catch (e: JSONException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        }

        return null
    }

    /**
     * Return the value for given name, return null if no key found.
     */
    override fun getString(name: String): String? {
        try {
            return super.getString(name)
        } catch (e: JSONException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        }

        return null
    }

    /**
     * @return the ID of this object.
     */
    fun getId(): Long {

        return (getValue(ID) as Long?)!!
    }

    /**
     * Set the id of this object.
     *
     * @param id
     */
    fun setId(id: Long) {
        this.setValue(ID, id)
    }

    /**
     * Return the value for given name, return null if no key found.
     */
    override fun getLong(name: String): Long {
        try {
            return super.getLong(name)
        } catch (e: JSONException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        }

        return -999999999//Invalid value
    }

    /**
     * Return the value for given name, return null if no key found.
     */
    override fun getInt(name: String): Int {
        try {
            return super.getInt(name)
        } catch (e: JSONException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        }

        return -999999999//Invalid value
    }
}