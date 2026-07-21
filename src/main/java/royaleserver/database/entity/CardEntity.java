package royaleserver.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "cards")
@NamedQuery(name = "CardEntity.all", query = "SELECT cardEntity FROM CardEntity cardEntity")
public class CardEntity extends LogicEntity<CardEntity> {
	public CardEntity() {}

	public CardEntity(String name) {
		super(name);
	}
}
