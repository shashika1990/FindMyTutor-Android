package lk.fmt.findmytutor.dto

data class UserForSignIn(
    var email: String?,
    var password: String?
) {
    constructor() : this(
        email = null,
        password = null
    )
}