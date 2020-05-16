package eu.thesimplecloud.api.message

import eu.thesimplecloud.api.utils.IConnectedCloudProcess

interface IMessageListener<T> {

    /**
     * This method will be called when the listener receives a message,
     */
    fun messageReceived(msg: T, sender: IConnectedCloudProcess)

}