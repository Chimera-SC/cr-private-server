package royaleserver.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "clan_roles")
@NamedQuery(name = "ClanRoleEntity.all", query = "SELECT clanRoleEntity FROM ClanRoleEntity clanRoleEntity")
public class ClanRoleEntity extends LogicEntity<ClanRoleEntity> {
	public ClanRoleEntity() {}

	public ClanRoleEntity(String name) {
		super(name);
	}
}
