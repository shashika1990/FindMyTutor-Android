package lk.fmt.findmytutor.helpers.mappers

import lk.fmt.findmytutor.models.Course
import lk.fmt.findmytutor.services.api.responsemodels.CoursesResponse

object Mapper {

    fun map(source: CoursesResponse) : Course {

        val course = Course()
        course.id = source.id
        course.title = source.title
        course.description = source.description
        course.district = source.description
        course.city = source.city
        course.startDate = source.startDate
        course.time = source.time
        course.day = source.day
        course.subject = source.subject
        course.grade = source.grade
        course.classType = source.classType
        course.medium = source.medium
        course.bannerPath = source.bannerPath

        return course
    }

}