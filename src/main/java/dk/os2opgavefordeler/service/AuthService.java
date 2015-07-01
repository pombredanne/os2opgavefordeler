package dk.os2opgavefordeler.service;

import dk.os2opgavefordeler.model.IdentityProvider;
import dk.os2opgavefordeler.model.User;
import dk.os2opgavefordeler.model.presentation.IdentityProviderPO;

import java.net.URI;
import java.util.List;
import java.util.Optional;

public interface AuthService {
	Optional<IdentityProvider> findProvider(int id);

	List<IdentityProvider> identityProviderList();
	List<IdentityProviderPO> identityProviderPOList();

	String generateCsrfToken();

	/**
	 * Begins OpenID Connect authentication flow.
	 * @return 3rd-party URI which the client should be redirected to;
	 * @param idp
	 */
	URI beginAuthenticationFlow(IdentityProvider idp, String token, String callbackUrl) throws AuthenticationException;

	/**
	 * Finalizes OpenID Connect authentication flow.
	 * @param idp
	 * @param expectedState
	 * @return the authenticated User
	 * @throws hissy fits if the user can't be authenticated
	 */
	User finalizeAuthenticationFlow(IdentityProvider idp, String token, String callbackUrl, URI requestUri) throws AuthenticationException;
}
