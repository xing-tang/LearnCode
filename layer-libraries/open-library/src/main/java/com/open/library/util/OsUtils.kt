package com.changba.library.util

import android.os.Environment
import android.text.TextUtils
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.util.*


/**
 * 设备系统工具类
 */
object OsUtils {

    //MIUI标识
    private val KEY_MIUI_VERSION_CODE: String = "ro.miui.ui.version.code"
    private val KEY_MIUI_VERSION_NAME: String = "ro.miui.ui.version.name"
    private val KEY_MIUI_INTERNAL_STORAGE: String = "ro.miui.internal.storage"

    //EMUI标识
    private val KEY_EMUI_VERSION_CODE: String = "ro.build.version.emui"
    private val KEY_EMUI_API_LEVEL: String = "ro.build.hw_emui_api_level"
    private val KEY_EMUI_CONFIG_HW_SYS_VERSION: String = "ro.confg.hw_systemversion"

    //Flyme标识
    private val KEY_FLYME_ID_FALG_KEY: String = "ro.build.display.id"
    private val KEY_FLYME_ID_FALG_VALUE_KEYWORD: String = "Flyme"
    private val KEY_FLYME_ICON_FALG: String = "persist.sys.use.flyme.icon"
    private val KEY_FLYME_SETUP_FALG: String = "ro.meizu.setupwizard.flyme"
    private val KEY_FLYME_PUBLISH_FALG: String = "ro.flyme.published"

    /**
     * 是否是Flyme系统
     * @return
     */
    val isFlyme: Boolean
        get() {
            if(isPropertiesExist(KEY_FLYME_ICON_FALG,
                    KEY_FLYME_SETUP_FALG,
                    KEY_FLYME_PUBLISH_FALG)
            ) {
                return true
            }
            try {
                val buildProperties: BuildProperties = BuildProperties.newInstance()
                if(buildProperties.containsKey(KEY_FLYME_ID_FALG_KEY)) {
                    val romName: String = buildProperties.getProperty(KEY_FLYME_ID_FALG_KEY)
                    if(!TextUtils.isEmpty(romName) && romName.contains(
                            KEY_FLYME_ID_FALG_VALUE_KEYWORD)
                    ) {
                        return true
                    }
                }
            } catch(e: IOException) {
                e.printStackTrace()
            }
            return false
        }

    /**
     * 是否是EMUI系统
     * @return
     */
    val isEMUI: Boolean
        get() = isPropertiesExist(KEY_EMUI_VERSION_CODE, KEY_EMUI_API_LEVEL,
            KEY_EMUI_CONFIG_HW_SYS_VERSION)

    /**
     * 是否是MIUI系统
     * @return
     */
    val isMIUI: Boolean
        get() {
            return isPropertiesExist(KEY_MIUI_VERSION_CODE, KEY_MIUI_VERSION_NAME,
                KEY_MIUI_INTERNAL_STORAGE)
        }

    private fun isPropertiesExist(vararg keys: String): Boolean {
        if(keys == null || keys.size == 0) {
            return false
        }
        try {
            val properties: BuildProperties = BuildProperties.newInstance()
            for(key: String in keys) {
                val value: String? = properties.getProperty(key)
                if(value != null) return true
            }
            return false
        } catch(e: IOException) {
            return false
        }
    }

    private class BuildProperties private constructor() {

        private val properties: Properties = Properties()

        companion object {
            @Throws(IOException::class)
            fun newInstance(): BuildProperties {
                return BuildProperties()
            }
        }

        init {
            // 读取系统配置信息build.prop类
            properties.load(FileInputStream(File(Environment.getRootDirectory(), "build.prop")))
        }


        fun containsKey(key: Any): Boolean {
            return properties.containsKey(key)
        }

        fun containsValue(value: Any): Boolean {
            return properties.containsValue(value)
        }

        fun entrySet(): Set<Map.Entry<Any, Any>> {
            return properties.entries
        }

        fun getProperty(name: String?): String {
            return properties.getProperty(name)
        }

        fun getProperty(name: String?, defaultValue: String?): String {
            return properties.getProperty(name, defaultValue)
        }

        val isEmpty: Boolean
            get() {
                return properties.isEmpty
            }

        fun keys(): Enumeration<Any> {
            return properties.keys()
        }

        fun keySet(): Set<Any> {
            return properties.keys
        }

        fun size(): Int {
            return properties.size
        }

        fun values(): Collection<Any> {
            return properties.values
        }
    }
}
