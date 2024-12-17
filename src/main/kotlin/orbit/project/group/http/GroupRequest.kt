package orbit.project.group.http

import java.util.UUID

data class GroupRequest(
    var groupId : UUID?,
    val groupName : String,
    val isRead : Boolean?,
    val isWrite : Boolean?
)


