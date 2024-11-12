package com.wallace.foodycare

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform