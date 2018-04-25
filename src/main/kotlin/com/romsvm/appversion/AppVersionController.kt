package com.romsvm.appversion

import com.romsvm.appversion.entity.Version
import com.romsvm.appversion.repository.VersionRepository
import com.romsvm.appversion.request.AddRequest
import com.romsvm.appversion.request.IncrementRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.web.bind.annotation.*
import java.util.Optional

@RestController
@RequestMapping(path= arrayOf(""))
class AppVersionController {
    @Autowired
    lateinit var versionRepository: VersionRepository

    @PostMapping(path = arrayOf("/add"))
    @ResponseBody
    fun addNewVersion(@RequestBody addRequest: AddRequest): String {
        val existVersion = this.versionRepository.findVersionByName(name = addRequest.name)

        if (existVersion == null) {
            val version = Version()
            version.name = addRequest.name
            versionRepository.saveAndFlush(version)
            return version.token
        } else {
            throw Error("Bad version name")
        }
    }

    @GetMapping(path= arrayOf("/all"))
    @ResponseBody
    fun getAllVersions(): Iterable<Version> {
        return versionRepository.findAll()
    }

    @PostMapping(path = arrayOf("/getVersion"))
    @ResponseBody
    fun incrementVersion(@RequestBody incrementRequest: IncrementRequest): Int {
        val existVersion = this.versionRepository.findVersionByToken(token = incrementRequest.token)

        if (existVersion != null) {
            existVersion.versionCode++
            this.versionRepository.saveAndFlush(existVersion)
            return existVersion.versionCode
        } else {
            throw Error("Bad version token")
        }
    }
}