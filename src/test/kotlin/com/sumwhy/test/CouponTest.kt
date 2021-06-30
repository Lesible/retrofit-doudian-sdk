package com.sumwhy.test

import com.sumwhy.camelToSnakeCase
import io.lesible.model.response.marketing.CouponMetaDetail
import io.lesible.model.response.marketing.ShopCouponMetaInfo
import org.junit.jupiter.api.Test
import kotlin.reflect.full.memberProperties
import kotlin.reflect.javaType

/**
 * <p> @date: 2021-06-30 11:43</p>
 * @author 何嘉豪
 */
class CouponTest {
    @Test
    @OptIn(ExperimentalStdlibApi::class)
    fun fieldNum() {
//        val set1 = CouponMetaDetail::class.memberProperties.map { "private ${it.returnType.javaType.typeName.substringAfterLast(".")}  ${it.name}"}.toMutableSet()
//        val set2 = ShopCouponMetaInfo::class.memberProperties.map { "private ${it.returnType.javaType.typeName.substringAfterLast(".")}  ${it.name}"}.toSet()
        val set1 = CouponMetaDetail::class.memberProperties.map { it.name to it.returnType.javaType }.toMutableSet()
        val set2 = ShopCouponMetaInfo::class.memberProperties.map { it.name to it.returnType.javaType }.toSet()
        set1.addAll(set2)
        println(set1.map { it.first.camelToSnakeCase() })
        println("set:$set1,size:${set1.size}")
    }
}