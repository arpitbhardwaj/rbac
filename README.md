#### Role Based Access Control

###### Description:

Implement a role based auth system. System should be able to assign a role to user and remove a user from the role.

Entities are USER, ACTION TYPE, RESOURCE, ROLE

ACTION TYPE defines the access level(Ex: READ, WRITE, DELETE)

Access to resources for users are controlled strictly by the role.One user can have multiple roles. Given a user, action type and resource system should be able to tell whether user has access or not.


###### How to test:

Run Application.java