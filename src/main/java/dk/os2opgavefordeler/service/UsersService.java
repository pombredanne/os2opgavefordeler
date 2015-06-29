package dk.os2opgavefordeler.service;

import dk.os2opgavefordeler.model.Role;
import dk.os2opgavefordeler.model.User;
import dk.os2opgavefordeler.model.UserSettings;
import dk.os2opgavefordeler.model.presentation.RolePO;
import dk.os2opgavefordeler.model.presentation.UserSettingsPO;

import java.util.List;
import java.util.Optional;

/**
 * @author hlo@miracle.dk
 */
public interface UsersService {
	Optional<User> findById(int userId);
	Optional<User> findByEmail(String email);
	User createUser(User user);

	List<RolePO> getRoles(long userId);

	void createRole(Role role);

	UserSettingsPO getSettings(long userId);

	void createUserSettings(UserSettings userSettings);

	void updateSettings(UserSettingsPO settings);
}
