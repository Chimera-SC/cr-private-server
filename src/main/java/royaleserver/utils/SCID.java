package royaleserver.utils;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public final class SCID implements UserType<SCID>, Serializable {
	private int high, low;
	private long value;

	public SCID() {
		this(0, 0);
	}

	public SCID(int high, int low) {
		this.high = high;
		this.low = low;

		value = high * 1000000 + low;
	}

	public SCID(long value) {
		this((int)(value / 1000000), (int)(value % 1000000));
	}

	public int getHigh() {
		return high;
	}

	public int getLow() {
		return low;
	}

	public long getValue() {
		return value;
	}

	// Java

	@Override
	public int hashCode() {
		return (int)getValue();
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof SCID) {
			return getValue() == ((SCID)o).getValue();
		}

		return super.equals(o);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new SCID(high, low);
	}

	@Override
	public String toString() {
		return (new StringBuilder())
				.append("SCID(high = ").append(high)
				.append(", low = ").append(low)
				.append(", value = ").append(getValue())
				.append(")").toString();
	}


	// Hibernate

	@Override
	public int getSqlType() {
		return Types.BIGINT;
	}

	@Override
	public Class<SCID> returnedClass() {
		return SCID.class;
	}

	@Override
	public boolean equals(SCID x, SCID y) throws HibernateException {
		if (x == null || y == null) {
			return x == y;
		}

		return x.equals(y);
	}

	@Override
	public int hashCode(SCID x) throws HibernateException {
		return x.hashCode();
	}

	@Override
	public SCID nullSafeGet(ResultSet rs, int position, SharedSessionContractImplementor session, Object owner) throws HibernateException, SQLException {
		final String value = rs.getString(position);
		if (value == null) {
			return null;
		}

		return new SCID(Long.valueOf(value));
	}

	@Override
	public void nullSafeSet(PreparedStatement st, SCID value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {
		if (value == null) {
			st.setNull(index, Types.BIGINT);
			return;
		}

		st.setLong(index, value.getValue());
	}

	@Override
	public SCID deepCopy(SCID value) throws HibernateException {
		return value;
	}

	@Override
	public boolean isMutable() {
		return false;
	}

	@Override
	public Serializable disassemble(SCID value) throws HibernateException {
		return value;
	}

	@Override
	public SCID assemble(Serializable cached, Object owner) throws HibernateException {
		return (SCID)cached;
	}

	@Override
	public SCID replace(SCID original, SCID target, Object owner) throws HibernateException {
		return original;
	}
}