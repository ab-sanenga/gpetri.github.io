package io.github.gpetri.ch6

sealed trait UserAction
case object Add extends UserAction 
case object Remove extends UserAction
case class UserUpdate(userId: String, action: UserAction) extends UserAction

sealed trait Event
case class AddUserEvent(userId: String) extends Event
case class RemoveUserEvent(userId: String) extends Event
case class ActiveUsers(users: Set[String] = Set.empty[String]) extends Event {
  def update(evt: Event) = evt match {
    case AddUserEvent(userId) => copy(users + userId)
    case RemoveUserEvent(userId) => copy(users.filterNot(_ == userId))
  }
  override def toString = s"$users"
}
