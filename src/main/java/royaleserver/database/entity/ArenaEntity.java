package royaleserver.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "arenas")
@NamedQuery(name = "ArenaEntity.all", query = "SELECT arenaEntity FROM ArenaEntity arenaEntity")
public class ArenaEntity extends LogicEntity<ArenaEntity> {
	public ArenaEntity() {}

	public ArenaEntity(String name) {
		super(name);
	}
}
