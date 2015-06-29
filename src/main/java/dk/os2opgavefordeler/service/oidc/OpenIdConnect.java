package dk.os2opgavefordeler.service.oidc;

import com.nimbusds.jwt.ReadOnlyJWTClaimsSet;
import dk.os2opgavefordeler.model.IdentityProvider;

import java.net.URI;

public interface OpenIdConnect {
	URI beginAuthenticationFlow(IdentityProvider idp, String token, String callbackUrl)
	throws Throwable;

	ReadOnlyJWTClaimsSet finalizeAuthenticationFlow(IdentityProvider idp, String token, String callbackUrl, URI requestUri)
	throws Throwable;
}
