package royaleserver.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "chests")
@NamedQuery(name = "ChestEntity.all", query = "SELECT chestEntity FROM ChestEntity chestEntity")
public class ChestEntity extends LogicEntity<ChestEntity> {
	public ChestEntity() {}

	public ChestEntity(String name) {
		super(name);
	}
}
