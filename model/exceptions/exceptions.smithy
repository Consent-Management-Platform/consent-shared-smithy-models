$version: "2.0"

namespace com.consentframework.shared.models.exceptions

@documentation("This exception is thrown when the request is invalid.")
@error("client")
@httpError(400)
structure BadRequestException {
    message: String
}

@documentation("This exception is thrown when the requested entity is not found.")
@error("client")
@httpError(404)
structure NotFoundException {
    message: String
}

@documentation("This exception is thrown when a write request conflicts with stored state.")
@error("client")
@httpError(409)
structure ConflictingResourceException {
    message: String
}

@documentation("This exception is thrown on an unhandled service error.")
@error("server")
@httpError(500)
structure InternalServiceException {
    message: String
}
