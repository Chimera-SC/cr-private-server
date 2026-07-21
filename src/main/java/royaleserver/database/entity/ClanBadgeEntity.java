package royaleserver.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "clan_badges")
@NamedQuery(name = "ClanBadgeEntity.all", query = "SELECT clanBadgeEntity FROM ClanBadgeEntity clanBadgeEntity")
public class ClanBadgeEntity extends LogicEntity<ClanBadgeEntity> {
	public ClanBadgeEntity() {}

	public ClanBadgeEntity(String name) {
		super(name);
	}
}
