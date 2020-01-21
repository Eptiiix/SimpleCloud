package eu.thesimplecloud.api

import eu.thesimplecloud.api.eventapi.IEventManager
import eu.thesimplecloud.api.player.ICloudPlayerManager
import eu.thesimplecloud.api.screen.ICommandExecuteManager
import eu.thesimplecloud.api.screen.ICommandExecutable
import eu.thesimplecloud.api.service.ICloudServiceManager
import eu.thesimplecloud.api.servicegroup.ICloudServiceGroupManager
import eu.thesimplecloud.api.template.ITemplateManager
import eu.thesimplecloud.api.wrapper.IWrapperManager

/**
 * It represents the main part of a cloud part
 * The Wrapper, Manager and CloudPlugin should implement this interface.
 */
interface ICloudAPI {

    /**
     * Returns the [IWrapperManager] to manage wrapper
     */
    fun getWrapperManager(): IWrapperManager

    /**
     * Returns the [ICloudServiceGroupManager] to manage service groups
     */
    fun getCloudServiceGroupManager(): ICloudServiceGroupManager

    /**
     * Returns the [ICloudServiceManager] to manage services
     */
    fun getCloudServiceManager(): ICloudServiceManager

    /**
     * Returns the [ICloudPlayerManager] to manage players
     */
    fun getCloudPlayerManager(): ICloudPlayerManager

    /**
     * Returns the [IEventManager] to manage and call events
     */
    fun getEventManager(): IEventManager

    /**
     * Returns the [ICommandExecuteManager] used to execute command on [ICommandExecutable]
     */
    fun getCommandExecuteManager(): ICommandExecuteManager

    /**
     * Returns the [ITemplateManager] used to manage the templates
     */
    fun getTemplateManager(): ITemplateManager

    /**
     * Returns the name of this side
     * e.g Manager / Wrapper / Lobby-1
     */
    fun getThisSidesName(): String
}