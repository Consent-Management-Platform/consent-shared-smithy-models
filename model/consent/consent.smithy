$version: "2.0"

namespace com.consentframework.shared.models.consent

@documentation("Record of user consent.")
structure Consent {
    @required
    consentId: ConsentId

    @required
    consentVersion: Integer

    @required
    userId: UserId

    @required
    serviceId: ServiceId

    @required
    status: ConsentStatus

    consentType: ConsentType

    consentData: ConsentData

    expiryTime: ConsentExpiryTime
}

list ConsentList {
    member: Consent
}
