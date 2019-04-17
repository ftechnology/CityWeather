package com.farukhossain.tokyoweather.appfrm

import android.util.Log

/**
 * Created by farukhossain on 2019/04/16.
 */
class LogUtil {

    companion object {
        const val VERBOSE = Log.VERBOSE
        val DEBUG = Log.DEBUG
        val INFO = Log.INFO
        val WARN = Log.WARN
        val ERROR = Log.ERROR


        /**
         * TAG for Application.
         * TODO place the name of the application here
         */
        internal val TAG = "LogUtil"
        // Current log level
        var LOGLEVEL = Log.DEBUG

        /**
         * Set the current log level.
         *
         * @param logLevel
         */
        fun setLogLevel(logLevel: Int) {
            LOGLEVEL = logLevel
            Log.i("CordovaLog", "Changing log level to " + logLevel)
        }

        /**
         * Set the current log level.
         *
         * @param logLevel
         */
        fun setLogLevel(logLevel: String) {
            if ("VERBOSE" == logLevel)
                LOGLEVEL = VERBOSE
            else if ("DEBUG" == logLevel)
                LOGLEVEL = DEBUG
            else if ("INFO" == logLevel)
                LOGLEVEL = INFO
            else if ("WARN" == logLevel)
                LOGLEVEL = WARN
            else if ("ERROR" == logLevel) LOGLEVEL = ERROR
            Log.i("CordovaLog", "Changing log level to $logLevel($LOGLEVEL)")
        }

        /**
         * Determine if log level will be logged
         *
         * @param logLevel
         * @return true if the parameter passed in is greater than or equal to the current log level
         */
        fun isLoggable(logLevel: Int): Boolean {
            return logLevel >= LOGLEVEL
        }

        /**
         * Verbose log message.
         *
         * @param s
         */
        fun v(s: String) {
            if (LogUtil.VERBOSE >= LOGLEVEL) Log.v(TAG, s)
        }

        /**
         * Send a DEBUG log message and log the exception.<BR></BR>
         * <P>
         * See Android SDK.
        </P> */
        fun d(msg: String) {
            if (LogUtil.DEBUG >= LOGLEVEL) {
                Log.d(TAG, msg)
            }
        }

        /**
         * Info log message.
         *
         * @param s
         */
        fun i(s: String) {
            if (LogUtil.INFO >= LOGLEVEL) Log.i(TAG, s)
        }

        /**
         * Warning log message.
         *
         * @param s
         */
        fun w(s: String) {
            if (INFO >= LOGLEVEL) Log.w(TAG, s)
        }

        /**
         * Error log message.
         *
         * @param s
         */
        fun e(s: String) {
            if (LogUtil.ERROR >= LOGLEVEL) Log.e(TAG, s)
        }

        /**
         * Verbose log message.
         *
         * @param s
         * @param e
         */
        fun v(s: String, e: Throwable) {
            if (LogUtil.VERBOSE >= LOGLEVEL) Log.v(TAG, s, e)
        }

        /**
         * Debug log message.
         *
         * @param s
         * @param e
         */
        fun d(s: String, e: Throwable) {
            if (LogUtil.DEBUG >= LOGLEVEL) Log.d(TAG, s, e)
        }

        /**
         * Info log message.
         *
         * @param s
         * @param e
         */
        fun i(s: String, e: Throwable) {
            if (LogUtil.INFO >= LOGLEVEL) Log.i(TAG, s, e)
        }

        /**
         * Warning log message.
         *
         * @param s
         * @param e
         */
        fun w(s: String, e: Throwable) {
            if (LogUtil.WARN >= LOGLEVEL) Log.w(TAG, s, e)
        }

        /**
         * Error log message.
         *
         * @param s
         * @param e
         */
        fun e(s: String, e: Throwable) {
            if (LogUtil.ERROR >= LOGLEVEL) Log.e(TAG, s, e)
        }

        /**
         * Verbose log message with printf formatting.
         *
         * @param s
         * @param args
         */
        fun v(s: String, vararg args: Any) {
            if (LogUtil.VERBOSE >= LOGLEVEL) Log.v(TAG, java.lang.String.format(s, *args))
        }

        /**
         * Debug log message with printf formatting.
         *
         * @param s
         * @param args
         */
        fun d(s: String, vararg args: Any) {
            if (LogUtil.DEBUG >= LOGLEVEL) Log.d(TAG, java.lang.String.format(s, *args))
        }

        /**
         * Info log message with printf formatting.
         *
         * @param s
         * @param args
         */
        fun i(s: String, vararg args: Any) {
            if (LogUtil.INFO >= LOGLEVEL) Log.i(TAG, java.lang.String.format(s, *args))
        }

        /**
         * Warning log message with printf formatting.
         *
         * @param s
         * @param args
         */
        fun w(s: String, vararg args: Any) {
            if (LogUtil.WARN >= LOGLEVEL) Log.w(TAG, java.lang.String.format(s, *args))
        }

        /**
         * Error log message with printf formatting.
         *
         * @param s
         * @param args
         */
        fun e(s: String, vararg args: Any) {
            if (LogUtil.ERROR >= LOGLEVEL) Log.e(TAG, java.lang.String.format(s, *args))
        }
    }
}