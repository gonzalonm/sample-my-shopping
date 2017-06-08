package com.lalosoft.myshopping.data.repository

import com.lalosoft.myshopping.data.api.Api

abstract class BaseCloudRepository(open val api: Api = Api) {

    val HOST = "http://private-2906ba-myshopping.apiary-mock.com"

}