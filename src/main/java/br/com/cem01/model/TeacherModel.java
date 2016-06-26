package br.com.cem01.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.cem01.model.DisciplineModel;

@Entity
@Table(name="teacher")
public class TeacherModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@ManyToMany(mappedBy="teacherList", fetch = FetchType.EAGER)
	private List<DisciplineModel> disciplines;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<DisciplineModel> getDisciplines() {
		return disciplines;
	}

	public void setDisciplines(List<DisciplineModel> disciplines) {
		this.disciplines = disciplines;
	}
}
