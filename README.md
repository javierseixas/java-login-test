SCHIBSTED TEST
==============

## Users details

* user1/pass1 -> access page 1
* user2/pass2 -> access page 2
* user3/pass3 -> access page 3
* user4/pass4 -> access page 1 and 3

## Necessary improvements

* Session system should be implemented as stateless, for not depending on Servlet HttpSession objects. There should be some class to create cookie based on some id, and also some mechanism to persist this id related to the logged user. This implementation must be on the infrastructure layer, and decoupling LogoutUser service from this classes implementations.