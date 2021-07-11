package com.darshan.merchant.core.network.mock

import okhttp3.*

class MockInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val uri = chain.request().url().uri().toString()
        val responseString = when {
            uri.endsWith("orders") -> mockedOrdersJSON
            else -> ""
        }

        return chain.proceed(chain.request())
            .newBuilder()
            .code(200)
            .protocol(Protocol.HTTP_2)
            .message(responseString)
            .body(
                ResponseBody.create(
                    MediaType.parse("application/json"),
                    responseString.toByteArray()
                )
            )
            .addHeader("content-type", "application/json")
            .build()
    }

}

const val mockedOrdersJSON = """
{
    "status": {
        "success": true, 
        "statusCode": 200, 
        "message": "success"
    },
    "data": [
        {
            "id": 10,
            "title": "Special extra large fried rice",
            "addons": [{
                "id": 21,
                "title": "Fried Egg", 
                "quantity": 3
            }],
            "quantity": 1,
            "created_at": "2021-06-10T00:17:20.000Z", 
            "alerted_at": "2021-06-10T00:17:20.000Z", 
            "expired_at": "2021-06-10T00:17:20.000Z"
        }, 
        {
            "id": 11,
            "title": "Chicken Noodle",
            "addons": [{
                "id": 26,
                "title": "Extra chicken", 
                "quantity": 2
            }, {
                "id": 27,
                "title": "Sambal",
                "quantity": 1 
            }],
            "quantity": 1,
            "created_at": "2021-06-10T00:17:20.000Z", 
            "alerted_at": "2021-06-10T00:17:20.000Z", 
            "expired_at": "2021-06-10T00:17:20.000Z"
        }
    ]
}
"""