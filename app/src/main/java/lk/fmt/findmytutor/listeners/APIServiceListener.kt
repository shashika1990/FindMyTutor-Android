package lk.fmt.findmytutor.listeners

interface APIServiceListener {
    /**
     * Invokes when the status of an API call is successful
     * @param data Response body
     */
    fun <T> onSuccess(data: T?)

    /**
     * Invokes when the status of an API call is unsuccessful
     * @param message Message describing the reason for failure
     * @return Nothing
     */
    fun onFailure(message: String)

    /**
     * Invokes when an error occurred during an API call
     */
    fun onError(message: String)
}