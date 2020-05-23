package eu.thesimplecloud.base.manager.impl

import eu.thesimplecloud.api.CloudAPI
import eu.thesimplecloud.api.eventapi.IEventManager
import eu.thesimplecloud.api.external.ICloudModule
import eu.thesimplecloud.api.player.ICloudPlayerManager
import eu.thesimplecloud.api.screen.ICommandExecuteManager
import eu.thesimplecloud.api.service.ICloudServiceManager
import eu.thesimplecloud.api.servicegroup.ICloudServiceGroupManager
import eu.thesimplecloud.api.sync.`object`.ISingleSynchronizedObjectManager
import eu.thesimplecloud.api.sync.list.manager.ISynchronizedObjectListManager
import eu.thesimplecloud.api.sync.list.manager.SynchronizedObjectListManager
import eu.thesimplecloud.api.template.ITemplateManager
import eu.thesimplecloud.api.utils.INetworkComponent
import eu.thesimplecloud.api.wrapper.IWrapperManager
import eu.thesimplecloud.base.manager.startup.Manager
import eu.thesimplecloud.clientserverapi.lib.bootstrap.ICommunicationBootstrap

class CloudAPIImpl : CloudAPI() {

    private val cloudPlayerManager = CloudPlayerManagerImpl()
    private val cloudServiceGroupManager = CloudServiceGroupManagerImpl()
    private val cloudServiceManager = CloudServiceManagerImpl()
    private val commandExecuteManager = CommandExecuteManagerImpl()
    private val templateManager = TemplateManagerImpl()
    private val wrapperManager = WrapperManagerImpl()
    private val eventManager = EventManagerImpl()
    private val synchronizedObjectManager = SingleSynchronizedObjectManagerImpl()
    private val synchronizedObjectListManager = SynchronizedObjectListManager()

    init {
        getCacheListManager().registerCacheList(getWrapperManager())
        getCacheListManager().registerCacheList(getCloudServiceManager())
        getCacheListManager().registerCacheList(getCloudServiceGroupManager())
        getCacheListManager().registerCacheList(getTemplateManager())
        getCacheListManager().registerCacheList(getCloudPlayerManager())
    }


    override fun getCloudServiceGroupManager(): ICloudServiceGroupManager = this.cloudServiceGroupManager

    override fun getCloudServiceManager(): ICloudServiceManager = this.cloudServiceManager

    override fun getCloudPlayerManager(): ICloudPlayerManager = this.cloudPlayerManager

    override fun getEventManager(): IEventManager = this.eventManager

    override fun getCommandExecuteManager(): ICommandExecuteManager = this.commandExecuteManager

    override fun getSingleSynchronizedObjectManager(): ISingleSynchronizedObjectManager = this.synchronizedObjectManager

    override fun getThisSidesCommunicationBootstrap(): ICommunicationBootstrap = Manager.instance.communicationServer

    override fun getSynchronizedObjectListManager(): ISynchronizedObjectListManager = this.synchronizedObjectListManager

    override fun getTemplateManager(): ITemplateManager = this.templateManager

    override fun getWrapperManager(): IWrapperManager = this.wrapperManager

    override fun getThisSidesName(): String = "Manager"

    override fun getThisSidesNetworkComponent(): INetworkComponent {
        return INetworkComponent.MANAGER_COMPONENT
    }

    override fun getThisSidesCloudModule(): ICloudModule = Manager.instance


}