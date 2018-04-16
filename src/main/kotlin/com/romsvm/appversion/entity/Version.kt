package com.romsvm.appversion.entity

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Version {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int = 0

    var versionCode: Int = 0
    var name: String = ""
    var token: String = UUID.randomUUID().toString()
}