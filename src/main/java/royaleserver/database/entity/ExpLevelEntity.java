package royaleserver.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "exp_levels")
@NamedQuery(name = "ExpLevelEntity.all", query = "SELECT expLevelEntity FROM ExpLevelEntity expLevelEntity")
public class ExpLevelEntity extends LogicEntity<ExpLevelEntity> {
	public ExpLevelEntity() {}

	public ExpLevelEntity(String name) {
		super(name);
	}
}
