package com.romsvm.appversion.repository

import com.romsvm.appversion.entity.Version
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

@Repository
interface VersionRepository : JpaRepository<Version, String> {
    @Query("SELECT v FROM Version v WHERE v.name = ?1")
    fun findVersionByName(name: String): Version?

    @Query("SELECT v FROM Version v WHERE v.token = ?1")
    fun findVersionByToken(token: String): Version?
}