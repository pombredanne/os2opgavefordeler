package dk.os2opgavefordeler.model;

import com.google.common.collect.ImmutableList;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = Kle.TABLE_NAME)
public class Kle implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String TABLE_NAME = "Kle";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;

	@ManyToOne(cascade = CascadeType.ALL)
	private Kle parent;

	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Kle> children = new ArrayList<>();


	@Column(nullable = false)
	private String number;

	@Column(nullable = false)
	private String title;

	@Lob
	private String description;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateCreated;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Municipality municipality;

	public Kle() {
		//for JPA
		this.number = null;
		this.title = null;
		this.description = null;
		this.dateCreated = new Date();
	}

	public Kle(String number, String title, String description, Date dateCreated) {
		this.number = number;
		this.title = title;
		this.description = description;
		this.dateCreated = dateCreated;
	}

	public Kle(String number, String title, String description, Date dateCreated, List<Kle> children) {
		this(number, title, description, dateCreated);
		children.forEach(this::addChild);
	}

	public void addChild(Kle child) {
		child.setParent(this);
		if(!children.contains(child)) {
			children.add(child);
		}
	}

	public Kle getParent() {
		return parent;
	}

	public void setParent(Kle parent) {
		if(this.parent != null && this.parent != parent) {
			this.parent.children.remove(this);
		}
		this.parent = parent;
	}

	public ImmutableList<Kle> getChildren() {
		return ImmutableList.copyOf(children);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateCreated() {
		return new Date(dateCreated.getTime());
	}

	public Municipality getMunicipality() {
		return municipality;
	}

	public void setMunicipality(Municipality municipality) {
		this.municipality = municipality;
	}

	@Override
	public String toString() {
		return String.format("Kle<%s,%s>", number, title);
	}
}
