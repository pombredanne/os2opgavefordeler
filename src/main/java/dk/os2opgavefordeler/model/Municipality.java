package dk.os2opgavefordeler.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author hlo@miracle.dk
 */
@Entity
public class Municipality implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;


	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Municipality{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}