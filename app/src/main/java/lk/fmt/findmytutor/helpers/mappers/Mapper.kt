package lk.fmt.findmytutor.helpers.mappers

import lk.fmt.findmytutor.helpers.enum.Medium
import lk.fmt.findmytutor.helpers.enum.TutionType
import lk.fmt.findmytutor.models.Course
import lk.fmt.findmytutor.models.Tutor
import lk.fmt.findmytutor.services.api.responsemodels.CoursesResponse

object Mapper {

    fun map(source: CoursesResponse) : Course {

        val course = Course()
        course.id = source.id
        course.title = source.title
        course.description = source.description
        course.district = source.district
        course.city = source.city
        course.startDate = source.startDate
        course.time = source.time
        course.day = source.day
        course.subject = source.subject
        course.grade = source.grade
        course.bannerPath = source.bannerPath
        
        when(source.medium) {
            0 -> { course.mediumClient = Medium.SINHALA.value }
            1 -> { course.mediumClient = Medium.TAMIL.value }
            2 -> { course.mediumClient = Medium.ENGLISH.value }
        }

        when(source.classType) {
            0 -> { course.mediumClient = TutionType.INDIVIDUAL.value }
            1 -> { course.mediumClient = TutionType.GROUP.value }
            2 -> { course.mediumClient = TutionType.MASTER.value }
        }

        source.tutor?.let {
            val tutor = Tutor()
            tutor.fullName = it.firstName.plus(" ").plus(it.lastName)

            course.tutor = tutor
        }

        return course
    }

}