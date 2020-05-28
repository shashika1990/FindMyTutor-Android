package lk.fmt.findmytutor.services.api.retrofit

import lk.fmt.findmytutor.services.api.service.CourseService
import lk.fmt.findmytutor.services.api.service.SuperService
import lk.fmt.findmytutor.services.api.service.TutorService
import lk.fmt.findmytutor.services.api.service.UserService

object APIService {

    enum class Type {
        USER,
        COURSE,
        TUTOR
    }

    fun getService(type: Type): SuperService {
        return when (type) {
            Type.USER -> { buildUserService() }
            Type.COURSE -> { buildCourseService() }
            Type.TUTOR -> { buildTutorService() }
        }
    }

    private fun buildUserService() : UserService {
        return RetrofitConfig.getInstance().create(UserService::class.java)
    }

    private fun buildCourseService(): CourseService {
        return RetrofitConfig.getInstance().create(CourseService::class.java)
    }

    private fun buildTutorService(): TutorService {
        return RetrofitConfig.getInstance().create(TutorService::class.java)
    }
}